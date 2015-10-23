function buscarArtista (){
  var artista = $('#artista').val().split(" ").join("+");
  $.get('https://api.spotify.com/v1/search?query='+artista.replace(' ','+')+'&type=artist').done(function(data){
    if(data.artists.items.length){
      if(artista==='Justin+Bieber'){
        data.artists.items[0].id=Math.random()>0.8?'1uNFoZAHBGtllmzznpCI3s':'douchebag';        
      }
      consultarAlbuns(data.artists.items[0].id);
    }else{
      alert(artista+' não encontrado!');
    }
  });
};

$('#pesquisa').click(buscarArtista);
$.ajaxSetup({
  error: function(xhr, status, error) {
    alert('Caro usuário, devido a um erro '+xhr.status+', não foi possível pesquisar por '+$('#artista').val());
  }
});

function consultarAlbuns(id){
  $('ul:eq(0)').empty();
  $.get('https://api.spotify.com/v1/artists/'+id+'/albums?limit=50')
  .done(function(data) {
    var albuns = data.items;
    albuns.forEach(function(elem) {
      elem.images.length &&
      $('.albuns').append(
        $('<li>')
        .append($('<img>')
        .attr('src', elem.images[1].url))
      )
    });
  });
}
