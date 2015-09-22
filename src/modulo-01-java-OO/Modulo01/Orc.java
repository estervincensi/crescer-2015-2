
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
            perderVida(8);
        }
    }

    public void receberFlechaDeAnao(Dwarf anao) {
        if(this.status!=Status.MORTO){
            if(inventario.verificaEscudoUrukHai()) {
                perderVida(5);
            }else{
                perderVida(10);
            }
        }
    }

    public void perderVida(int dano){
        this.vida-=dano;
        if(this.vida<=0){
            this.vida=0;
            this.status=Status.MORTO;
        }else{
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
        int dano = inventario.verificaArmas(); 
        if(dano!=0){
            anao.recebeDanoDeOrc(dano);
            if(dano==8){
                inventario.perderItens(new Item ("Flecha",1));
            }
        }else{
            this.status = Status.FUGINDO;
        }
    }

    public void atacarAlvo(Elfo elfo){
        int dano = inventario.verificaArmas(); 
        if(dano!=0){
            elfo.recebeDanoDeOrc(dano);
            if(dano==8){
                inventario.perderItens(new Item ("Flecha",1));
            }
        }else{
            this.status = Status.FUGINDO;
        }

    }
}