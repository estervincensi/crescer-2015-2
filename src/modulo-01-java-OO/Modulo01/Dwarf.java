
public class Dwarf
{
    private int vida=110;
    private String nome;
    private Status status = Status.VIVO;
    private int experiencia;
    private dataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        this(nome, new dataTerceiraEra(1,1,1));
    }
    
    public Dwarf(String nome, dataTerceiraEra dataNasc){
        this.nome=nome;
        this.dataNascimento = dataNasc;
    }

    public void recebeFlechada(){
        if(this.status == Status.VIVO){
            this.vida-= 10;
            if(this.vida==0)
                this.status = Status.MORTO;
        }
    }
    
    public dataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
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
