import java.util.*;
public class Exercito
{
    private HashMap <String,Elfo> exercito;
    private HashMap<Status,ArrayList<Elfo>> status;
    private EstrategiadeAtaque estrategia= new EstrategiaAArteDaGuerra();
    public Exercito(){
        this.exercito = new HashMap<>();
        this.status = new HashMap<>();
    }

    public void mudarEstrategia(EstrategiadeAtaque estrategia) {
        this.estrategia = estrategia;
    }

    public void alistarElfo(Elfo e){
        if(e.getNome()!=null && e instanceof ElfoVerde || e instanceof ElfoNoturno){
            exercito.put(e.getNome(),e);
        }
    }

    public void atacar (ArrayList<Dwarf> dwarves){
        this.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = this.buscar(Status.VIVO);
        estrategia.atacar(elfosVivos,dwarves);
    }

    public HashMap getExercito(){
        return this.exercito;
    }

    public HashMap getExercitoPorStatus(){
        return this.status;
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }

    public Elfo buscarElfoPorNome(String nome){
        return exercito.get(nome);
    }

    public void agruparPorStatus(){
        status.clear();

        for(Map.Entry<String,Elfo> entry:this.exercito.entrySet()){
            Elfo elfo = entry.getValue();
            Status status = elfo.getStatus();            
            if(this.status.containsKey(status)){
                this.status.get(status).add(elfo);
            }else{
                this.status.put(status,new ArrayList<Elfo>(Arrays.asList(elfo)));
            }
        }
    }

    public ArrayList<Elfo> buscar(Status status){
        return this.status.get(status);
    }
}

