function carrinhoDeCompras(){
   this.itens = [];
}
carrinhoDeCompras.prototype.adicionarItem= function (item){
  this.itens.push(item);
};

carrinhoDeCompras.prototype.removerItens = function(sku){
  for(var i=0, len=this.itens.length; i<len; i++){
    if(this.itens[i].sku===sku){
      this.itens.splice(i,1);
    }
  }
};

carrinhoDeCompras.prototype.atualizar = function(sku,qtd){
  this.itens.map(function(elem){
    if(elem.sku===sku){
      return elem.quantidade=qtd;
    }
  });
};

carrinhoDeCompras.prototype.valorTotal = function(){
  var valorTotal = this.itens.map(function(elem){
    return elem.subTotal();
  }).reduce(function(acumulador,elem){
    return acumulador+elem;
  },0);
  if(this.sortear){
    return valorTotal - (valorTotal*0.1);
  }else{
    return valorTotal;
  }
}

carrinhoDeCompras.prototype.sortear = function(){
  return Math.random()<0.4;
}
