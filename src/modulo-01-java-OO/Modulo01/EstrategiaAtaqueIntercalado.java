import java.util.*;
public class EstrategiaAtaqueIntercalado implements EstrategiadeAtaque
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    private int verdes,noturnos;
    private ArrayList<Elfo> elfosOrganizados = new ArrayList<>();
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }

    public void atacar(ArrayList<Elfo> pelotao,ArrayList<Dwarf> dwarves){
        contarElfos(pelotao);
        if(verdes==noturnos){
            organizarElfos(pelotao);
            for(Elfo elfo:elfosOrganizados){
                for(Dwarf dwarf:dwarves){
                    elfo.atirarFlecha(dwarf);
                }
                ordemDoUltimoAtaque.add(elfo);
            }
        }
    }

    public void contarElfos(ArrayList<Elfo>p){
        for(Elfo elfo:p){
            if(elfo instanceof ElfoVerde){
                verdes++;
            }else{
                noturnos++;
            }
        }
    }

    public void organizarElfos(ArrayList<Elfo>elfos){
        Elfo ultimoElfo;
        int cont = elfos.size();
        ultimoElfo=elfos.get(0);

        for(int i = 0;cont != 0; i ++){
            if( i >= cont){
                i = 0;
            }    

            if(elfos.get(i) instanceof ElfoVerde && ultimoElfo instanceof ElfoNoturno){
                ultimoElfo = elfos.get(i);
                elfosOrganizados.add(ultimoElfo);
                elfos.remove(elfos.get(i));
                cont--;
            }else if(elfos.get(i) instanceof ElfoNoturno && ultimoElfo instanceof ElfoVerde){
                ultimoElfo = elfos.get(i);
                elfosOrganizados.add(ultimoElfo);                    
                elfos.remove(elfos.get(i));
                cont--;
            }

        }

    }
}
