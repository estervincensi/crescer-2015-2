

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest
{
    @Test
    public void criaSnaga(){
        Orc orc = new Snaga();
        
        int vidaEsperada = 70;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item(1, "Arco"));
        inventarioEsperado.adicionarItem(new Item(5, "Flecha"));
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(inventarioEsperado, orc.getInventario());
    }
}
