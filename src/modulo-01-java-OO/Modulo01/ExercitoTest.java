
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
    public void obterElfosMortos(){
        Exercito exercito = new Exercito();
        ElfoVerde ev= new ElfoVerde("v");        
        ElfoNoturno n1 = new ElfoNoturno("noturno1",10);
        ElfoNoturno n2 = new ElfoNoturno("noturno2",10);
        ElfoNoturno n3 = new ElfoNoturno("noturno3",10);        
        
       // for(int i=0; i<100; i++){
       while(n1.getStatus() != Status.MORTO && n2.getStatus() != Status.MORTO && n3.getStatus() != Status.MORTO ){
            n1.atirarFlecha(new Dwarf());
            n2.atirarFlecha(new Dwarf());
            n3.atirarFlecha(new Dwarf());
        }
        
        
        exercito.alistarElfo(n1);
        exercito.alistarElfo(n2);
        exercito.alistarElfo(n3);
        
        ArrayList<Elfo> mortos = new ArrayList<>();        
        mortos.add(n1);
        mortos.add(n2);
        mortos.add(n3);
        
        exercito.agruparPorStatus();
        
        assertEquals(mortos, exercito.buscar(Status.MORTO));
    }
    
     @Test
    public void obterElfosMortos1(){
        Exercito exercito = new Exercito();
        ElfoVerde e = new ElfoVerde("v1");
        exercito.alistarElfo(e);        
        ElfoNoturno morto1 = new ElfoNoturno("n1",10);
        ElfoNoturno morto2 = new ElfoNoturno("n2",10);
        ElfoNoturno morto3 = new ElfoNoturno("n3",10);
        
        while(morto1.getStatus() != Status.MORTO && morto2.getStatus() != Status.MORTO && morto3.getStatus() != Status.MORTO ){
            morto1.atirarFlecha(new Dwarf());
            morto2.atirarFlecha(new Dwarf());
            morto3.atirarFlecha(new Dwarf());
        }
        
        exercito.alistarElfo(morto1);
        exercito.alistarElfo(morto2);
        exercito.alistarElfo(morto3);
      
        ArrayList<Elfo> mortos = new ArrayList<>();
        
        mortos.add(morto1);
        mortos.add(morto2);
        mortos.add(morto3);
        
        exercito.agruparPorStatus();
        
        assertEquals(mortos, exercito.buscar(Status.MORTO));
    }
}
