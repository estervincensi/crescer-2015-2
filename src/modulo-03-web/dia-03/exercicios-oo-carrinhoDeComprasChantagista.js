function CarrinhoDeComprasChantagista(itens){
  CarrinhoDeCompras.apply(this,arguments);
};

CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

CarrinhoDeComprasChantagista.prototype.forcarCompra = function(){
  if(!this.intervalo){
    var self = this;
    this.intervalo = setInterval(function(){
      self.itens.forEach(function(elem){ //this em execução assincrona (setInterval, setTimeOut) morre.
        elem.valorUnitario += elem.valorUnitario*0.1;
      });
    },5000);
  }
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
};
