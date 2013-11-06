Ext.define('AboutUs.controller.MenuController', {
    extend: 'Ext.app.Controller',

    views: ['menu.MenuContainer','menu.Menu'],
    
    models:['ItemMenu'],
    
    refs: [{
        ref: 'menuContainer',
        selector: 'menuContainer'
    }],
    
    init: function() {
        this.control({
            'menuContainer > menu-list': {
                itemSelect: this.onItemSelect
            }
        });
    },
    
    menuSelected:undefined,
    
    onItemSelect: function(menu, title, type, controller) {
    	if ((menu.itemId != this.menuSelected) && this.menuSelected != undefined){
    		var oldMenuSelected = this.getMenuContainer().down("menu-list[itemId="+this.menuSelected+"]");
    		oldMenuSelected.clearSelection();
    		this.menuSelected = menu.itemId;
    	}else{
    		this.menuSelected = menu.itemId;
    	}
    	
    	this.getController('CommonListController').processActionMenu();
    	
    	var controller = this.getController(controller);
    	controller.processActionMenu(type);
    	
    }
    
});