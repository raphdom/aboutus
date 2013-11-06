Ext.define('AboutUs.view.person.Dialog', {
    extend: 'Ext.window.Window',
    
    alias: 'widget.persondialog',
    
    title: 'Pessoa',
    
    modal: true,
    
    width: 500,
    
    layout:'fit',
    
    items:[{
    
    	xtype: 'persontabpanel'
        
    }],
    
    buttons: [{
        text: 'Save',
        action:'save'
    },{
        text: 'Cancel',
        action:'cancel'
    }]
    
});