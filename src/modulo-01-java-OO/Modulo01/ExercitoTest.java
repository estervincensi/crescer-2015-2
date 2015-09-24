
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

public class ExercitoTest
{
    @Test
    public void elfoNoturnoÉAlistado(){
        Exercito ex = new Exercito();
        ElfoNoturno en = new ElfoNoturno("Noturno",10);
        HashMap <String,Elfo> esperado = new HashMap<>();
        esperado.put("Noturno",en);
        ex.alistarElfo(en);

        assertEquals(esperado,ex.getExercito());
    }

    @Test
    public void elfoVerdeÉAlistado(){
        Exercito ex = new Exercito();
        ElfoVerde ev = new ElfoVerde("Verde",10);
        HashMap <String,Elfo> esperado = new HashMap<>();
        esperado.put("Verde",ev);
        ex.alistarElfo(ev);

        assertEquals(esperado,ex.getExercito());
    }

    @Test
    public void elfoQueNãoÉVerdeNemNoturnoNãoPodeSerAlistado(){
        Exercito ex = new Exercito();
        ElfoVerde ev = new ElfoVerde("Verde",10);
        ElfoNoturno en = new ElfoNoturno("Noturno",10);
        Elfo e = new Elfo("Elfo Normal");
        HashMap <String,Elfo> esperado = new HashMap<>();
        esperado.put("Verde",ev);
        esperado.put("Noturno",en);
        ex.alistarElfo(ev);
        ex.alistarElfo(en);
        ex.alistarElfo(e);

        assertEquals(esperado,ex.getExercito());
    }

    @Test
    public void buscarElfoVerdePorNome(){
        Exercito ex = new Exercito();
        ElfoVerde ev = new ElfoVerde("Verde",10);
        ElfoNoturno en = new ElfoNoturno("Noturno",10);
        ex.alistarElfo(ev);
        ex.alistarElfo(en);
        
        assertEquals(ev,ex.buscarElfoPorNome("Verde"));
    }
}
