
public class Snaga extends Orc
{
    public Snaga(){
        super(new Item("Arco",1),new Item("Flecha",5),70);
    }
    public void atacarAlvo(Dwarf anao){
        anao.recebeDanoDeOrc(8);
        inventario.perderItens(new Item ("Flecha",1));
    }

    public void atacarAlvo(Elfo elfo){
        elfo.recebeDanoDeOrc(8);
        inventario.perderItens(new Item ("Flecha",1));
    }
    
}
