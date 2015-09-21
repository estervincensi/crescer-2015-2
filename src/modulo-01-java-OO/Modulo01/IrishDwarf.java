
public class IrishDwarf
{
    private int vida=110;
    private String nome;
    private Status status = Status.VIVO;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario;
    
    public IrishDwarf(String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNasc){
        this.nome=nome;
        this.dataNascimento = dataNasc;
        this.inventario=new Inventario();
    }
    
    public void tentarSorte(){
        double numeroSorte = getNumeroSorte();
        if(numeroSorte == -3333.0){
            inventario.aumentar1000VezesQuantidade();
        }
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
    
    public Inventario getInventario(){
        return this.inventario;
    }
}
