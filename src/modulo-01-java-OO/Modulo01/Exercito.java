import java.util.HashMap;
public class Exercito
{
    HashMap <String,Elfo> exercito;
    public Exercito(){
        this.exercito = new HashMap<>();
    }
    
    public void alistarElfo(Elfo e){
        if(e.getNome()!=null && e instanceof ElfoVerde || e instanceof ElfoNoturno){
            exercito.put(e.getNome(),e);
        }
    }
    
    public HashMap getExercito(){
        return this.exercito;
    }
    
    public Elfo buscarElfoPorNome(String nome){
        return exercito.get(nome);
    }
}
