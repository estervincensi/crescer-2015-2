function Elfo(nome,flechas){
  this.nome=nome;
  this.flechas=flechas||42;

  /* NÃO FAZER DESSA FORMA!
    this.atirarFlechas= function(dwarf){
    console.log("atirando flecha...");
  }*/
};

Elfo.prototype.atirarFlechas = function(dwarf){
  console.log("atirando flecha...");
}
