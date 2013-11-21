Ext.define('AboutUs.controller.CommonListController', {
    extend: 'Ext.app.Controller',
    
    views: ['common.List',
    		'common.Dialog',
    		'common.Form',
    		'common.CriteriaContainer'],
    
    refs: [{
        ref: 'commonList',
        selector: 'commonlist'
    },{
    	ref: 'commonGrid',
        selector: 'commonlist grid'
    },{
    	ref: 'commonDialog',
        selector: 'commondialog'
    },{
    	ref: 'commonForm',
        selector: 'commonform'
    },{
    	ref: 'criteriaContainer',
        selector: 'criteriacontainer'
    }],
    
	 init: function() {
	    this.control({
	 		'commonlist button[action=add]': {
				click: this.onAdd
			},
			'commonlist button[action=delete]': {
				click: this.onDelete
			},
			'commonlist button[action=search]': {
				click: this.onDoSearch
			},
			'commonlist splitbutton[action=search] menu menucheckitem': {
				checkchange: this.onSearchCheckField
			},
			'commonlist':{
				editRecord: this.onEdit
			},
	 		'commonform button[action=save]': {
	 			click: this.onSave
	 		},
	 		'commonform button[action=cancel]': {
				click: this.onDialogCancel
			}
	    });
	},
	
	getControllerName: function(){
		return this.getCommonList().controller;
	},
	
	processActionMenu: function(){
		
		var centerContainer = this.getController('MainController').getMainContainer().down('container[itemId=centerContainer]');
    	centerContainer.removeAll();
		
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
    	button.up('commondialog').close();
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
        		
        		var titleUpdate = this.getCommonDialog().titleUpdate;
        		if (titleUpdate != undefined){
        			var dados = response.result.data;
        			this.getCommonDialog().setTitle(this.getCommonDialog().titleUpdate);	
        		}
        		
		    	if (this.getController(this.getControllerName()).onGetDataSuccess != undefined){
		    		this.getController(this.getControllerName()).onGetDataSuccess(response);	
		    	}
        		
        	}	
    	});
    	
    },
    
    onDelete: function(button, event, options) {
    	console.log('CommonController.onDelete()');
    	if (this.getCommonGrid().getSelectionModel().getSelection().length > 0){
    		
    	}else{
    		AboutUs.util.NotificationUtil.showNotificationError("Você deve selecionar um registo.");
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
        		this.getCommonGrid().getStore().reload();
            },
            failure: function(form, action) {
            	AboutUs.util.NotificationUtil.processMessages(action.result.messages);
                //AboutUs.util.NotificationUtil.showNotificationError("Erro ao guardar!");
            }
        });
    },
    
    onDoSearch: function(button, event, options) {
    	console.log('CommonController.onDoSearch()');
        var store = this.getCommonGrid().store;
        var form = this.getCriteriaContainer();
        var values = form.getValues();
        var filters = [];
 
        for (var p in values) {
        	var value = values[p];
        	var field =  form.getForm().findField(p);
        	if (value) {
        		filters.push({ property: p, value: value , type: field.xtype});
        	}
        }
 
        if (filters.length) {
        	store.clearFilter(true);
        	store.filter(filters);
        } else {
        	store.clearFilter();
        }
    },
    
    onSearchCheckField:function(menuItem, checked, options){
    	if (checked){
    		if (!menuItem.criteriaXtype){
    			menuItem.criteriaXtype= 'textfield'
    		}
	    	var field = Ext.widget(menuItem.criteriaXtype,{
	    		fieldLabel: menuItem.header,
				name : menuItem.dataIndex
	    	});
	    	this.getCriteriaContainer().add(field);
    	}else{
    		var field = this.getCriteriaContainer().down('[name='+menuItem.dataIndex+']');
    		this.getCriteriaContainer().remove(field);
    	}
    	if (this.getCriteriaContainer().items.length > 0){
    		this.getCriteriaContainer().setVisible(true);
    	}else{
    		this.getCriteriaContainer().setVisible(false);
    	}
    }
    
});
