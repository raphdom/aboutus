Ext.define('AboutUs.view.user.Search', {
    extend: 'AboutUs.view.common.Search',
    
    alias: 'widget.usersearch',
    
    title: 'Utilizador',
    
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
            fieldLabel: 'Email',
            name: 'email'
        }]
    }]
    
});