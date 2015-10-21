//ElfoNoturno extends Elfo
ElfoNoturno.prototype = Object.create(Elfo.prototype); //Copia tudo o que tem na prototype do Elfo

function ElfoNoturno(nome,flechas){
  //super(nome,flechas)
  //Elfo.call(this, nome, flechas);
  Elfo.apply(this,arguments);
};

//overwrite
ElfoNoturno.prototype.atirarFlechas = function(dwarf){
  Elfo.prototype.atirarFlechas.call(this,dwarf); //super.atirarFlecha();
  console.log('novo atirar flecha');
};

//método estático = só não colocar prototype
ElfoNoturno.mediaDeAlturaDosElfosNoturnos = function(){
  return 2.15;
}
