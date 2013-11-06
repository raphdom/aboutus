Ext.define('AboutUs.view.menu.MenuContainer', {
    extend: 'Ext.container.Container',
    xtype: 'menuContainer',
    
    layout: 'accordion',
    
    items:[{
    	title: 'Utilizadores',
    	itemId:'users',
    	icon:'resources/images/userManager.png',
    	xtype:'menu-list',
    	menuItems:[
    	       {
    	    	   title:'Utilizadores',
    	    	   icon:'resources/images/user.png',
    	    	   controller:'UserController',
    	    	   type:'list'
    	       },
    	       {
    	    	   title:'Grupos',
    	    	   icon:'resources/images/groupManager.png',
    	    	   controller:'GroupController',
    	    	   type:'list'
    	       }
    	       ]
    },{
        title: 'Igreja',
        itemId:'church',
        icon:'resources/images/church.png',
        xtype:'menu-list',
    	menuItems:[
    	       {
    	    	   title:'Pessoas',
    	    	   icon:'resources/images/personManager.png',
    	    	   controller:'PersonController',
    	    	   type:'list'
    	       },
    	       {
    	    	   title:'Igrejas',
    	    	   icon:'resources/images/church.png',
    	    	   controller:'ChurchController',
    	    	   type:'list'
    	       }
    	       ]
    },{
        title: 'Site',
        itemId:'webSite',
        icon:'resources/images/globe.png',
        xtype:'menu-list',
    	menuItems:[
    	       {
    	    	   title:'Categorias',
    	    	   icon:'resources/images/categories.png'
    	       },
    	       {
    	    	   title:'Artigos',
    	    	   icon:'resources/images/article.png'
    	       },
    	       {
    	    	   title:'V�deos',
    	    	   icon:'resources/images/videos.png'
    	       },
    	       {
    	    	   title:'Albuns',
    	    	   icon:'resources/images/albuns.png'
    	       },
    	       {
    	    	   title:'Banners',
    	    	   icon:'resources/images/banners.png'
    	       }
    	       ]
    },{
        title: 'M�sica',
        itemId:'music',
        xtype:'menu-list',
        icon:'resources/images/music.png',
    	menuItems:[
    	       {
    	    	   title:'Listas de Reprodu��o',
    	    	   icon:'resources/images/playlist.png'
    	       },
    	       {
    	    	   title:'M�sicas',
    	    	   icon:'resources/images/music.png'
    	       }
    	       ]
    }]
    
});