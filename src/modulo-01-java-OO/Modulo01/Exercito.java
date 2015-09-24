import java.util.*;
public class Exercito
{
    private HashMap <String,Elfo> exercito;
    private HashMap<Status,ArrayList<Elfo>> status;
    private ArrayList<Elfo>vivos=new ArrayList<>();
    private ArrayList<Elfo>mortos=new ArrayList<>();
    public Exercito(){
        this.exercito = new HashMap<>();
        this.status = new HashMap<>();
    }

    public void alistarElfo(Elfo e){
        if(e.getNome()!=null && e instanceof ElfoVerde || e instanceof ElfoNoturno){
            exercito.put(e.getNome(),e);
        }
    }

    public HashMap getExercito(){
        return this.exercito;
    }

    public HashMap getExercitoPorStatus(){
        return this.status;
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

