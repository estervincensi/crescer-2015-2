
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAArteDaGuerraTest
{
    @Test
    public void ExercitoCom3VerdesAtaca3Dwarves(){
        ArrayList<Elfo> elfos = new ArrayList<>();
        ArrayList<Dwarf> dwarfs = new ArrayList<>();
        Exercito e = new Exercito();

        Elfo elfo1=new ElfoVerde("v1");
        Elfo elfo2=new ElfoVerde("v2");
        Elfo elfo3=new ElfoVerde("v3");
        Elfo elfo4=new ElfoNoturno("n1",10);
        Elfo elfo5=new ElfoNoturno("n2",10);
        Elfo elfo6=new ElfoNoturno("n3",10);

        Dwarf d1 = new Dwarf();
        Dwarf d2 = new Dwarf();
        Dwarf d3 = new Dwarf();
        dwarfs.add(d1);
        dwarfs.add(d2);
        dwarfs.add(d3);

        e.alistarElfo(elfo1);
        e.alistarElfo(elfo2);
        e.alistarElfo(elfo3);
        e.alistarElfo(elfo4);
        e.alistarElfo(elfo5);
        e.alistarElfo(elfo6);

        e.atacar(dwarfs);

        //assert
        assertEquals(60,d1.getVida(),0);
        assertEquals(60,d2.getVida(),0);
        assertEquals(70,d3.getVida(),0);

    }

    @Test
    public void quatroElfos3Noturnos1VerdeAtacam2AnoesMasSo2NoturnosPodemAtacar() {
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        double vidaEsperada = 90;
        Elfo noturno1 = new ElfoNoturno("Night Elf1",10);
        Elfo noturno2 = new ElfoNoturno("Night Elf2",10);
        Elfo noturno3 = new ElfoNoturno("Night Elf3",10);
        Elfo verde1 = new ElfoVerde("Green 1");
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new EstrategiaAArteDaGuerra());
        exercito.alistarElfo(noturno1);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde1);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(balin, stalin)));
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof ElfoNoturno) {
                noturnosQueAtiraram++;
            }
        }

        assertEquals(2, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);
    }
    
    @Test
    public void quatroElfos3NoturnosSendoUmMortoE1VerdeAtacam2AnoesMasSo1NoturnoPodeAtacar() {
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        Elfo noturno1 = new ElfoNoturno("Night Elf1",10);
        Elfo noturno2 = new ElfoNoturno("Night Elf2",10);
        Elfo noturno3 = new ElfoNoturno("Night Elf3",10);
        for (int i = 0; i<90; i++) {
            noturno3.atirarFlecha(new Dwarf());
        }
        Elfo verde1 = new ElfoVerde("Green 1");
        Exercito exercito = new Exercito();
        exercito.mudarEstrategia(new EstrategiaAArteDaGuerra());
        exercito.alistarElfo(noturno1);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde1);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(balin, stalin)));
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof ElfoNoturno) {
                noturnosQueAtiraram++;
            }
        }

        assertEquals(1, noturnosQueAtiraram);
        assertEquals(90, balin.getVida(), .0);
        assertEquals(100, stalin.getVida(), .0);
    }
}


