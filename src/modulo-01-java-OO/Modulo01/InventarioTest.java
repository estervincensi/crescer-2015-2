
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void AdicionarUmaArmaAoInventario(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Arma",1));
        assertEquals(new Item("Arma",1),i.getItens().get(0));
    }

    @Test
    public void Adicionar30ArmasAoInventario(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Arma",30));
        assertEquals(new Item("Arma",30),i.getItens().get(0));

    }

    @Test
    public void RemoverUmaArmaDoInventario(){
        Inventario i = new Inventario();
        Item arma = new Item("Arma",1);        
        i.ganharItens(arma);
        i.ganharItens(arma);

        i.removerItens(arma);

        assertEquals(new Item("Arma",1),i.getItens().get(0));
    }

    @Test
    public void recebeDescricoesDeFlechaArmaEPocao(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Flecha",1));
        i.ganharItens(new Item("Arma",1));
        i.ganharItens(new Item("Pocao",1));

        String resposta = i.getDescricoesItens();

        assertEquals("Flecha,Arma,Pocao",resposta);
    }

    @Test
    public void getItemComMaiorQuantidadeRetornaItemComMaiorQuantidade(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Flecha",55));
        i.ganharItens(new Item("Arma",79));
        i.ganharItens(new Item("Pocao",10));

        assertEquals(new Item("Arma",79),i.getItemComMaiorQuantidade());

    }

    @Test
    public void getItemComMaiorQuantidadeRetornaPrimeiroInseridoSeTemDuasQuantidadesIguais(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Flecha",55));
        i.ganharItens(new Item("Arma",10));
        i.ganharItens(new Item("Pocao",55));

        assertEquals(new Item("Flecha",55),i.getItemComMaiorQuantidade());
    }

    @Test
    public void Inserindo3ItensElesSaoOrdenadosEmFormaAscendenteOrdenarItens(){
        Inventario i = new Inventario();
        i.ganharItens(new Item("Flecha",55));
        i.ganharItens(new Item("Arma",10));
        i.ganharItens(new Item("Pocao",9000));
        
        i.ordenarItens();
        
        assertEquals(new Item("Arma",10),i.getItens().get(0));
        assertEquals(new Item("Flecha",55),i.getItens().get(1));    
        assertEquals(new Item("Pocao",9000),i.getItens().get(2));
        
    }
}
