
public class UrukHai extends Orc
{
    public UrukHai(){
        super(new Item("Escudo Uruk Hai",1),new Item("Espada",1),150);
    }

    public void atacarAlvo(Dwarf anao){
        anao.recebeDanoDeOrc(12);
    }

    public void atacarAlvo(Elfo elfo){
        elfo.recebeDanoDeOrc(12);
    }

}
