Ext.define('AboutUs.view.user.List', {
	extend: 'AboutUs.view.common.List',
    
    alias: 'widget.userlist',
    title : 'Utilizadores',
    store: 'UserStore',
    icon:'resources/images/user.png',
    dialog: 'AboutUs.view.user.Dialog',
    controller: 'UserController',
    columns: [
    {
    	header: "Nome",
		width: 170,
		flex:1,
		dataIndex: 'person_name'
	},{
		header: "Email",
		width: 170,
		flex:1,
		dataIndex: 'email'
	},{
		header: "Igreja",
		width: 170,
		flex:1,
		dataIndex: 'churchName',
		criteriaXtype:'combo'
	},{
		header: "Último acesso",
		width: 150,
		flex:1,
		dataIndex:'lastvisitDate',
		renderer: Ext.util.Format.dateRenderer('d-M-Y h:i a'),
		criteriaXtype:'datefield'
	}],
	
	initComponent: function() {
		this.callParent(arguments);
	}
    
});