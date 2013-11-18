Ext.define('AboutUs.view.common.List', {
    extend: 'Ext.grid.Panel',

    alias: 'widget.commonlist',
    
    selType: 'checkboxmodel',
    
    editColumn:true,
    
    hidetoolbar:false,
    
	initComponent: function(){
		if (this.hidetoolbar!=true){
			
			var searchMenu = new Array();
			Ext.Array.each(this.columns, function(column, index, countriesItSelf) {
			    searchMenu.push({
			    	text: 'Procurar por '+ column.header,
			    	dataIndex: column.dataIndex,
			    	header: column.header,
			    	checked: false
			    })
			});
			
			this.dockedItems = [{
			    xtype: 'toolbar',
			    dock: 'top',
			   items: [{
	                icon: 'resources/images/add.png',
	                itemId: 'add',
	                text: 'Adicionar',
	                action: 'add'
	                
	            },{
	                icon: 'resources/images/delete.png',
	                text: 'Eliminar',
	                action: 'delete'
	                
	            },'->',{
					xtype:'splitbutton',
					icon: 'resources/images/magnifier.png',                
	                text: 'Pesquisar',
	                action: 'search',
	                menu: searchMenu
	            }]
			},{
			 	xtype: 'pagingtoolbar',
		        dock: 'bottom',
		        displayInfo: true,
		        store:this.store
			},{
				xtype:'criteriacontainer',
				dock: 'top'
			}];
		}
		
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
        AboutUs.app.getStore(this.store).clearFilter();
        this.callParent(arguments);
    }
    
    
    
});