import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceCom42FlechasPorPadraoSeInformadoSomenteNome(){
        Elfo elfo = new Elfo("Teste");
        assertEquals(42,elfo.getFlechas());
    }
    
    @Test
    public void elfoCriadoComStatusVivo(){
        Elfo e = new Elfo("Teste");
        assertEquals(Status.VIVO,e.getStatus());
    }

    @Test
    public void elfoCriadoComNomeEMuitasFlechas(){
        Elfo elfo = new Elfo("Teste",100);
        assertEquals(100,elfo.getFlechas());
        assertEquals("Teste",elfo.getNome());
    }

    @Test
    public void elfoCriadoComNomeEPoucasFlechas(){
        Elfo elfo = new Elfo("Teste",2);
        assertEquals(2,elfo.getFlechas());
        assertEquals("Teste",elfo.getNome());
    }

    @Test
    public void elfoNasceComNomeVazio(){
        Elfo elfo = new Elfo("");
        assertEquals("",elfo.getNome());
    }

    @Test
    public void elfoCriadoComNomeEDevendoFlechas(){
        Elfo elfo = new Elfo("Teste",-10);
        assertEquals(-10,elfo.getFlechas());
        assertEquals("Teste",elfo.getNome());
    }

    @Test
    public void elfoNasceComNomeNull(){
        Elfo elfo = new Elfo(null);
        assertNull(elfo.getNome());
    }

    @Test
    public void elfoNasceComZeroDeExperiencia(){
        Elfo elfo = new Elfo("Teste");
        assertEquals(0,elfo.getExperiencia());
    }

    @Test
    public void elfoAtiraFlechaEmDwarf(){
        Elfo elfo = new Elfo("Teste");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        assertEquals(1,elfo.getExperiencia());
        assertEquals(41,elfo.getFlechas());
        assertEquals(100,dwarf.getVida());

    }

    @Test
    public void toStringRetornaNomeMaisNumeroDeFlechasEExperiencia(){
        Elfo elfo = new Elfo("Teste",100);
        assertEquals("Teste possui 100 flechas e 0 niveis de experiencia.",elfo.toString());
    }
    
    @Test
    public void elfoComUmaFlechaInformadaToString(){
        Elfo e = new Elfo("Teste",1);
        assertEquals("Teste possui 1 flecha e 0 niveis de experiencia.",e.toString());
        
    }
    
    @Test
    public void elfoComUmDeExperienciaToString(){
        Elfo elfo = new Elfo(null);
        elfo.atirarFlecha(new Dwarf());
        String textoEsperado = "null possui 41 flechas e 1 nivel de experiencia.";
        assertEquals(textoEsperado,elfo.toString());
    }

    @Test
    public void umElfoAtiraEmDoisDwarves(){
        Elfo elfo = new Elfo("Teste");
        Dwarf dwarf1 = new Dwarf();
        Dwarf dwarf2 = new Dwarf();

        elfo.atirarFlecha(dwarf1);
        elfo.atirarFlecha(dwarf2);

        assertEquals(2,elfo.getExperiencia());
        assertEquals(40,elfo.getFlechas());
        assertEquals(100, dwarf2.getVida());
        assertEquals(100, dwarf1.getVida());

    }

    @Test
    public void doisElfosAtiramNoMesmoDwarf(){
        Elfo elfo1 = new Elfo("Teste");
        Elfo elfo2 = new Elfo("Teste2");
        Dwarf dwarf = new Dwarf();

        elfo1.atirarFlecha(dwarf);
        elfo2.atirarFlecha(dwarf);

        assertEquals(1,elfo1.getExperiencia());
        assertEquals(41,elfo1.getFlechas());        
        assertEquals(1,elfo2.getExperiencia());
        assertEquals(41,elfo2.getFlechas());
        assertEquals(90,dwarf.getVida());   

    }

    @Test
    public void doisElfosAtiramEmDoisDwarves(){
        Elfo e1 = new Elfo ("Teste");
        Elfo e2 = new Elfo ("Teste1");
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();

        e1.atirarFlecha(d1);
        e1.atirarFlecha(d2);
        e2.atirarFlecha(d1);
        e2.atirarFlecha(d2);

        assertEquals(2,e1.getExperiencia());
        assertEquals(40,e1.getFlechas());
        assertEquals(90,d1.getVida());
        assertEquals(2,e2.getExperiencia());
        assertEquals(40,e2.getFlechas());
        assertEquals(90,d2.getVida());
    }
}
