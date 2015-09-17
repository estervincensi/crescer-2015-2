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
    public void ElfoPodeNascerComZeroFlechas(){
        Elfo elfo = new Elfo("Teste",0);
        assertEquals(0,elfo.getFlechas());
        assertEquals("Teste",elfo.getNome());
    }

    @Test
    public void ElfoPodeNascerComNomeNull(){
        Elfo elfo = new Elfo(null);
        assertNull(elfo.getNome());
    }

    @Test
    public void ElfoNasceComZeroDeExperiencia(){
        Elfo elfo = new Elfo("Teste");
        assertEquals(0,elfo.getExperiencia());
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

    @Test
    public void UmElfoAtiraEmDoisDwarves(){
        Elfo elfo = new Elfo("Teste");
        Dwarf dwarf1 = new Dwarf();
        Dwarf dwarf2 = new Dwarf();
        elfo.atirarFlecha(dwarf1);
        assertEquals(1,elfo.getExperiencia());
        assertEquals(41,elfo.getFlechas());
        assertEquals(100, dwarf1.getVida());
        elfo.atirarFlecha(dwarf2);
        assertEquals(2,elfo.getExperiencia());
        assertEquals(40,elfo.getFlechas());
        assertEquals(100, dwarf2.getVida());

    }

    @Test
    public void DoisElfosAtiramNoMesmoDwarf(){
        Elfo elfo1 = new Elfo("Teste");
        Elfo elfo2 = new Elfo("Teste2");
        Dwarf dwarf = new Dwarf();

        elfo1.atirarFlecha(dwarf);
        assertEquals(1,elfo1.getExperiencia());
        assertEquals(41,elfo1.getFlechas());
        assertEquals(100,dwarf.getVida());

        elfo2.atirarFlecha(dwarf);
        assertEquals(1,elfo2.getExperiencia());
        assertEquals(41,elfo2.getFlechas());
        assertEquals(90,dwarf.getVida());   

    }
    
    @Test
    public void DoisElfosAtiramEmDoisDwarves(){
        Elfo e1 = new Elfo ("Teste");
        Elfo e2 = new Elfo ("Teste1");
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();
        
        e1.atirarFlecha(d1);
        assertEquals(1,e1.getExperiencia());
        assertEquals(41,e1.getFlechas());
        assertEquals(100,d1.getVida());
        
        e1.atirarFlecha(d2);
        assertEquals(2,e1.getExperiencia());
        assertEquals(40,e1.getFlechas());
        assertEquals(100,d2.getVida());
        
        e2.atirarFlecha(d1);
        assertEquals(1,e2.getExperiencia());
        assertEquals(41,e2.getFlechas());
        assertEquals(90,d1.getVida());
        
        e2.atirarFlecha(d2);
        assertEquals(2,e2.getExperiencia());
        assertEquals(40,e2.getFlechas());
        assertEquals(90,d2.getVida());
    }
}
