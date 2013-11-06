Ext.define('AboutUs.view.authentication.Login', {
    extend: 'Ext.form.Panel',
    xtype: 'loginForm',
    
    url:'login.action',
    title: 'Autenticação',
    frame:true,
    width: 400,
    bodyPadding: 10,
    icon:'resources/images/lock.png',
    
    defaultType: 'textfield',
    defaults: {
        anchor: '100%'
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
            xtype:'checkbox',
            fieldLabel: 'Lembrar',
            name: 'remember'
        }
    ],
    
    buttons: [{ 
        	text:'Entrar',
        	action:'login',
        	icon:'resources/images/next.png',
        	iconAlign: 'right'
        	
	}]
});