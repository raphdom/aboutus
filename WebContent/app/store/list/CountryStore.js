Ext.define('AboutUs.store.list.CountryStore', {
    extend: 'Ext.data.Store',
    model: 'AboutUs.model.list.Country',
    
    proxy: {
        type: 'ajax',
        api: {
        	read : 'list/country.action'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        }
    }
});