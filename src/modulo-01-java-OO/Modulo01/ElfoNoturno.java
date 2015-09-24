
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome, int flecha){
        super(nome,flecha);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia += 2;
        double qtdVidaAPerder = this.vida * 0.05;
        //double qtdVidaAPerder = this.vida * 5/100;
        this.vida -= qtdVidaAPerder;
        this.status = (int)this.vida == 0 ? 
            Status.MORTO : this.status;
        
    }
    
    /*
       Exercicio 02 - Elfo Noturno não ficava morto pois não tinha código implementado
       */
   
}
