package Comportamentos;

import Comportamentos.Comportamento;
import Area.Area;
import Game.Item;
import Game.Jogador;

public class Pegavel extends Comportamento {

    @Override
    public void executar(Item item) {
        
        Area area = Jogador.getInstancia().getAreaAtual();
        if (Jogador.getInstancia().maoContem(item)) {
            System.out.println("Você já está com o(a) " + item.getNome() + " na mão");
        } else if (Jogador.getInstancia().maoCheia()) {
            System.out.println("Você tem coisas demais nas mãos.");
        } else {
            System.out.println("Você pegou o(a) " + item.getNome());
            Jogador.getInstancia().addMao(item);

            if (area.contemItem(item)) {
                area.removerItem(item);
            } else {
                Jogador.getInstancia().removerItemInventario(item);
            }
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("Pegar");
        addComando("Pegue");

    }
}
