Ext.define('AboutUs.model.File', {
        extend: 'Ext.data.Model',
        fields: [
                'filename', 
                {
                        name:'shortName',
                        convert:function(v,record){
                                return Ext.util.Format.ellipsis(record.data.filename, 15);
                        }
                },
                'filetype',
                {
                        name:'url',
                        convert:function(v, record){
                                if (v==null){
                                        return "thumbs/unknown.png"
                                }else{
                                        return v;
                                }
                        }
                },
                {
                        name:'url2',
                        convert:function(v, record){
                                if (v==null){
                                        return "thumbs/unknown.png"
                                }else{
                                        return v;
                                }
                        }
                },
                'filesize'
                ]
});