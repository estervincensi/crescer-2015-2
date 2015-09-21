
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

    public void aumenta1000Unidades(){
        quantidade+=1000;
    }

    public boolean equals(Object obj){
        Item i = (Item)obj;
        return this.descricao.equals(i.getDescricao())&& this.quantidade==i.getQuantidade();
    }

    public void aumenta1000VezesQuantidade(){
        int pa= this.quantidade*(this.quantidade+1)/2;
        this.quantidade+=1000*pa;        
    }

    /*exercicio corrigir a pa.
     * public void shimbalaie() {
        int pa = this.quantidade * (this.quantidade+1) / 2;
        this.quantidade = (this.quantidade + 1000 *pa);
    }*/
}
