
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf d = new Dwarf();
        assertEquals(110,d.getVida()); //verifica se a vida é igual a 110
    }
    
    @Test
    public void dwarfRecebeFlechadaEPerde10DeVida(){
        Dwarf d = new Dwarf();
        d.recebeFlechada();
        assertEquals(100,d.getVida());
    }
    
    @Test
    public void dwarfRecebe11FlechadasEVidaZera(){
        Dwarf d = new Dwarf();
        for(int i=0; i<11;i++){
            d.recebeFlechada();
        }
        assertEquals(0,d.getVida());
    }
    
    @Test
    public void dwarfRecebe7FlechasEVidaVira40(){
        Dwarf d = new Dwarf();
        for(int i=0; i<7; i++){
            d.recebeFlechada();
        }
        assertEquals(40,d.getVida());
    }
}
