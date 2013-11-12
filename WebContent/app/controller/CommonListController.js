Ext.define('AboutUs.controller.CommonListController', {
    extend: 'Ext.app.Controller',
    
    views: ['common.List','common.Dialog', 'common.Form'],
    
    refs: [{
        ref: 'commonList',
        selector: 'commonlist'
    },{
    	ref: 'commonDialog',
        selector: 'commondialog'
    },{
    	ref: 'commonsearch',
        selector: 'commonsearch'
    },{
    	ref: 'commonForm',
        selector: 'commonform'
    }],
    
	 init: function() {
	    this.control({
	 		'commonlist button[action=add]': {
				click: this.onAdd
			},
			'commondialog button[action=cancel]': {
				click: this.onDialogCancel
			},
			'commonlist button[action=delete]': {
				click: this.onDelete
			},
			'commonlist button[action=search]': {
				click: this.onSearch
			},
			'commonlist':{
				editRecord: this.onEdit
			},
			'commondialog button[action=save]': {
				click: this.onSave
			},
			'usersearch button[action=search]': {
	 			click: this.onDoSearch
	 		}
	    });
	},
	
	getControllerName: function(){
		return this.getCommonList().controller;
	},
	
	processActionMenu: function(){
		
		var centerContainer = this.getController('MainController').getMainContainer().down('container[itemId=centerContainer]');
    	centerContainer.removeAll();
    	if (this.getCommonsearch() != undefined){
    		this.getCommonsearch().destroy();
    	}
		
	},
	
	onAdd: function(button, event, options) {
    	console.log('CommonController.onAdd()');
    	Ext.create(this.getCommonList().dialog).show();
    	if (this.getController(this.getControllerName()).onAfterAdd != undefined){
    		this.getController(this.getControllerName()).onAfterAdd(button,event,options);	
    	}
    },
    
    onDialogCancel: function(button, event, options) {
    	console.log('CommonController.onDialogCancel()');
    	button.up('commonDialog').hide();
    },
    
    onEdit: function(button, record) {
    	console.log('CommonController.onEdit()');
    	Ext.create(this.getCommonList().dialog).show();
    	this.getCommonDialog().down('form').getForm().load({
        	url:this.getCommonDialog().urlLoad,
        	scope:this,
        	params: {
        		id: record.get('id')
    		},
        	success: function(form, response) {
		    	if (this.getController(this.getControllerName()).onGetDataSuccess != undefined){
		    		this.getController(this.getControllerName()).onGetDataSuccess(response);	
		    	}
        		
        	}	
    	});
    	
    },
    
    onDelete: function(button, event, options) {
    	console.log('CommonController.onDelete()');
    	if (this.getCommonList().getSelectionModel().getSelection().length > 0){
    		
    	}else{
    		AboutUs.util.NotificationUtil.showNotificationError("Você deve selecionar um registo.");
    	}
    },
    
    onSearch: function(button, event, options) {
    	console.log('CommonController.onSearch()');
    	if (this.getCommonsearch() == undefined){
    		Ext.create(this.getCommonList().dialogSearch).show();
    	}else{
    		this.getCommonsearch().show();
    	}
    },
    
    onSave: function(button, event, options) {
    	console.log('CommonController.onSave()');
    	var win = button.up('window'),
            form = win.down('form');
    	if (!form.isValid()){
    		AboutUs.util.NotificationUtil.showNotificationError("Preencha os campos obrigatórios!");
    		return;
    	}
    	if (this.getController(this.getControllerName()).onBeforeSaveData != undefined){
    		this.getController(this.getControllerName()).onBeforeSaveData();	
    	}
    	
        form.submit({
        	url:this.getCommonDialog().urlSubmit,
        	scope:this,
        	success: function(form, action) {
        		win.hide();
        		this.getCommonList().getStore().reload();
            },
            failure: function(form, action) {
                AboutUs.util.NotificationUtil.showNotificationError("Erro ao guardar!");
            }
        });
    },
    
    onDoSearch: function(button, event, options) {
    	console.log('CommonController.onDoSearch()');
    	var win = this.getCommonsearch();
        var store = this.getCommonList().store;
        var form = win.down('form');
        var values = form.getValues();
        var filters = [];
 
        for (var p in values) {
        	var value = values[p];
        	var field =  form.getForm().findField(p);
        	if (value) {
        		filters.push({ property: p, value: value , type: field.xtype});
        	}
        }
 
        win.hide();
 
        if (filters.length) {
        	store.clearFilter(true);
        	store.filter(filters);
        } else {
        	store.clearFilter();
        }
    }
    
});