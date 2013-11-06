Ext.define('AboutUs.view.cloud.TreeCloudPanel' ,{
    extend: 'Ext.tree.Panel',
    alias : 'widget.treecloudpanel',
    
        title:'Pastas',
        region:'west',
        width: 200,
        collapsible: true,
        border:true,
        store:'FolderStore',
        tbar:[{
                xtype:'buttonsegment',
                items:[{
                        icon:'resources/images/add.png',
                        action:'add'
                },{
                        icon:'resources/images/edit.png',
                        action:'edit'
                },{
                        icon:'resources/images/delete.png',
                        action:'del'
                }]
        }]
    
});