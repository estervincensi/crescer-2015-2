import java.util.ArrayList;
public class Inventario
{
    ArrayList <Item> itens = new ArrayList();
    
    public void ganharItens(Item item){
        this.itens.add(item);
    }
    
    public void removerItens(Item item){
        this.itens.remove(item);
    }
    
    public ArrayList <Item> getItens(){
        return this.itens;
    }
}
