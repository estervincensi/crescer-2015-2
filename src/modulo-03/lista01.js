//Exercicio 01 - daisyGame

function daisyGame(numero){
  if (typeof numero === 'number') { //só verifica se for número senao ela nao verifica
    if (numero%2===0) {
      return 'Love me not'
    }else{
      return 'Love me'
    }
  }
}
