
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome, int flecha){
        super(nome,flecha);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.flechas--;
        super.experiencia+=3;
        super.vida -=(vida*0.05);
        dwarf.receberFlechada();
        verificaStatus();
    }
    
    /*
       Exercicio 02 - Elfo Noturno não ficava morto pois não tinha código implementado
       */
    
    public void verificaStatus(){
        if(vida==0){
            super.status = Status.MORTO;
        }
    }
   
}
