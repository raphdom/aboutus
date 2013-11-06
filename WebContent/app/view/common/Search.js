Ext.define('AboutUs.view.common.Search', {
    extend: 'Ext.window.Window',
    
    alias: 'widget.commonsearch',
    title: 'Procurar',
    modal: true,
    width: 400,
    layout:'fit',
    closeAction:'hide',
    buttons: [{
        text: 'Procurar',
        action:'search'
    },{
        text: 'Reset',
        action:'reset'
    },{
        text: 'Cancel',
        action:'cancel'
    }]
    
});