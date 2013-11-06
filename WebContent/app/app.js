Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'AboutUs': 'app'
    }
});
Ext.require('Ext.ux.window.Notification');
Ext.require('AboutUs.util.NotificationUtil');
Ext.application({
    name: 'AboutUs',
	
    controllers: [
        'CommonListController',
        'MainController',
        'CloudController',
        'MenuController',
        'UserController',
        'GroupController',
        'ChurchController',
        'PersonController'
    ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'mainContainer'
                }
            ]
        });
    }
});