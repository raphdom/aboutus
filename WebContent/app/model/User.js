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
    		name:'person_name',
    		type:'string',
			mapping:'person.name'
		},{
    		name:'church_name',
    		type:'string',
			mapping:'church.name'
    	}],
    	
   	hasOne: {model: 'AboutUs.model.Person', foreignKey: 'userId', getterName: 'getPerson'},
   	hasOne: {model: 'AboutUs.model.Church', foreignKey: 'userId', getterName: 'getChurch', setterName:'setChurch', name:'church'},
   	hasMany: {model: 'AboutUs.model.Permission', foreignKey: 'userId', name:'permissions'},
   	
   	proxy: {
        type: 'ajax',
        api: {
        	read : 'user/view.action',
            create : 'user/save.action',
            update: 'user/update.action',
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
            encode: false,
            root:'data'
        }
    }
   	
});