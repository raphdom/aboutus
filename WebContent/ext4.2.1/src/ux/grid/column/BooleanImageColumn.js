Ext.define('Ext.ux.grid.column.BooleanImageColumn', {
    extend: 'Ext.grid.column.Column',
    alias: ['widget.booleanimagecolumn'],
    alternateClassName: 'Ext.ux.grid.BooleanImageColumn',

    defaultRenderer: function(value){
        if (value === undefined) {
            return "<img src='resources/images/cross.png' />";
        }
        
        if (!value || value === 'false') {
            return "<img src='resources/images/cross.png' />";
        }
        return "<img src='resources/images/tick2.png' />";
    }
});