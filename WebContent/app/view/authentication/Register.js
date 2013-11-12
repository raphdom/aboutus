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
            name: 'church'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Morada da Igreja',
            name: 'address'
        },
        {
        	allowBlank: false,
            fieldLabel: 'País',
            xtype:'combo',
            name: 'country'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Nome do Responsável',
            name: 'respName'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Nome do site',
            name: 'siteName'
        },
        {
        	allowBlank: false,
            fieldLabel: 'Quantos membro tem sua igreja?',
            name: 'qtdMember'
        }
    ],
    
    buttons: [{ 
        	text:'Registar',
        	action:'register',
        	icon:'resources/images/next.png',
        	iconAlign: 'right'
        	
	}]
});