package Comportamentos;

import Area.Area;
import Game.Item;
import Game.Jogador;

public class Luminoso extends Comportamento {

    @Override
    public void executar(Item item) {
        String nomeI = item.getNome();
        nomeI = nomeI.substring(0, 1).toUpperCase() + nomeI.substring(1);
        if (Jogador.getInstancia().maoContem(item)) {
            System.out.println(nomeI + " acesa.");
            atualizarArea();
        } else {
            System.out.println("Voce não pegou o(a) " + item.getNome());
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("acender");
        addComando("acenda");
        addComando("acende");
    }

    private void atualizarArea() {
        Area area = Jogador.getInstancia().getAreaAtual();

        if (area.temAreaEscura()) {
            System.out.println(area.getDescricao2());
            area.revelarItens();
        }
    }

}
