import java.util.*;

public interface EstrategiadeAtaque{
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
    void atacar(ArrayList<Elfo> pelotao,ArrayList<Dwarf> dwarves);
}
