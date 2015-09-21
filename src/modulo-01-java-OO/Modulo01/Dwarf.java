import java.util.ArrayList;
public class Dwarf
{
    protected int vida=110;
    protected String nome;
    protected Status status = Status.VIVO;
    protected int experiencia;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;
    
    public Dwarf() {
        this.vida = 110;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        this.inventario = new Inventario();
    }

    public Dwarf(String nome) {
        this();
        this.nome = nome;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
    }

    public void recebeFlechada(){
        if(this.status != Status.MORTO){
            if(getNumeroSorte()<0){
                this.experiencia+=2;
            }
            else if(getNumeroSorte()>100){
                this.vida-= 10;
                if(this.vida==0){
                    this.status = Status.MORTO;
                }
            }
        }
    }

    public DataTerceiraEra getDataNascimento(){
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

    public double getNumeroSorte(){
        double retorno = 101.;
        if(this.dataNascimento.ehBissexto()&& this.vida>=80 && this.vida<=90){
            retorno = retorno*-33;
        }

        if(!this.dataNascimento.ehBissexto()&& this.nome!=null &&(this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            retorno = (retorno*33)%100;
        }
        return retorno;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public void tentarSorte(){
        double numeroSorte = getNumeroSorte();
        if(numeroSorte==-3333.0){
            inventario.aumentar1000UnidadesEmCadaItem();
        }
    }

    public Inventario getInventario(){
        return this.inventario;
    }

}
