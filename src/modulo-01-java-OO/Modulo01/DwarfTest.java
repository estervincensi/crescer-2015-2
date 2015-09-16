
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void DwarfNasceCom110DeVida(){
        Dwarf d = new Dwarf();
        assertEquals(110,d.getVida()); //verifica se a vida é igual a 110
    }
}
