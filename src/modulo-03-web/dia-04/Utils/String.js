String.prototype.palindromo=function(){
  return this==this.split('').reverse().join('');
}
