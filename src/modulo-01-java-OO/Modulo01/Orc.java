
public class Orc extends Personagem
{

    public Orc()
    {
        super.vida = vida;
    }

    public void levarAtaque() {

        if(getItem("Escudo Uruk-Hai") == null){
            perderVida(10);
        }
        else {
            perderVida(6);
        }
    }

    public void receberAtaqueDoOrc(Orc orc){
        this.levarAtaque();
    }

    public void atacarPersonagem(Personagem p){
        if(podeAtacarComEspada()||podeAtacarComArcoEFlecha()){
            p.receberAtaqueDoOrc(this);
            if(!podeAtacarComEspada()) {
                debitarFlecha();
            }
        }
        else {
            this.status = Status.FUGINDO;
        }
    }

    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }

        if(podeAtacarComArcoEFlecha()){
            return 8;
        }

        return 0;
    }

    private void debitarFlecha() {
        Item flecha = getItem("Flecha");

        if(flecha.getQuantidade() == 1){
            this.perderItem(flecha);
        }
        else {
            flecha.debitarUmaUnidade();
        }
    }

    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }

    private boolean podeAtacarComArcoEFlecha(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;

        return temArco && temFlechaProArco;
    }

    private void perderVida(int qtdVidaPerdida) {
        this.vida -= qtdVidaPerdida;

        if(vida <= 0){
            vida = 0;
            this.status = Status.MORTO;
        }
        else {
            this.status = Status.FERIDO;
        }
    }

    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }

}
