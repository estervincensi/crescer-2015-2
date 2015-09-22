

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcTest
{
    @Test
    public void orcComEscudoRecebeFlechaDeAnao(){
        Orc o = new Orc(new Item("Escudo Uruk Hai",1),new Item("Espada",1),150);
        o.getInventario().ganharItens(new Item("Escudo Uruk Hai",1));
        Dwarf d = new Dwarf("Teste");
        
        o.receberFlechaDeAnao(d);
        
        assertEquals(145,o.getVida());
        
    }
    
    @Test
    public void orcSemEscudoRecebeFlechaDeAnao(){
        Orc o = new Orc(new Item("Arco",1),new Item("Flecha",2),70);
        o.getInventario().ganharItens(new Item("Escudo Chinelão",1));
        Dwarf d = new Dwarf("Teste");
        
        o.receberFlechaDeAnao(d);
        
        assertEquals(60,o.getVida());
        
    }
    
    @Test
    public void orcAtacaElfoSemFlechaESemEspadaEFoge(){
        Orc o = new Orc(new Item("Marreta",1),new Item("Martelo",1),50);
        Elfo e = new Elfo("Teste");
        
        o.atacarAlvo(e);
        
        assertEquals(Status.FUGINDO,o.getStatus());
        
    }
    
    @Test
    public void orcAtacaAnaoSemFlechaESemEspadaEFoge(){
        Orc o = new Orc(new Item("Marreta",1),new Item("Martelo",1),50);
        Dwarf d = new Dwarf();
        
        o.atacarAlvo(d);
        
        assertEquals(Status.FUGINDO,o.getStatus());
        
    }
}
