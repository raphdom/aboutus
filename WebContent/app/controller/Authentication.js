Ext.define('AboutUs.controller.Authentication', {
    extend: 'Ext.app.Controller',

    views: ['authentication.Login'],
    
     refs: [{
        ref: 'loginForm',
        selector: 'loginForm'
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
	}
    
});