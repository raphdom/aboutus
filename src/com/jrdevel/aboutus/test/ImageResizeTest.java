package com.jrdevel.aboutus.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.jrdevel.aboutus.helper.ImageSize;
import com.jrdevel.aboutus.helper.ImageTransformHelper;

/**
 * @author Raphael Domingues
 *
 */
public class ImageResizeTest {
	
	public static void main(String args[]){
		
		File file = new File("/home/raphael/Imagens/bola.png");
		FileInputStream stream;
		try {
			stream = new FileInputStream(file);
			ImageTransformHelper imageTransform = new ImageTransformHelper();
			HashMap<ImageSize,byte[]> result = imageTransform.transformImages(stream, 
					ImageTransformHelper.DATA_TYPE_SMALL_2);
			
			System.out.println("byte[] length DATA_TYPE_SMALL_2 = "+result.get(ImageTransformHelper.DATA_TYPE_SMALL_2).length);
			
			File fileOutput = new File("/home/raphael/Imagens/bolaGerada.jpeg");
			FileOutputStream fos = new FileOutputStream(fileOutput);
			fos.write(result.get(ImageTransformHelper.DATA_TYPE_SMALL_2));
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
