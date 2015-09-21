
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void DwarfIrishGanhaTentarSorteGanha1000Vezes(){
        IrishDwarf id = new IrishDwarf("Teste",new DataTerceiraEra(1,1,2016));
        id.recebeFlechada();
        id.recebeFlechada();
        id.recebeFlechada();
        Inventario esperado = new Inventario();

        id.getInventario().ganharItens(new Item("Arma",3));
        id.getInventario().ganharItens(new Item("Flecha",5));
        id.getInventario().ganharItens(new Item("Pocao",7));
        
        esperado.ganharItens(new Item("Arma",6003));
        esperado.ganharItens(new Item("Flecha",15005));
        esperado.ganharItens(new Item("Pocao",28007));
        
        id.tentarSorte();
        
        assertEquals(esperado,id.getInventario());

    }
    
    
}
