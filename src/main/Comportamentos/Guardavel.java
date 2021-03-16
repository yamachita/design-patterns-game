package Comportamentos;
import Comportamentos.Comportamento;
import Game.Item;
import Game.Jogador;

public class Guardavel extends Comportamento {

    @Override
    public void executar(Item item) {
        String nomeI = item.getNome();
        nomeI = nomeI.substring(0, 1).toUpperCase() + nomeI.substring(1);

        Jogador jogador = Jogador.getInstancia();
        if (jogador.getInventario().contains(item)) {
            System.out.println(nomeI + " já está na mochila");
        } else {
            if (jogador.maoContem(item)) {
                jogador.addInventario(item);
                jogador.removerItemMao(item);
                System.out.println(nomeI + " guardado na mochila.");
            } else {
                System.out.println("É preciso pegar o item primeiro.");
            }
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("Guardar");
        addComando("Armazenar");
    }

}
