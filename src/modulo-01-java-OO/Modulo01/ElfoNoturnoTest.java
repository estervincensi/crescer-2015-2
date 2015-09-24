
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoGanha3DeExperienciaACadaFlechada(){
        ElfoNoturno e = new ElfoNoturno("Teste",10);
        Dwarf d = new Dwarf();

        e.atirarFlecha(d);

        assertEquals(3,e.getExperiencia());

    }
    
    @Test 
    public void elfoNoturnoFicaCom95DeVidaAoAtirarUmaFlecha(){
        ElfoNoturno e = new ElfoNoturno ("Teste",10);
        Dwarf d = new Dwarf();
        
        e.atirarFlecha(d);
        
        assertEquals(95,e.getVida(),0);
    }
    
    @Test 
    public void elfoNoturnoFicaCom90DeVidaAoAtirarDuasFlechas(){
        ElfoNoturno e = new ElfoNoturno ("Teste",10);
        Dwarf d = new Dwarf();
        
        e.atirarFlecha(d);
        e.atirarFlecha(d);
        
        assertEquals(90.25,e.getVida(),0);
    }
    
    @Test 
    public void elfoNoturnoFicaCom80DeVidaAoAtirarQuatroFlechas(){
        ElfoNoturno e = new ElfoNoturno ("Teste",10);
        Dwarf d = new Dwarf();
        
        e.atirarFlecha(d);
        e.atirarFlecha(d);
        e.atirarFlecha(d);
        e.atirarFlecha(d);
        
        assertEquals(81.45,e.getVida(),0.001);
    }
    
    @Test
    public void elfoNoturnoMorreAoAtirar91Flechas(){
        ElfoNoturno e = new ElfoNoturno("Teste", 10);
        Dwarf d = new Dwarf();
        
        for(int i =0; i<2000; i++){
            e.atirarFlecha(d);
        }
        
        assertEquals(Status.MORTO,e.getStatus());
    }
}
