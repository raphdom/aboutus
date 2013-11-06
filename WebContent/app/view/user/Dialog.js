Ext.define('AboutUs.view.user.Dialog', {
    extend: 'AboutUs.view.common.Dialog',
    
    alias: 'widget.userdialog',
    
    title: 'Utilizador',
    
    layout:'fit',
    
    urlLoad: 'user/get.action',
    urlSubmit: 'user/create.action',
    
    items:[{
    
    	xtype: 'usertabpanel'
        
    }]
    
});