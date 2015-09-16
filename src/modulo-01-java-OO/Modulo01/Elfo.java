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

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public int getFlechas(){
        return this.flechas;
    }

    /*public void setFlechas(int flechas){
        if(flechas> this.flechas)
            this.flechas=flechas;
    }*/

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
