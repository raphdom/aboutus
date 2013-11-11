Ext.define('AboutUs.view.user.TabUserPermission', {
    extend: 'Ext.panel.Panel',
    
    alias: 'widget.usertabuserpermission',
    
    title:'Grupos/Permiss�es',
    
    header:false,
    
    layout:'fit',
   
    items:[{
    	xtype:'panel',
    	layout: {
            type: 'hbox',
            align: 'stretch'
        },
    	items:[{
    		title:'Grupos',
    		xtype:'grouplist',
    		flex:1,
    		hidetoolbar:true,
    		editColumn:false
    	},{
    		title:'Permiss�es',
    		xtype:'permissionlist',
    		flex:1
    	}]
    }]
    
    
});