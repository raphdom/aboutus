Ext.define('AboutUs.view.user.Dialog', {
    extend: 'AboutUs.view.common.Dialog',
    
    alias: 'widget.userdialog',
    
    title: 'Utilizador',
    
    width:500,
    height:300,
    
    layout:'fit',
    
    urlLoad: 'user/get.action',
    urlSubmit: 'user/create.action',
    
    items:[{
    
    	xtype: 'usertabpanel'
        
    }]
    
});