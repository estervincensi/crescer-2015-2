
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class dataTerceiraEraTest
{
    @Test 
    public void ano2000EhBissexto(){
        dataTerceiraEra d = new dataTerceiraEra(1,1,2000);
        assertTrue(d.ehBissexto());
    }

    @Test
    public void ano1NaoEhBissexto(){
        dataTerceiraEra d = new dataTerceiraEra(1,1,1);
        assertFalse(d.ehBissexto());
    }
    
    @Test
    public void ano3600ehBissexto(){
        dataTerceiraEra d = new dataTerceiraEra (1,1,3600);
        assertTrue(d.ehBissexto());
    }
}
