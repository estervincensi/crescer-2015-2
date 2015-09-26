
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest
{
    @Test
    public void TresElfosAtacamDwarves(){
        Elfo noturno1 = new ElfoNoturno("N1",10);
        Elfo noturno2 = new ElfoNoturno("N2",10);
        Elfo noturno3 = new ElfoNoturno("N3",10);
        Elfo verde1 = new ElfoVerde("v1");
        Elfo verde2 = new ElfoVerde("v2");
        Elfo verde3 = new ElfoVerde("v3");
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();

        ArrayList<Elfo> ordemEsperada = new ArrayList<>();
        ordemEsperada.add(verde1);
        ordemEsperada.add(noturno1);
        ordemEsperada.add(verde2);
        ordemEsperada.add(noturno2);
        ordemEsperada.add(verde3);
        ordemEsperada.add(noturno3);

        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.alistarElfo(noturno1);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde1);
        exercito.alistarElfo(verde2);
        exercito.alistarElfo(verde3);

        exercito.atacar(new ArrayList<>(Arrays.asList(d1,d2)));

        assertEquals(ordemEsperada,exercito.getOrdemDoUltimoAtaque());
    }
    @Test
    public void CincoElfosVerdesE3NoturnosNaoAtacamDwarves(){
        Elfo noturno1 = new ElfoNoturno("N1",10);
        Elfo noturno2 = new ElfoNoturno("N2",10);
        Elfo noturno3 = new ElfoNoturno("N3",10);
        Elfo verde1 = new ElfoVerde("v1");
        Elfo verde2 = new ElfoVerde("v2");
        Elfo verde3 = new ElfoVerde("v3");
        Elfo verde4 = new ElfoVerde("v4");
        Elfo verde5 = new ElfoVerde("v5");
        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();
        ArrayList<Elfo>esperado = new ArrayList<>();
        
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.alistarElfo(noturno1);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde1);
        exercito.alistarElfo(verde2);
        exercito.alistarElfo(verde3);
        exercito.alistarElfo(verde4);
        exercito.alistarElfo(verde5);

        exercito.atacar(new ArrayList<>(Arrays.asList(d1,d2)));

        assertEquals(esperado,exercito.getOrdemDoUltimoAtaque());
    }
    
    
}
