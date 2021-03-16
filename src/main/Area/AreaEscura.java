package Area;

import Game.Item;
import java.util.ArrayList;

public class AreaEscura{
    
    private String descricao;
    private ArrayList<Item> itensInvisiveis;

    public AreaEscura(String descricao2) {
        this.itensInvisiveis = new ArrayList<>();
        this.descricao = descricao2;
    }
    
    public void addItemInvisivel(Item item){
        itensInvisiveis.add(item);
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<Item> getItensInvisiveis() {
        return itensInvisiveis;
    }
 
    public void apagaItensInvisiveis(){
        itensInvisiveis.clear();
    }
}
