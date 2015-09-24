
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;

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

    @Test
    public void elfosSaoAgrupadosPorStatus(){
        Exercito exercito = new Exercito();
        Elfo e1 = new ElfoVerde("Verde 1");
        Elfo e2 = new ElfoVerde("Verde 2");
        Elfo e3 = new ElfoNoturno("Noturno 1",10);
        Elfo e4 = new ElfoNoturno("Noturno 2",10);
        int vivo=0,morto=0;

        for(int i=0; i<100; i++){
            e3.atirarFlecha(new Dwarf());
            e4.atirarFlecha(new Dwarf());
        }
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e3);
        exercito.alistarElfo(e4);        

        exercito.agruparPorStatus();
        
        ArrayList <Elfo> vivos = exercito.buscar(Status.VIVO);
        ArrayList <Elfo> mortos = exercito.buscar(Status.MORTO);
            
        for(Elfo elfo:vivos){
            assertEquals(Status.VIVO, elfo.getStatus());
            vivo++;
        }
        
        for(Elfo elfo:mortos){
            assertEquals(Status.MORTO, elfo.getStatus());
            morto++;
        }

        assertEquals(2,vivo);
        assertEquals(2,morto);
    }
}
