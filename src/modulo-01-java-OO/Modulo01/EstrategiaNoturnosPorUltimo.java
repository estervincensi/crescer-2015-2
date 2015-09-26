import java.util.*;
public class EstrategiaNoturnosPorUltimo implements EstrategiadeAtaque
{
    private ArrayList<Elfo>ordemDoUltimoAtaque = new ArrayList<>();
    private ArrayList<Elfo> elfosOrdenados = new ArrayList<>();
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;        
    }

    public void ordenarPelotao(ArrayList<Elfo> pelotao){
        for(Elfo elfo: pelotao){
            if(elfo instanceof ElfoVerde){
                this.elfosOrdenados.add(elfo);
            }
        }
        for(Elfo elfo: pelotao){
            if(elfo instanceof ElfoNoturno){
                this.elfosOrdenados.add(elfo);
            }
        }
    }

    public void atacar(ArrayList<Elfo> pelotao,ArrayList<Dwarf> dwarves){
        this.ordemDoUltimoAtaque.clear();
        ordenarPelotao(pelotao);
        for(Elfo elfo : elfosOrdenados){
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);

            }
            this.ordemDoUltimoAtaque.add(elfo);
        }
    }
}
