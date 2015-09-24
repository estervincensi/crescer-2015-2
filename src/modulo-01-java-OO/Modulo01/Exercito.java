import java.util.HashMap;
import java.util.ArrayList;
public class Exercito
{
    HashMap <String,Elfo> exercito;
    HashMap<Status,ArrayList<Elfo>> status;
    ArrayList<Elfo>vivos=new ArrayList<>();
    ArrayList<Elfo>mortos=new ArrayList<>();
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
        for(Elfo elfo:this.exercito.values()){
            if(elfo.getStatus()==Status.VIVO){
                vivos.add(elfo);
            }else if(elfo.getStatus()==Status.MORTO){
                mortos.add(elfo);
            }
        }
        status.put(Status.VIVO,this.vivos);
        status.put(Status.MORTO,this.mortos);
    }
    
    public ArrayList buscar(Status status){
        return this.status.get(status);
    }
    
   
    public boolean equals(Object obj){
        Exercito e = (Exercito) obj;
        return this.exercito.equals(e.getExercito());
    }
}

