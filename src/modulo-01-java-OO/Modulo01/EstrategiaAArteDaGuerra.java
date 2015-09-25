import java.util.*;

public class EstrategiaAArteDaGuerra implements  EstrategiadeAtaque
{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }

    public void atacar(ArrayList<Elfo> elfosVivos,ArrayList<Dwarf> dwarves){
        this.ordemDoUltimoAtaque.clear();
        int intencoes = (int)(elfosVivos.size()*dwarves.size()*0.3);
        int cont=0;
        for(Elfo elfo : elfosVivos){                 

            for(Dwarf dwarf : dwarves){
                if(elfo instanceof ElfoNoturno){
                    if(cont==intencoes){
                        continue;
                    }
                    cont++;
                }
                ordemDoUltimoAtaque.add(elfo);
                elfo.atirarFlecha(dwarf);

            }
        }

        //Se fosse por elfo noturno
        /*for (Elfo elfoQueVaiAtacar : elfosVivos) {
            boolean éElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;

            if (éElfoNoturno) {
                if (cont >= intencoes)
                    continue;
                cont++;
                //qtdElfosNoturnosQueJáAtacaram++;
            }

            ordemDoUltimoAtaque.add(elfoQueVaiAtacar);
            for (Dwarf dwarf : dwarves) {
                elfoQueVaiAtacar.atirarFlecha(dwarf);
            }
        }*/
    }
}
