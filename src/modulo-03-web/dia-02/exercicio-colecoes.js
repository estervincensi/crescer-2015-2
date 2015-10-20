//Exercicio 01

//Exercicio 01.a
function ordenaPorNacionais(array){
  //return array.sort(function(a,b){return a.titulos[0].qtd<b.titulos[0].qtd;});
  return ordena(0,array);
};

//Exercicio 01.b
function ordenaPorContinental(array){
  //return array.sort(function(a,b){return a.titulos[1].qtd<b.titulos[1].qtd;});
  return ordena(1,array);
};

//Exercicio 01.c
function ordenaPorMundial(array){
  //return array.sort(function(a,b){return a.titulos[2].qtd<b.titulos[2].qtd;});
  return ordena(2,array);
};

function ordena(tipo,array){
   return array.sort(function(a,b){return a.titulos[tipo].qtd<b.titulos[tipo].qtd;});
}

//Exercicio 02

//Exercicio 02.a
function somarPorNacionais(array){
  return soma(0,array);
};

//Exercicio 02.b
function somarPorContinentais(array){
  return soma(1,array);
};

//Exercicio 02.c
function somarPorTodosTitulos(array){
  var somaTudo =0;
  somaTudo = somarPorNacionais(array)+somarPorContinentais(array)+soma(2,array);
  return somaTudo;
};

function soma(tipo,array){
  var soma=0;
  array.forEach(function(elem){soma+=elem.titulos[tipo].qtd;});
  return soma;
}

//Exercicio 03
function apenasOsMelhores(array){
  return array.filter(function(elem){
    return elem.titulos[0].qtd>18;
  })
};

//Exercicio 04
function calcularIdadeMedia(array){
  var soma = array
  .map(function(elem){
    return new Date().getFullYear()-elem.fundacao.getFullYear();
  })
  .reduce(function(acumulador, elem){
    return acumulador + elem;
  },0);
  return soma/clubes.length;
}
