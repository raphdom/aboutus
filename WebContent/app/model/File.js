Ext.define('AboutUs.model.File', {
        extend: 'Ext.data.Model',
        fields: [
                'filename',
                'filetype',
                'filesize',
                {
                        name:'shortName',
                        convert:function(v,record){
                                return Ext.util.Format.ellipsis(record.data.filename, 15);
                        }
                },{
                        name:'url0',
                        convert:function(v, record){
                        	return "cloud/getImage.action?imageId="+record.data.id+"&dataType=0"
                        }
                },{
                        name:'url1',
                        convert:function(v, record){
                        	return "cloud/getImage.action?imageId="+record.data.id+"&dataType=1"
                        }
                },{
                        name:'url2',
                        convert:function(v, record){
                            return "cloud/getImage.action?imageId="+record.data.id+"&dataType=2"
                        }
                }
		]
});