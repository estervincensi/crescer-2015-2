
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf d = new Dwarf("Teste");
        assertEquals(110,d.getVida()); //verifica se a vida é igual a 110
    }

    @Test
    public void DwarfNaceNoDia1do1do1PorPadrao(){
        Dwarf d = new Dwarf ("Teste");
        dataTerceiraEra dt = d.getDataNascimento();
        assertEquals(1,dt.getDia());
        assertEquals(1,dt.getMes());
        assertEquals(1,dt.getAno());

    }

    @Test
    public void DwarfNasceNoDia28De2De1993(){
        Dwarf d = new Dwarf ("Teste",new dataTerceiraEra(28,02,1993));
        dataTerceiraEra dt = d.getDataNascimento();
        assertEquals(28,dt.getDia());
        assertEquals(2,dt.getMes());
        assertEquals(1993,dt.getAno());

    }

    @Test
    public void dwarfNasceComUmNome(){
        Dwarf d = new Dwarf("Teste");
        assertEquals("Teste",d.getNome());
    }

    @Test
    public void dwarfRecebeFlechadaEPerde10DeVida(){
        Dwarf d = new Dwarf("Teste");
        d.recebeFlechada();
        assertEquals(100,d.getVida());
    }

    @Test
    public void dwarfRecebe11FlechadasEVidaZera(){
        Dwarf d = new Dwarf("Teste");
        for(int i=0; i<11;i++){
            d.recebeFlechada();
        }
        assertEquals(0,d.getVida());
    }

    @Test
    public void dwarfCriadoVivo(){
        Dwarf d = new Dwarf("Teste");
        assertEquals(Status.VIVO, d.getStatus());
    }

    @Test
    public void dwarfComZeroDeVidaStatusEhMorto(){
        Dwarf d = new Dwarf("Teste");
        for(int i=0; i<11;i++){
            d.recebeFlechada();
        }
        assertEquals(Status.MORTO,d.getStatus());

    }

    @Test
    public void dwarfRecebe7FlechasEVidaVira40(){
        Dwarf d = new Dwarf("Teste");
        for(int i=0; i<7; i++){
            d.recebeFlechada();
        }
        assertEquals(40,d.getVida());
    }

    @Test
    public void dwarfNaoTemVidaNegativa(){
        Dwarf d = new Dwarf ("Teste");
        for(int i=0; i<12; i++){
            d.recebeFlechada();
        }
        assertEquals(0,d.getVida());
    }
}
