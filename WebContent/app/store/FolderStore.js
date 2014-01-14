Ext.define('AboutUs.store.FolderStore', {
    extend: 'Ext.data.TreeStore',
    
    	autoLoad:true,
    	lazyFill: true,
    	proxy: {
         type: 'ajax',
         url: 'folder/view.action',
         reader: {
             type: 'json',
             root: 'data'
         }
     	}
     	
});