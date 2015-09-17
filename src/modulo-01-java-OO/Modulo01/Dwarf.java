public class Dwarf {
    private String nome;
    private int vida, experiencia;
    private Status status;
    
    public Dwarf() {
        this.vida = 110;
        this.status = Status.VIVO;
    }
    
    public Dwarf(String nome) {
        this();
        this.nome = nome;
    }
    
    public void receberFlechada() {
        
        int dano = 10, vidaAposFlechada = this.vida-dano;
        
        if (vidaAposFlechada == 0) {
            this.status = Status.MORTO;
        } 
        
        if (vida > 0) {
            this.vida = vidaAposFlechada;
        }
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public String getNome() {
        return this.nome;
    }
}