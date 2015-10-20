//Exercicio 01

//Exercicio 01.a
function ordenaPorNacionais(array){
  return array.sort(function(a,b){return a.titulos[0].qtd<b.titulos[0].qtd;});
};

//Exercicio 01.b
function ordenaPorContinental(array){
  return array.sort(function(a,b){return a.titulos[1].qtd<b.titulos[1].qtd;});
};

//Exercicio 01.c
function ordenaPorMundial(array){
  return array.sort(function(a,b){return a.titulos[2].qtd<b.titulos[2].qtd;});
};

//Exercicio 02

//Exercicio 02.a
function somarPorNacionais(array){
  var soma=0;
  array.forEach(function(elem){soma+=elem.titulos[0].qtd;});
  return soma;
};

//Exercicio 02.b
function somarPorContinentais(array){
  var soma=0;
  array.forEach(function(elem){soma+=elem.titulos[1].qtd;});
  return soma;
};

//Exercicio 02.c
function somarPorMundiais(array){
  var soma=0;
  array.forEach(function(elem){soma+=elem.titulos[2].qtd;});
  return soma;
};

//Exercicio 03
function apenasOsMelhores(array){
  return array.filter(function(elem){
    return elem.titulos[0].qtd>=18;
  })
};
