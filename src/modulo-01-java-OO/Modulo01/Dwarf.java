
public class Dwarf
{
    private int vida;
    private String nome;

    public Dwarf(String nome)
    {
        this.nome=nome;
        this.vida=110;
    }

    public void recebeFlechada(){
        vida=vida-10;
    }

}
