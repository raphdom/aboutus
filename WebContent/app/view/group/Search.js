Ext.define('AboutUs.view.group.Search', {
    extend: 'AboutUs.view.common.Search',
    
    alias: 'widget.grouopsearch',
    
    title: 'Grupo',
    
    items:[{
    	xtype: 'form',
        layout: 'form',
        url: 'user/create.action',
        bodyPadding: 10,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'Nome',
            name: 'name'
        }]
    }]
    
});