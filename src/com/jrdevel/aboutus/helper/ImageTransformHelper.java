package com.jrdevel.aboutus.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.jrdevel.aboutus.util.images.ImageResizeAction;
import com.jrdevel.aboutus.util.images.ImageResizeRequest;
import com.jrdevel.aboutus.util.images.ImageResizeService;

/**
 * @author Raphael Domingues
 *
 */
public class ImageTransformHelper {
	
	public static final ImageSize DATA_TYPE_SMALL_1 = new ImageSize(60,60,1);
	public static final ImageSize DATA_TYPE_SMALL_2 = new ImageSize(128,128,2);
	public static final ImageSize DATA_TYPE_MEDIUM_1 = new ImageSize(500,500,3);
	public static final ImageSize DATA_TYPE_MEDIUM_2 = new ImageSize(800,800,4);
	
	private static final Logger logger = Logger.getLogger(ImageTransformHelper.class);
	
	private HashMap<ImageSize,byte[]> result = new HashMap<ImageSize,byte[]>();
	
	private byte[] resizeImage(InputStream stream, int width, int height, boolean exactlySize){
		ImageResizeRequest request;
		ImageResizeService handler = new ImageResizeService();

		request = new ImageResizeRequest();

		try {
			request.setSourceFileStream(stream);
			request.setTargetWidth(width);
			request.setTargetHeight(height);
			request.setResizeAction(ImageResizeAction.ALWAYS);
			request.setCropToAspect(exactlySize);
			handler.resize(request);
			return request.getDestinationByteArrayOutputStream().toByteArray();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	private class ScaleImage extends Thread {

		InputStream originalStream;
		ImageSize imageSize;
		boolean exactlySize;
		byte[] resultData;

		public ScaleImage(InputStream originalStream, ImageSize dataType, boolean exactlySize){
			this.originalStream=originalStream;
			this.imageSize=dataType;
			this.exactlySize=exactlySize;
		}

		public void run() {

			try {

				resultData = resizeImage(originalStream, imageSize.getWidth(), 
						imageSize.getHeight(),exactlySize);
				
				result.put(imageSize, resultData);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public HashMap<ImageSize,byte[]> transformImages(InputStream stream, ImageSize... dataTypes){

		long start = System.currentTimeMillis();

		List<Thread> threads = new ArrayList<Thread>();

		for (ImageSize dataType : dataTypes){
			Thread thread0 = new Thread(new ScaleImage(stream, dataType, true));
			thread0.start();
			threads.add(thread0);
		}

		int running = 0;
		do {
			running = 0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					running++;
				}
			}
		} while (running > 0);

		long end = System.currentTimeMillis();
		logger.info("Demorou " + ((end - start) / 1000) + " segundos");
		
		return result;

	}
	

}
