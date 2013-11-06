Ext.define('AboutUs.controller.PersonController', {
    extend: 'AboutUs.controller.CommonListController',
    
    stores: ['PersonStore'],

    models: ['Person'],

    views: [
    		'person.List',
    		'person.Dialog',
    		'person.TabPanel',
    		'person.TabData',
    		'person.TabChurchData',
    		'person.TabAddress',
    		'person.TabContact',
    		'person.TabObservation',
    		'person.Search'
    		],
    
    refs: [{
        ref: 'personlist',
        selector: 'personList'
    },{
    	ref: 'persondialog',
    	selector: 'personDialog'
   	 },{
    	ref: 'personsearch',
    	selector: 'personSearch'
    }],
    
    init: function() {
        this.control({
        });
    },
    
    processActionMenu: function(type){
    	
    	var centerContainer = this.getController('MainController').getMainContainer().down('container[itemId=centerContainer]');
    	
    	var list = Ext.create('AboutUs.view.person.List');
    	centerContainer.add(list);
    	list.getStore().clearFilter();
    	
    }
    
});