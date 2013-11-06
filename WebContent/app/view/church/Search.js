Ext.define('AboutUs.view.church.Search', {
    extend: 'AboutUs.view.common.Search',
    
    alias: 'widget.churchsearch',
    
    title: 'Igreja',
    
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