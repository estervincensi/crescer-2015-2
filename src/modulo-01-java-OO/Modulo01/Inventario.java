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

    public void perderItens(Item item2){
        for(Item item : this.itens){
            if(item.getDescricao().equals(item2.getDescricao())){
                if(item.getQuantidade()>=1){
                    item.diminui1Unidade();
                }else{
                    removerItens(item);
                }
            }
        }
    }

    public ArrayList <Item> getItens(){
        return this.itens;
    }

    public String getDescricoesItens(){
        String descricao="";
        //for normal
        /*for(int i=0; i<itens.size(); i++){
        descricao+= itens.get(i).getDescricao();
        if(i!=itens.size()-1){
        descricao+=",";
        }
        }
        return descricao;*/
        //foreach
        for(Item item : this.itens){
            descricao += item.getDescricao() + ",";
        }
        return descricao.substring(0,descricao.length()-1);
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
        //Bubble Sort
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

    public void aumentar1000UnidadesEmCadaItem(){
        for(Item item : this.itens){
            item.aumenta1000Unidades();
        }
    }

    public void aumentar1000VezesQuantidade(){
        for(Item item : this.itens){
            item.aumenta1000VezesQuantidade();
        }
    }

    public boolean equals(Object obj) {
        Inventario outroInventario = (Inventario)obj;
        return this.itens.equals(outroInventario.getItens());
    }

    public boolean verificaEscudoUrukHai(){
        boolean retorno = false;
        for(Item item : this.itens){
            if(item.getDescricao().equals("Escudo Uruk Hai")){
                retorno = true;
            }

        }
        return retorno;
    }

   public int verificaArmas(){
        int retorno = 0;
        if(verificaEspada()){
            retorno = 12;
        }else if(verificaArcoEFlecha()){
            retorno = 8;
        }
        return retorno;
    }

    public boolean verificaArcoEFlecha(){
        boolean arco=false,flecha=false;
        for(Item item : this.itens){
            if(item.getDescricao().equals("Arco")){
                arco=true;
            }
            if(item.getDescricao().equals("Flecha")&&item.getQuantidade()>=1){
                flecha=true;
            }
        }
        return arco&&flecha;
    }

    public boolean verificaEspada(){
        boolean espada=false;
        for(Item item : this.itens){
            if(item.getDescricao().equals("Espada")){
                espada = true;
            }
        }
        return espada;
    }
}
