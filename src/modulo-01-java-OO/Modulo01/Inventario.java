import java.util.ArrayList;
public class Inventario
{
    ArrayList <Item> itens = new ArrayList<>();

    public void ganharItens(Item item){
        this.itens.add(item);
    }

    public void removerItens(Item item){
        this.itens.remove(item);
    }

    public ArrayList <Item> getItens(){
        return this.itens;
    }

    public String getDescricoesItens(){
        String descricao="";
        for(int i=0; i<itens.size(); i++){
            descricao+= itens.get(i).getDescricao();
            if(i!=itens.size()-1){
                descricao+=",";
            }
        }
        return descricao;
    }
}
