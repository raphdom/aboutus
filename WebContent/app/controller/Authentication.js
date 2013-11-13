Ext.define('AboutUs.controller.Authentication', {
    extend: 'Ext.app.Controller',

    views: ['authentication.Login','authentication.Register'],
    
    stores: ['list.CountryStore'],
    
     refs: [{
        ref: 'loginForm',
        selector: 'loginForm'
    },{
    	ref: 'registerForm',
        selector: 'registerForm'
    }],
    
    init: function() {
        this.control({
			'loginForm button[action=login]': {
         		click: this.onLogin
     		},
     		'loginForm textfield[name=email]': {
         		afterrender: this.onEmailAfterRender
     		},
     		'loginForm textfield': {
         		specialkey: this.submitOnEnter
     		},
     		'registerForm button[action=register]': {
         		click: this.onRegister
     		}
        });
    },
    
    onLogin: function(button){
    	if (this.getLoginForm().isValid()){
	    	this.getLoginForm().getForm().submit({
	    		scope:this,
	        	success: function(form, action) {
	        		window.location.href = "";
	            },
	            failure: function(form, action) {
	            	this.getLoginForm().down('textfield[name=password]').setValue("");
	            	this.getLoginForm().down('textfield[name=password]').focus(false,1000);
	            	AboutUs.util.NotificationUtil.showNotificationError(action.result.message);
	            }
	        });
    	}else{
    		AboutUs.util.NotificationUtil.showNotificationError("Preencha os campos obrigatórios!");
    	}
    },
    
    onEmailAfterRender: function(field){
    	field.focus(false, 1000);
    },
    
    submitOnEnter: function(field, event) {
		if (event.getKey() == event.ENTER) {
			this.onLogin();
		}
	},
	
	onRegister:function(button){
		if (this.getRegisterForm().isValid()){
	    	this.getRegisterForm().getForm().submit({
	    		scope:this,
	        	success: function(form, action) {
	        		window.location.href = "home.action";
	            },
	            failure: function(form, action) {
	            	AboutUs.util.NotificationUtil.processMessages(action.result.messages);
	            }
	        });
    	}else{
    		AboutUs.util.NotificationUtil.showNotificationError("Preencha todos os campos obrigatórios!");
    	}
	}
    
});