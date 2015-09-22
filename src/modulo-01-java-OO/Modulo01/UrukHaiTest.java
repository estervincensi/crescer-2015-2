

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UrukHaiTest
{
    @Test
    public void UrukHaiÉCriadoComEscudoEspadaE150DeVidaPorPadrao(){
        UrukHai uh = new UrukHai();
        Inventario esperado = new Inventario();
        esperado.ganharItens(new Item("Escudo Uruk Hai",1));
        esperado.ganharItens(new Item("Espada",1));
        assertEquals(150,uh.getVida());
        assertEquals(esperado,uh.getInventario());
    }
    
    @Test
    public void urukHaiAtacaAnao(){
        UrukHai uh = new UrukHai();
        Dwarf d = new Dwarf();
        int vidaEsperada = 98;
        
        uh.atacarAlvo(d);
        
        assertEquals(vidaEsperada,d.getVida());
    }
    
    @Test
    public void urukHaiAtacaElfo(){
        UrukHai uh = new UrukHai();
        Elfo e = new Elfo("Teste");
        int vidaEsperada = 68;
        
        uh.atacarAlvo(e);
        
        assertEquals(vidaEsperada,e.getVida());
    }
}
