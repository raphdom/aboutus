Ext.define('AboutUs.controller.UserController', {
    extend: 'AboutUs.controller.CommonListController',
    
    stores: ['UserStore'],

    models: ['User','Church','Person'],

    views: ['user.List','user.Dialog','user.TabPanel','user.TabUserData','user.TabUserPermission', 'user.Search'],
    
    refs: [{
        ref: 'userlist',
        selector: 'userList'
    },{
    	ref: 'userdialog',
    	selector: 'userdialog'
   	 },{
    	ref: 'usersearch',
    	selector: 'usersearch'
    }],
    
    init: function() {
        this.control({
     		
        });
    },
    
    processActionMenu: function(type){
    	
    	var centerContainer = this.getController('MainController').getMainContainer().down('container[itemId=centerContainer]');
//    	centerContainer.removeAll();
    	
    	var list = Ext.create('AboutUs.view.user.List');
    	centerContainer.add(list);
    	list.getStore().clearFilter();
    	
    }
    
});