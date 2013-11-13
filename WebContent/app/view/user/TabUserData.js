Ext.define('AboutUs.view.user.TabUserData', {
    extend: 'Ext.panel.Panel',
    
    alias: 'widget.usertabuserdata',
    
    title:'Dados',
    
    closable:false,
    
    items:[{
        layout: 'form',
        bodyPadding: 10,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        defaultType: 'textfield',
        items: [{
			fieldLabel: 'id',
			name : 'id',
			hidden:true
		},{
            fieldLabel: 'Email',
            name: 'email',
            allowBlank: false,
            vtype:'email'
        },{
            fieldLabel: 'Pessoa',
            name: 'person.id',
            xtype:'combo',
            allowBlank: false,
            store:'PersonStore',
            displayField:'name',
            valueField:'id'
        },{
        	xtype:'combo',
        	id:'church',
            fieldLabel: 'Igreja',
            name: 'church.id',
            allowBlank: false,
            displayField:'name',
            valueField:'id',
            store:'ChurchStore',
            listeners:{
            	change:function(combo, newValue, oldValue, eOpts){
            		combo.suspendEvent('change');
            		combo.setValue(newValue.name);
            		combo.resumeEvent('change');
            	}
            }
        },{
			name : 'groups',
			hidden:true
		},{
			name : 'permissions',
			hidden:true
		}]
    }]
    
    
});