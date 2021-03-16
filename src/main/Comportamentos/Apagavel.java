package Comportamentos;

import Game.Item;
import Game.Jogador;

public class Apagavel extends Comportamento {

    @Override
    public void executar(Item item) {
        String nomeI = item.getNome();
        nomeI = nomeI.substring(0, 1).toUpperCase() + nomeI.substring(1);
        if (Jogador.getInstancia().maoContem(item)) {
            System.out.println(nomeI + " apagada.");
            atualizarArea();
        } else {
            System.out.println("Voce não pegou o(a) " + item.getNome());
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("apagar");
        addComando("apague");
    }

    private void atualizarArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
