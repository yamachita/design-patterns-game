package Comportamentos;

import Game.Item;
import Game.Jogador;

public class ExaminavelADistancia extends Comportamento {

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
            System.out.println(item.getDescricao());
    }

    @Override
    protected void adicionarComandos() {
        addComando("examine");
        addComando("examinar");
    }

}
