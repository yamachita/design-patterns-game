package Comportamentos;

import Game.Item;
import Game.Jogador;

public class Legivel extends Comportamento {

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
        if (!jogador.maoContem(item)) {
            System.out.println("É necessário pegar o objeto primeiro.");
        } else {
            System.out.println(item.getDescricao());
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("ler");
        addComando("leia");
    }

}
