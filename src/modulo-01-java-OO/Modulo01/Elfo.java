
public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia;
    private Status status;

    public Elfo(String n, int flech) {
        nome = n;
        flechas=flech;
        this.status = Status.VIVO;

    }

    public Elfo(String n){
        this(n,42);
    }

    public String getNome(){
        return this.nome;
    }

    /*
    public void setNome(String nome){
    this.nome=nome;
    }*/

    public int getFlechas(){
        return this.flechas;
    }

    /*public void setFlechas(int flechas){
    if(flechas> this.flechas)
    this.flechas=flechas;
    }*/

    public void atirarFlecha(Dwarf d){
        experiencia++;
        flechas--;
        d.recebeFlechada();
    }

    public int getExperiencia(){
        return this.experiencia;
    }
    
    public Status getStatus(){
        return this.status;
    }

    public String toString(){
        boolean flechaSingular = Math.abs(this.flechas)==1;
        /*String textoFlechas = "flechas";
        if(flechaSingular){
        textoFlechas= "flecha";
        }*/

        boolean nivelSingular = Math.abs(this.experiencia)==1;
        /*String textoNiveis = "niveis";
        if(nivelSingular){
        textoNiveis = "nivel";
        }*/

        return String.format("%s possui %d %s e %d %s de experiencia.",this.nome,this.flechas,flechaSingular ? "flecha" : "flechas",this.experiencia, nivelSingular ? "nivel" : "niveis");
        //return this.nome+" possui "+this.flechas+" "+textoFlechas+" e "+this.experiencia+" "+textoNiveis+" de experiencia.";
    }
    /*
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
     */

}
