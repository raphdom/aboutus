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
    		name:'churchName',
    		type:'string',
    		mapping:'church.name'
    	},{
    		name:'lastvisitDate',
    		type:'date',
    		dateReadFormat:'timestamp',
    		dateWriteFormat:'d-m-Y'
    	},{
    		name:'personName',
    		type:'string',
    		mapping:'person.name'
    	}],
    	
    associations: [
    	{ type: 'hasOne', model: 'Church' },
    	{ type: 'hasOne', model: 'Person' }
    ]
});