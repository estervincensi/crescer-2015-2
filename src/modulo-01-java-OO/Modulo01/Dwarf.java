
public class Dwarf
{
    private int vida=110;
    private String nome;
    private Status status = Status.VIVO;
    private int experiencia;

    public Dwarf(String nome){
        this.nome = nome;
    }

    public void recebeFlechada(){
        if(this.status == Status.VIVO){
            this.vida-= 10;
            if(this.vida==0)
                this.status = Status.MORTO;
        }
    }

    public String getNome(){
        return this.nome;
    }

    public int getVida(){
        return this.vida;
    }

    public Status getStatus(){
        return this.status;
    }

}
