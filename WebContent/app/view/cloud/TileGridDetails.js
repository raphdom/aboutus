Ext.define('AboutUs.view.cloud.TileGridDetails' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.tilegriddetails',
    
    multiSelect: true,
    store:'CloudStore',
    
    columns: [{
            text: 'Nome',
            id: 'name',
            flex: 1,
            dataIndex: 'name'
        }, {
            text: 'Tipo',
            id: 'type',
            flex: 1,
            dataIndex: 'type'
        }, {
            text: 'Tamanho',
            id: 'size',
            flex: 1,
            dataIndex: 'size'
        }]
    
});