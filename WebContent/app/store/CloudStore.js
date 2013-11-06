Ext.define('AboutUs.store.CloudStore', {
    extend: 'Ext.data.Store',

    model: 'AboutUs.model.File',
    
    data: [{
            name: 'aimagemTeste001.jpg',
            type: 'image',
            url:'thumbs/imagem001.jpg',
            url2:'thumbs/imagem001_2.jpg',
            size:'5KB'
        },{
            name: 'cimagemTeste002.jpg',
            type: 'image',
            url:'thumbs/imagem002.jpg',
            url2:'thumbs/imagem002_2.jpg',
            size:'10KB'
        },{
            name: 'fimagemTeste003.jpg',
            type: 'image',
            url:'thumbs/imagem003.jpg',
            url2:'thumbs/imagem003_2.jpg',
            size:'120KB'
        },{
            name: 'kimagemTeste004.jpg',
            type: 'image',
            url:'thumbs/imagem004.jpg',
            url2:'thumbs/imagem004_2.jpg',
            size:'5KB'
        },{
            name: 'bimagemTeste005.jpg',
            type: 'image',
            url:'thumbs/imagem005.jpg',
            url2:'thumbs/imagem005_2.jpg',
            size:'133KB'
        },{
            name: 'aimagemTeste006.jpg',
            type: 'image',
            url:'thumbs/imagem006.jpg',
            url2:'thumbs/imagem006_2.jpg',
            size:'45KB'
        },{
            name: 'gimagemTeste007.jpg',
            type: 'image',
            url:'thumbs/imagem007.jpg',
            url2:'thumbs/imagem007_2.jpg',
            size:'135KB'
        },{
            name: 'dimagemTeste008.jpg',
            type: 'image',
            url:'thumbs/imagem008.jpg',
            url2:'thumbs/imagem008_2.jpg',
            size:'52KB'
        },{
            name: 'document001.doc',
            type: 'document',
            url:null,
            url2:null,
            size:'122KB'
        }]
});