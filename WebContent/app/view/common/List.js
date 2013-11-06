Ext.define('AboutUs.view.common.List', {
    extend: 'Ext.grid.Panel',

    alias: 'widget.commonlist',
    
    selType: 'checkboxmodel',
    
    editColumn:true,
    
	initComponent: function(){
		
		this.dockedItems = [{
		    xtype: 'toolbar',
		    dock: 'top',
		   items: [{
                icon: 'resources/images/add.png',
                itemId: 'add',
                text: 'Adicionar',
                action: 'add',
                iconAlign: 'top'
            },{
                icon: 'resources/images/delete.png',
                text: 'Eliminar',
                action: 'delete',
                iconAlign: 'top'
            },{
				icon: 'resources/images/magnifier.png',                
                text: 'Pesquisar',
                action: 'search',
                iconAlign: 'top'
            }]
		},{
		 	xtype: 'pagingtoolbar',
	        dock: 'bottom',
	        displayInfo: true,
	        store:this.store
		}];
		
		if (this.editColumn){
			var columnsList = this.columns;
			
			this.columns = [{
	            xtype:'actioncolumn',
	            width:30,
	            hideable:false,
	            menuDisabled:true,
	            resizable:false,
	            items: [{
	                icon: 'resources/images/edit.png',
	                tooltip: 'Editar',
	                handler: function(grid, rowIndex, colIndex) {
	                    var rec = grid.getStore().getAt(rowIndex);
	                    if(rec){
	    					this.up('commonlist').fireEvent('editRecord', this, rec);
	    				}
	                }
	            	}]
			}]; 
			this.columns.push.apply(this.columns,columnsList);
		}
		
        this.addEvents('editRecord');
        this.callParent(arguments);
    }
    
    
    
});