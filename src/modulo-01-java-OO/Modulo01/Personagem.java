
public class Personagem
{
   
   protected int vida, experiencia;
   protected String nome;
   protected Status status;
   protected Inventario inventario = new Inventario();
   public void atacarOrc(Orc orc){
        orc.levarAtaqueDeAnao();
    }
    
    public void receberAtaqueDoOrc(Orc orc){
        int danoCausado = orc.getDanoDeAtaque();
        this.vida -= danoCausado;
    }
    
    public int getVida(){
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

}
