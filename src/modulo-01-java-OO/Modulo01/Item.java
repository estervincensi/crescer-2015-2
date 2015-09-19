
public class Item
{
    private String descricao;
    private int quantidade;

    public Item (String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public boolean equals(Object obj){
        Item i = (Item)obj;
        return this.descricao.equals(i.getDescricao())&& this.quantidade==i.getQuantidade();
    }
}
