import java.util.Random;
public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas=flech;
        
    }
    public Elfo(String n){
        this(n,42);
    }
    
    public void atirarFlecha(){
        experiencia++;
        flechas--;
    }
    
    public void atirarFlechaRefactory(){
        flechas--;
        if(acertar()){
            experiencia++;
        }
    }
    
    public boolean acertar(){
        Random gerador = new Random();
        boolean resultado = gerador.nextBoolean();
        return resultado;
    
    }

}
