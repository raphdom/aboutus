Ext.define('AboutUs.view.common.Dialog', {
    extend: 'Ext.window.Window',
    
    alias: 'widget.commondialog',
    
    modal: true,
    
    width: 400,
    
    buttons: [{
        text: 'Save',
        action:'save'
    },{
        text: 'Cancel',
        action:'cancel'
    }]
    
});