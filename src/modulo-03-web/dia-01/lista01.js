//Exercicio 01 - daisyGame

function daisyGame(numero){
  if (typeof numero === 'number') { //só verifica se for número senao ela nao verifica
    return 'Love me'+(numero %2===0 ?'not':'');
  }else{
    throw new Error("Pétalas não é um numero!");
  }
};

//Exercicio 02

function maiorTexto(array){
  var maior='';
  for(var i=0; i<array.length; i++){
    if (typeof array[i]==='string') {
      if(array[i].length>maior.length){
        maior=array[i];
      }
    }
  }
  return maior;
};

//Exercicio 03
function imprime(instrutor, fn){
  if(typeof fn === 'function'){
    instrutor.forEach(fn);
  }
};

var imprimeInstrutor = function(instrutor){
  console.log(instrutor);
}

//Exercicio 04
function fiboSum(numero){
  if(!isNaN(numero)){
    var fib=0, ant=0, prox=1;
    for(var i=0; i<=numero; i++){
      fib=prox+ant;
      ant=prox;
      prox=fib;
    }
    return fib-1;
  }else{
    return 'favor digitar um numero de verdade!'
  }
}

//com recursividade  = muito lento
var fibonacci = function(n){
  if(n==1) return 1;
  if (n==2) return 1;
  return fibonacci(n-1)+fibonacci(n-2);
};

var fiboSumRecursivo=function(n){
  if(n===1) return 1;
  return fibonacci (n) + fiboSumRecursivo(n-1);
}

//Exercicio 05
function excellis(texto){
  if(typeof texto === 'string'){
    var soma=0;
    for(var i=0; i<texto.length; i++){
      soma = texto.charCodeAt(0)-64+ soma*26;
    }
    return soma;
  }
  else
  {
    return 'isto não é uma posição válida!';
  }
}

//Exercicio 06
function queroCafe(mascada, precos){
  var retorno = "";
  if(typeof mascada === 'number' && precos.constructor==Array){
      precos.sort();
    for(var i=0; i<precos.length; i++){
      if(precos[i]<=mascada){
        retorno+=precos[i]+" ";
      }
    }
    return retorno;
  }else{
    return "valores inválidos!"
  }
}
