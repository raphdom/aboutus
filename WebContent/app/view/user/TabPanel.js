Ext.define('AboutUs.view.user.TabPanel', {
    extend: 'Ext.tab.Panel',
    
    alias: 'widget.usertabpanel',
    
    activeTab: 0,
    
    items:[{
    	xtype:'usertabuserdata'
    },{
    	xtype:'usertabuserpermission'
    }]
    
});