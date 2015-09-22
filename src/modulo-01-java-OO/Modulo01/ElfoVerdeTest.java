import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeAtacaUmDwarf(){
        ElfoVerde ev = new ElfoVerde("Teste");
        Dwarf d = new Dwarf();
        
        ev.atirarFlecha(d);
        
        assertEquals(2,ev.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAtacaUmDwarfEIrishDwarf(){
        ElfoVerde ev = new ElfoVerde ("Elfo Verde");
        IrishDwarf irish = new IrishDwarf();
        Dwarf common = new Dwarf();
        ev.atirarFlecha(irish);
        ev.atirarFlecha(common);
        
        assertEquals(4,ev.getExperiencia());
    }
    
    @Test
    public void elfoVerdeSoPodeTerEspadaDeAçoValirianoEArcaEFlechaDeVidro(){
        ElfoVerde ev = new ElfoVerde("Teste");
        ev.adicionarItem(new Item(1,"Espada de aço valiriano"));
        ev.adicionarItem(new Item(1,"banana"));
        ev.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1,"Espada de aço valiriano"));
        esperado.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
        
        assertEquals(esperado,ev.getInventario());
    }
    
    @Test
    public void elfoVerdeAdicionaArcoEFlechaDeVidroENull(){
         ElfoVerde ev = new ElfoVerde("Teste");
         ev.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
         ev.adicionarItem(null);
         
         Inventario esperado = new Inventario();
         esperado.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
         
    }
}
