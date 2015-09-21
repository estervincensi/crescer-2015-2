
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void dataTerceiraEraECriadaComDiaMesEAno(){
        DataTerceiraEra d = new DataTerceiraEra(1,1,1);
        assertEquals(1,d.getDia());
        assertEquals(1,d.getMes());
        assertEquals(1,d.getAno());
    }

    @Test 
    public void ano2000EhBissexto(){
        DataTerceiraEra d = new DataTerceiraEra(1,1,2000);
        assertTrue(d.ehBissexto());
    }

    @Test
    public void ano1NaoEhBissexto(){
        DataTerceiraEra d = new DataTerceiraEra(1,1,1);
        assertFalse(d.ehBissexto());
    }

    @Test
    public void ano3600ehBissexto(){
        DataTerceiraEra d = new DataTerceiraEra (1,1,3600);
        assertTrue(d.ehBissexto());
    }
}
