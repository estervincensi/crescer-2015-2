
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void ItemEhCriadoComQuantidadeEDescricaoInformadas(){
        Item i = new Item ("arma",1);
        assertEquals("arma",i.getDescricao());
        assertEquals(1,i.getQuantidade());
    }
}
