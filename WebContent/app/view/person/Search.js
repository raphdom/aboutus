Ext.define('AboutUs.view.person.Search', {
    extend: 'AboutUs.view.common.Search',
    
    alias: 'widget.personsearch',
    
    title: 'Pessoa',
    
    items:[{
    	xtype: 'form',
        layout: 'form',
        url: 'church/create.action',
        bodyPadding: 10,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'Name',
            name: 'name'
        }]
    }]
    
});