

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void atirarFlechaIncrementa2NaExperiencia(){
        ElfoVerde ev = new ElfoVerde("Teste");
        Dwarf d = new Dwarf();
        ev.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
        
        ev.atirarFlecha(d);
        
        assertEquals(2,ev.getExperiencia());
    }
    
    @Test
    public void ElfoVerdeSoPodeTerEspadaDeAçoValirianoEArcaEFlechaDeVidro(){
        ElfoVerde ev = new ElfoVerde("Teste");
        ev.adicionarItem(new Item(1,"Espada de aço valiriano"));
        ev.adicionarItem(new Item(1,"banana"));
        ev.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1,"Espada de aço valiriano"));
        esperado.adicionarItem(new Item(1,"Arco e Flecha de Vidro"));
        
        assertEquals(esperado,ev.getInventario());
    }
}
