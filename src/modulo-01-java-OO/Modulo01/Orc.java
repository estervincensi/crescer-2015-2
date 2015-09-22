import java.util.Random;
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida;
    protected Inventario inventario = new Inventario();

    /**
     * COnstrutor para objetos da classe orc
     */
    public Orc(Item item1, Item item2,int vida){
        this.inventario.ganharItens(item1);
        this.inventario.ganharItens(item2);
        this.vida = vida;
    }

    public void recebeFlechaDeElfo(Elfo elfo) {
        this.vida-=10;
    }

    public void receberFlechaDeAnao(Dwarf anao) {
        if(inventario.verificaEscudoUrukHai()) {
            this.vida -=5;
        }else{
            this.vida -=10;
        }
    }

    public int getVida(){
        return this.vida;
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public void atacarAnao(Dwarf anao) {
        if(inventario.verificaArcoEFlecha()){
            anao.recebeFlechada();
            inventario.perderItens(new Item ("Flecha",1));
        }

    }

}