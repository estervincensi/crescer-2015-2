public class Elfo {
    private String nome;
    private Integer flechas;
    private int experiencia;
    
    public Elfo(String n, Integer flech) {
        nome = n;
        if(flech==null){
            flechas=42;
        }else{
            flechas = flech;
        }
        
    }
    
    public void atirarFlecha(){
        experiencia++;
    }
}