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
    		dateReadFormat:'timestamp',
    		dateWriteFormat:'d-m-Y'
    	},{
    		name:'person_name',
    		type:'string',
			mapping:'person.name'
    	}],
    	
   	hasOne: {model: 'AboutUs.model.Person', foreignKey: 'userId', getterName: 'getPerson'},
   	hasMany: {model: 'AboutUs.model.Permission', foreignKey: 'userId', name:'permissions'}
   	
});