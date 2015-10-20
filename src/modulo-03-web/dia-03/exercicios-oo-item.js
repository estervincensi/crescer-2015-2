function item(sku, descricao, quantidade, valorUnitario){
    this.sku=sku;
    this.descricao=descricao;
    this.quantidade=quantidade;
    this.valorUnitario=valorUnitario;
};

item.prototype.subTotal=function(){
  return this.quantidade*this.valorUnitario;
};
