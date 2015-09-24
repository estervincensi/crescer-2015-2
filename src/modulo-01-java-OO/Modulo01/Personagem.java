
public abstract class Personagem
{

    protected double vida;
    int experiencia;
    protected String nome;
    protected Status status = Status.VIVO;
    protected final Inventario inventario;

    public Personagem(String nome)
    {
        this();
        this.nome=nome;
    }
    
    public Personagem(){
        this.inventario = new Inventario();
    }    

    public void receberAtaqueDoOrc(Orc orc){
        int danoCausado = orc.getDanoDeAtaque();
        this.vida -= danoCausado;
    }

    public double getVida(){
        return this.vida;
    }

    public String getNome() {
        return this.nome;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public Status getStatus() {
        return this.status;
    }

    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }

    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }

    public int hashCode(){
        return this.nome.hashCode()+"Personagem".hashCode();
    }

}
