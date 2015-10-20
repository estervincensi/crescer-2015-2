function carrinhoDeCompras(){
   itens = [];
}
carrinhoDeCompras.prototype.adicionarItem= function (sku){
};

carrinhoDeCompras.prototype.removerItens = function(sku){
  
};

function item(sku, descricao, quantidade, valorUnitario){
    this.sku=sku;
    this.descricao=descricao;
    this.quantidade=quantidade;
    this.valorUnitario=valorUnitario;
}
