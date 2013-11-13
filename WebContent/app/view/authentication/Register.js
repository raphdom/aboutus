Ext.define('AboutUs.view.authentication.Register', {
    extend: 'Ext.form.Panel',
    xtype: 'registerForm',
    
    url:'register.action',
    title: 'Registar',
    frame:true,
    width: 700,
    bodyPadding: 10,
    icon:'resources/images/lock.png',
    
    defaultType: 'textfield',
    defaults: {
        anchor: '100%'
    },
    fieldDefaults: {
        msgTarget: 'side',
        labelWidth: 200
    },
    
    plugins:['validationMessages'],
    
    items: [
        {
            allowBlank: false,
            fieldLabel: 'Email',
            name: 'email',
            emptyText: 'Email'
        },
        {
            allowBlank: false,
            fieldLabel: 'Palavra-chave',
            name: 'password',
            emptyText: 'Palavra-chave',
            inputType: 'password'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Igreja',
            name: 'churchName'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Morada da Igreja',
            name: 'churchAddress'
        },
        {
        	allowBlank: false,
            fieldLabel: 'País',
            xtype:'combo',
            store:'list.CountryStore',
            valueField:'value',
            forceSelection:true,
            displayField:'text',
            name: 'country',
            queryMode:'local'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Nome do Responsável',
            name: 'nameResp'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Nome do site',
            name: 'siteAlias'
        },
        {
            fieldLabel: 'Quantos membro tem sua igreja?',
            name: 'qtdMembers'
        }
    ],
    
    buttons: [{ 
        	text:'Registar',
        	action:'register',
        	icon:'resources/images/next.png',
        	iconAlign: 'right',
        	formBind: true,
            disabled: true
        	
	}]
});