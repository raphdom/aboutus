Ext.define('AboutUs.controller.UserController', {
    extend: 'AboutUs.controller.CommonListController',
    
    stores: ['UserStore'],

    models: ['Person',
    		 'User',
    		 'Church',
    		 'Permission'],

    views: ['user.List',
    		'user.Dialog',
    		'user.TabPanel',
    		'user.TabUserData',
    		'user.TabUserPermission'],
    
    refs: [{
        ref: 'userList',
        selector: 'userlist'
    },{
    	ref: 'userDialog',
    	selector: 'userdialog'
    },{
    	ref: 'groupList',
    	selector: 'usertabuserpermission grouplist'
    },{
    	ref: 'permissionList',
    	selector: 'usertabuserpermission permissionlist'
    }],
    
    init: function() {
        this.control({
     		
        });
    },
    
    processActionMenu: function(type){
    	
    	var centerContainer = this.getController('MainController').getMainContainer().down('container[itemId=centerContainer]');
    	
    	var list = Ext.create('AboutUs.view.user.List');
    	centerContainer.add(list);
    	//list.getStore().clearFilter();
    	
    },
    
    onBeforeSaveData: function(){
		var form = this.getUserDialog().down('form');
		
		var permissions = this.getPermissionList().getSelectionModel().getSelection();
		var permissionsJson = [];
		for (var i in permissions) {
			permissionsJson.push(permissions[i].data);
		}
		
		var groups = this.getGroupList().getSelectionModel().getSelection();
		var groupsJson = [];
		for (var i in groups) {
			groupsJson.push(groups[i].data);
		}

		form.getForm().findField('groups').setValue(Ext.encode(groupsJson));
		form.getForm().findField('permissions').setValue(Ext.encode(permissionsJson));
		
	},
	
	onGetDataSuccess:function(response){
		var data = response.result.data;
		
		var form = this.getUserDialog().down('form');
		
//		form.down('combo[id=person]').setValue(data.person.id);
//		form.down('combo[id=church]').setValue(data.church.id);
		
	}
    
});