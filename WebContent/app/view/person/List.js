Ext.define('AboutUs.view.person.List', {
	extend: 'AboutUs.view.common.List',
    
    alias: 'widget.personlist',
    
    title : 'Pessoas',
    
    store: 'PersonStore',
    
    icon:'resources/images/person.png',
    
    dialog: 'AboutUs.view.person.Dialog',
    dialogSearch: 'AboutUs.view.person.Search',
    
    
    columns: [
    {
    	header: "Nome",
		width: 170,
		flex:1,
		dataIndex: 'name'
	}],
	
	initComponent: function() {
		this.callParent(arguments);
	}
    
});