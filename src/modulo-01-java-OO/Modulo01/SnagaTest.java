
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest
{
    @Test
    public void snagaÉCriadoComEscudoEspadaE150DeVidaPorPadrao(){
        Snaga s = new Snaga();
        Inventario esperado = new Inventario();
        esperado.ganharItens(new Item("Arco",1));
        esperado.ganharItens(new Item("Flecha",5));
        assertEquals(70,s.getVida());
        assertEquals(esperado,s.getInventario());
    }

    @Test
    public void SnagaAtacaAnao(){
        Snaga s = new Snaga();
        Dwarf d = new Dwarf();
        int vidaEsperada = 102;

        s.atacarAlvo(d);

        assertEquals(vidaEsperada,d.getVida());
    }

    @Test
    public void SnagaAtacaElfo(){
        Snaga s = new Snaga();
        Elfo e = new Elfo("Teste");
        int vidaEsperada = 72;

        s.atacarAlvo(e);

        assertEquals(vidaEsperada,e.getVida());
    }
}
