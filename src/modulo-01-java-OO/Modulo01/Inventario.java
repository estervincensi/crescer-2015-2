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

    public Item getItemComMaiorQuantidade(){
        int maior = 0;
        for(int i=0; i<itens.size();i++){
            if(itens.get(i).getQuantidade()>itens.get(maior).getQuantidade()){
                maior=i;
            }
        }
        return this.itens.get(maior);
    }

    public void ordenarItens(){
        Item aux;
        for(int j=0;  j<itens.size(); j++){
            for(int i=0; i<itens.size()-1; i++){
                if(itens.get(i).getQuantidade()>itens.get(i+1).getQuantidade()){
                    aux = itens.get(i);
                    itens.set(i, itens.get(i+1));
                    itens.set(i+1, aux);
                }
            }
        }
    }
}
