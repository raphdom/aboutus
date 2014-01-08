Ext.define('AboutUs.model.Group', {
    extend: 'Ext.data.Model',
    fields: [
    	{
    		name:'id',
    		type:'int'
    	},{
    		name:'name',
    		type:'string'
    	}],
    	
    
    	hasMany: {model: 'Permission', name: 'permissions'},
    	belongsTo: {model: 'AboutUs.model.User', foreignKey: 'userId'}
});