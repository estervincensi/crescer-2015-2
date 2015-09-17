import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void ElfoNasceComUmNomeE42FlechasPorPadrao(){
        Elfo elfo = new Elfo("Teste");
        assertEquals(42,elfo.getFlechas());
        assertEquals("Teste",elfo.getNome());
    }
    
    @Test
    public void ElfoNasceComUmNomeEQuantidadeInformadaDeFlechas(){
        Elfo elfo = new Elfo("Teste",100);
        assertEquals(100,elfo.getFlechas());
        assertEquals("Teste",elfo.getNome());
    }
    
    @Test
    public void ElfoAtiraFlechaEmDwarfGanhaExperienciaEPerdeFlecha(){
        Elfo elfo = new Elfo("Teste");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        assertEquals(1,elfo.getExperiencia());
        assertEquals(41,elfo.getFlechas());
        
    }
    
    @Test
    public void ToStringRetornaNomeMaisNumeroDeFlechasEExperiencia(){
        Elfo elfo = new Elfo("Teste",100);
        String teste = elfo.toString();
        assertEquals("Teste possui 100 flechas e 0 niveis de experiencia.",teste);
    }
}
