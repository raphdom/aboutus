Ext.define('AboutUs.model.User', {
    extend: 'Ext.data.Model',
    fields: [
    	{
    		name:'id',
    		type:'int'
    	},{
    		name:'email',
    		type:'string'
    	},{
    		name:'lastvisitDate',
    		type:'date',
    		dateReadFormat:'time',
    		dateWriteFormat:'d-m-Y'
    	},{
    		name:'activation',
    		type:'boolean'
		},{
    		name:'block',
    		type:'boolean'
    	},{
    		name:'personName',
    		type:'string',
			mapping:'person.name',
			persist:false
		},{
    		name:'churchName',
    		type:'string',
			mapping:'church.name',
			persist:false
    	}],
    	
   	hasOne: {model: 'AboutUs.model.Person', foreignKey: 'userId', getterName: 'getPerson'},
   	hasOne: {model: 'AboutUs.model.Church', foreignKey: 'userId', getterName: 'getChurch', setterName:'setChurch', name:'church'},
   	hasMany: [
   		{model: 'AboutUs.model.Permission', foreignKey: 'userId', name:'permissions'},
   		{model: 'AboutUs.model.Group', foreignKey: 'userId', name:'groups'}
	],
   	
   	proxy: {
        type: 'ajax',
        api: {
        	read : 'user/get.action',
            create : 'user/save.action',
            update: 'user/save.action',
            destroy: 'user/delete.action'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'associatedjson',
            writeAllFields: true,
            encode: false
        }
    }
   	
});