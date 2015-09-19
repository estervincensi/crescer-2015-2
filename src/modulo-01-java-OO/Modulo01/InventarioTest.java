

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void AdicionarUmaArmaAoInventario(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Arma",1));
        assertEquals(new Item("Arma",1),i.getItens().get(0));
    }
    
    @Test
    public void Adicionar30ArmasAoInventario(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Arma",30));
        assertEquals(new Item("Arma",30),i.getItens().get(0));
        
    }
    
    @Test
    public void RemoverUmaArmaDoInventario(){
        Inventario i = new Inventario();
        Item arma = new Item("Arma",1);        
        i.ganharItens(arma);
        i.ganharItens(arma);
        
        i.removerItens(arma);
        
        
        assertEquals(new Item("Arma",1),i.getItens().get(0));
    }
    
}
