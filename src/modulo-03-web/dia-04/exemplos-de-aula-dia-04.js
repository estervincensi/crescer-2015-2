var soma = function(num1,num2){
  return num1+num2;
}

soma.call(this,1,2); //primeiro parametro é se quiser informar escopo extra para colocar dentro da função.
                     // um exemplo é o this, que deve ser utilizado no setInterval.
soma.apply(this,[1,2])

soma(1,2)
