package Comportamentos;

import Game.Item;
import Game.Jogador;

public class UsavelUnico extends Comportamento{
    
    String msg;

    public UsavelUnico(String msg) {
        this.msg = msg;
    }

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
        if(jogador.maoContem(item) && !item.isExecutando()){
            System.out.println("Você usou o(a) " + item.getNome());
            System.out.println(msg);
            item.setExecutando(true);
            item.executouAcao();
            jogador.removerItemMao(item);
            jogador.removerItemInventario(item);
        }else{
            System.out.println("Você não pode usar esse item");
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("usar");
        addComando("use");
        addComando("usa");
    }
    
}
