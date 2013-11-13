Ext.define('AboutUs.view.common.Form', {
    extend: 'Ext.form.Panel',
    
    alias: 'widget.commonform',
    
    fieldDefaults: {
        labelWidth: 110,
        labelAlign: 'left',
        msgTarget: 'side',
        invalidCls: '' //unset the invalidCls so individual fields do not get styled as invalid
    },
    
     /*
     * Listen for validity change on the entire form and update the combined error icon
     */
    listeners: {
        fieldvaliditychange: function() {
            this.updateErrorState();
        },
        fielderrorchange: function() {
            this.updateErrorState();
        },
        afterrender:function(){
        	this.updateErrorState();
        }
    },

    updateErrorState: function() {
        var me = this,
            errorCmp, fields, errors;

            errorCmp = me.down('#formErrorState');
            fields = me.getForm().getFields();
            errors = [];
            fields.each(function(field) {
                Ext.Array.forEach(field.getErrors(), function(error) {
                    errors.push({name: field.getFieldLabel(), error: error});
                });
            });
            errorCmp.setErrors(errors);
            me.hasBeenDirty = true;
    },
    
    dockedItems: [{
    	cls: Ext.baseCSSPrefix + 'dd-drop-ok',
        xtype: 'container',
        dock: 'bottom',
        layout: {
            type: 'hbox',
            align: 'middle'
        },
        padding: '10 10 5',

        items: [{
            xtype: 'component',
            id: 'formErrorState',
            invalidCls: Ext.baseCSSPrefix + 'form-invalid-icon',
            validCls: Ext.baseCSSPrefix + 'dd-drop-icon',
            baseCls: 'form-error-state',
            flex: 1,
            validText: 'Formulário completo',
            invalidText: 'Formulário incompleto',
            tipTpl: Ext.create('Ext.XTemplate', '<ul class="' + Ext.plainListCls + '"><tpl for="."><li><span class="field-name">{name}</span>: <span class="error">{error}</span></li></tpl></ul>'),

            getTip: function() {
                var tip = this.tip;
                if (!tip) {
                    tip = this.tip = Ext.widget('tooltip', {
                        target: this.el,
                        title: 'Detalhes do erro:',
                        minWidth: 200,
                        autoHide: true,
                        anchor: 'bottom',
                        mouseOffset: [-11, -2],
                        closable: false,
                        constrainPosition: false,
                        cls: 'errors-tip'
                    });
                }
                return tip;
            },

            setErrors: function(errors) {
                var me = this,
                    tip = me.getTip();

                errors = Ext.Array.from(errors);

                // Update CSS class and tooltip content
                if (errors.length) {
                    me.addCls(me.invalidCls);
                    me.removeCls(me.validCls);
                    me.update(me.invalidText);
                    tip.setDisabled(false);
                    tip.update(me.tipTpl.apply(errors));
                } else {
                    me.addCls(me.validCls);
                    me.removeCls(me.invalidCls);
                    me.update(me.validText);
                    tip.setDisabled(true);
                    tip.hide();
                }
            }
        },{
        	xtype:'button',
        	text:'Cancelar',
        	action:'cancel'
    	}, {
            xtype: 'button',
            formBind: true,
            disabled: true,
            text: 'Guardar',
            action:'save'
        }]
    }]
    
});