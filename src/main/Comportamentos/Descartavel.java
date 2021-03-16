package Comportamentos;

import Game.Item;
import Game.Jogador;

public class Descartavel extends Comportamento {

    @Override
    public void executar(Item item) {
        String nomeI = item.getNome();
        nomeI = nomeI.substring(0, 1).toUpperCase() + nomeI.substring(1);
        Jogador jogador = Jogador.getInstancia();
        if(!jogador.maoContem(item)){
            System.out.println("Você não pegou esse item");
        }else{
            System.out.println(nomeI + " descartado(a)");
            jogador.removerItemMao(item);
            jogador.getAreaAtual().addItem(item);
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("soltar");
        addComando("largar");
        addComando("solte");
        addComando("largue");
    }
    
}
