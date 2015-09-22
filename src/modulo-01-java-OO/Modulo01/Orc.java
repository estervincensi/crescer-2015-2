import java.util.Random;
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida;
    protected Inventario inventario = new Inventario();
    protected Status status;

    /**
     * COnstrutor para objetos da classe orc
     */
    public Orc(Item item1, Item item2,int vida){
        this.inventario.ganharItens(item1);
        this.inventario.ganharItens(item2);
        this.vida = vida;
        status=Status.VIVO;
    }

    public Status getStatus(){
        return this.status;
    }

    public void recebeFlechaDeElfo(Elfo elfo) {
        if(this.status!=Status.MORTO){
            this.vida-=8;
        }
        verificaStatus();
    }

    public void receberFlechaDeAnao(Dwarf anao) {
        if(this.status!=Status.MORTO){
            if(inventario.verificaEscudoUrukHai()) {
                this.vida -=5;
            }else{
                this.vida -=10;
            }
        }
        verificaStatus();
    }

    public void verificaStatus(){
        if(this.vida<=0){
            this.vida=0;
            this.status=Status.MORTO;
        }
    }

    public int getVida(){
        return this.vida;
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    /*public void atacarAnao(Dwarf anao) {
    if(inventario.verificaArcoEFlecha()){
    anao.recebeFlechada();
    inventario.perderItens(new Item ("Flecha",1));
    }

    }*/

    public void atacarAlvo(Dwarf anao){
        this.status = Status.FUGINDO;
    }

    public void atacarAlvo(Elfo elfo){
        this.status = Status.FUGINDO;

    }
}