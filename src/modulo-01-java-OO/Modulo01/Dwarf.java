
public class Dwarf
{
    private int vida=110;
    private String nome;
    private Status status = Status.VIVO;
    private int experiencia;
    private DataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNasc){
        this.nome=nome;
        this.dataNascimento = dataNasc;
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

}
