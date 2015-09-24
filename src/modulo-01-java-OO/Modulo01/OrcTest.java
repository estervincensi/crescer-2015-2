

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest
{
    
    @Test
    public void orcComEscudoUrukHaiRecebeDano(){
        Orc orc = new Orc();
        orc.vida=150;
        orc.adicionarItem(new Item(1,"Escudo Uruk-Hai"));
        
        orc.levarAtaque();
        
        assertEquals(144, orc.getVida(),0);
    }
    
    @Test
    public void orcSemEscudoUrukHaiRecebeDano(){
        Orc orc = new Orc();
        orc.vida=70;
        orc.adicionarItem(new Item(1,"Espada"));
        orc.levarAtaque();
        
        assertEquals(60, orc.getVida(),0);
    }
    
    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        for(int i = 0; i < 6; i++){
            orc.atacarPersonagem(elfo);
        }
        
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){
    
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        orc.atacarPersonagem(elfo);
        
        int qtdFlechas = orc.getInventario().getItemPorDescricao("Flecha").getQuantidade();
        
        assertEquals(4, qtdFlechas);
        
    }
    
    @Test
    public void orcAtacaOrc(){
        Orc orc = new Snaga();
        Orc orc1 = new UrukHai();
        
        orc.atacarPersonagem(orc1);
        
        assertEquals(144,orc1.getVida(),0);
    }
    
}
