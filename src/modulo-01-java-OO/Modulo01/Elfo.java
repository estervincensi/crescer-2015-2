public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas=flech;
        
    }
    public Elfo(String n){
        nome=n;
        flechas=42;
    }
    
    public void atirarFlecha(){
        experiencia++;
        flechas--;
    }
}
