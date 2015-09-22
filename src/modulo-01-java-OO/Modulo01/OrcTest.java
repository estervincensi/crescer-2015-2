

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
        Orc o = new UrukHai();
        o.getInventario().ganharItens(new Item("Escudo Uruk Hai",1));
        Dwarf d = new Dwarf("Teste");
        
        o.receberFlechaDeAnao(d);
        
        assertEquals(145,o.getVida());
        
    }
    
    /*@Test
    public void orcSemEscudoRecebeFlechaDeAnao(){
        Orc o = new Orc();
        o.gerarVida();
        int vidaEsperada = o.getVida()-10;
        o.getInventario().ganharItens(new Item("Escudo Chinelão",1));
        Dwarf d = new Dwarf("Teste");
        
        o.receberFlechaDeAnao(d);
        
        assertEquals(vidaEsperada,o.getVida());
        
    }
    
    @Test
    public void orcAtacaAnaoUmaVezEPerdeUmaFlecha(){
        Orc o = new Orc();
        Dwarf anao = new Dwarf();
        o.getInventario().ganharItens(new Item("Flecha",3));
        o.getInventario().ganharItens(new Item("Arco",1));
        
        Inventario esperado = new Inventario();
        esperado.ganharItens(new Item("Flecha",2));
        esperado.ganharItens(new Item("Arco",1));
        o.atacarAnao(anao);
        
        assertEquals(esperado,o.getInventario());
    }*/
}
