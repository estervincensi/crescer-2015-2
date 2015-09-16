
public class Dwarf
{
    private int vida;
    private String nome;

    public Dwarf()
    {
        this.vida=110;
    }

    public void recebeFlechada(){
        this.vida-= 10;
    }
    
    public int getVida(){
        return this.vida;
    }

}
