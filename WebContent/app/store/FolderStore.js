Ext.define('AboutUs.store.FolderStore', {
    extend: 'Ext.data.TreeStore',
    
    	proxy: {
         type: 'ajax',
         url: 'folder/view.action',
         reader: {
             type: 'json'
         }
     	}
     	
});