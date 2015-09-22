

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiTest
{
     @Test
    public void criaUrukHai(){
        UrukHai orc = new UrukHai();
        
        int vidaEsperada = 150;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item(1, "Espada"));
        inventarioEsperado.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(inventarioEsperado, orc.getInventario());
    }
}
