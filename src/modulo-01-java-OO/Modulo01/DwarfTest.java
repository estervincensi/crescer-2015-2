
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
    public void dwarfNaceNoDia1do1do1PorPadrao(){
        Dwarf d = new Dwarf ("Teste");        
        assertEquals(new dataTerceiraEra(1,1,1),d.getDataNascimento());
    }

    @Test
    public void dwarfNasceNoDia28De2De1993(){
        Dwarf d = new Dwarf ("Teste",new dataTerceiraEra(28,02,1993));
        assertEquals(new dataTerceiraEra(28,02,1993),d.getDataNascimento());
    }

    @Test
    public void dwarfNasceComUmNome(){
        Dwarf d = new Dwarf("Teste");
        assertEquals("Teste",d.getNome());
    }

    @Test
    public void dwarfNasceComNomeNull(){
        Dwarf d = new Dwarf (null);
        assertEquals(null,d.getNome());
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
    public void dwarfRecebe7FlechasVidaVira40EStatusEVivo(){
        Dwarf d = new Dwarf("Teste");
        for(int i=0; i<7; i++){
            d.recebeFlechada();
        }
        assertEquals(40,d.getVida());
        assertEquals(Status.VIVO, d.getStatus());
    }

    @Test
    public void dwarfNaoTemVidaNegativa(){
        Dwarf d = new Dwarf ("Teste");
        for(int i=0; i<12; i++){
            d.recebeFlechada();
        }
        assertEquals(0,d.getVida());
    }

    @Test
    public void dwarfNasceEmAnoBissextoETemVidaIgual90GetNumeroSorte(){
        Dwarf d = new Dwarf("Teste",new dataTerceiraEra(1,1,2016));
        d.recebeFlechada();
        d.recebeFlechada();
        assertEquals(-3333.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNasceEmAnoBissextoETemVidaIgual110GetNumeroSorte(){
        Dwarf d = new Dwarf("Teste",new dataTerceiraEra(1,1,2016));
        assertEquals(101.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNAoNasceEmAnoBissextoETemVidaIgual90GetNumeroSorte(){
        Dwarf d = new Dwarf("Teste",new dataTerceiraEra(1,1,2015));
        d.recebeFlechada();
        d.recebeFlechada();
        assertEquals(101.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNAoNasceEmAnoBissextoESeChamaMeirelesGetNumeroSorte(){
        Dwarf d = new Dwarf("Meireles",new dataTerceiraEra(1,1,2015));

        assertEquals(33.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNAoNasceEmAnoBissextoESeChamaSeixasGetNumeroSorte(){
        Dwarf d = new Dwarf("Seixas",new dataTerceiraEra(1,1,2015));

        assertEquals(33.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNasceEmAnoBissextoESeChamaMeirelesGetNumeroSorte(){
        Dwarf d = new Dwarf("Meireles",new dataTerceiraEra(1,1,2016));

        assertEquals(101.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNasceEmAnoBissextoESeChamaSeixasGetNumeroSorte(){
        Dwarf d = new Dwarf("Seixas",new dataTerceiraEra(1,1,2016));

        assertEquals(101.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNAoNasceEmAnoBissextoESeChamaFulanoGetNumeroSorte(){
        Dwarf d = new Dwarf("Fulano",new dataTerceiraEra(1,1,2015));

        assertEquals(101.0,d.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNAoNasceEmAnoBissextoETemNomeNullGetNumeroSorte(){
        Dwarf d = new Dwarf(null,new dataTerceiraEra(1,1,2015));

        assertEquals(101.0,d.getNumeroSorte(),0);
    }    

    @Test
    public void dwarfComNumeroDaSorteMenorQueZeroNaoRecebeFlechadaEGanhaPontoDeExperiencia(){
        Dwarf d = new Dwarf("Teste", new dataTerceiraEra(1,1,2016)); //para elfo ter xp negativo tem q ter nascido em ano bissexto
        d.recebeFlechada();//para ficar numero da sorte negativo, deve receber duas flechadas, pois a vida deve ser entre 80 e 90
        d.recebeFlechada();        
        d.recebeFlechada(); //ao receber a terceira flechada não será descontada vida e serão incrementados 2 pontos de experiência

        assertEquals(2,d.getExperiencia());
        assertEquals(90,d.getVida());      

    }

    @Test
    public void dwarfComNumeroDaSorteMaiorQue100RecebeFlechadaENaoRecebeExperienca(){
        Dwarf d = new Dwarf("Teste", new dataTerceiraEra(1,1,2015));
        d.recebeFlechada();

        assertEquals(100,d.getVida());
        assertEquals(0,d.getExperiencia());

    }

    @Test
    public void dwarfComNumeroDaSorteEntre0E100NaoRecebeFlechasENemExperiencia(){
        Dwarf d = new Dwarf ("Seixas", new dataTerceiraEra(1,1,2015));
        d.recebeFlechada();
        assertEquals(110,d.getVida());
        assertEquals(0,d.getExperiencia());

    }
}
