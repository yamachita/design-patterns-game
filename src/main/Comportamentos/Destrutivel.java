package Comportamentos;

import Area.Area;
import Game.Item;
import Game.Jogador;
import java.util.ArrayList;

public class Destrutivel extends Comportamento {

    private String msg;
    private ArrayList<Item> itensNecessarios;

    public Destrutivel(ArrayList<Item> itensNecessarios, String msg) {
        this.itensNecessarios = itensNecessarios;
        this.msg = msg;
    }

    public void setItensNecessarios(ArrayList<Item> itensNecessarios) {
        this.itensNecessarios = itensNecessarios;
    }

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
        Area area = jogador.getAreaAtual();

        if (!jogador.maoContem(itensNecessarios)) {
            System.out.println("É necessário ter um certo item em mãos para destruir esse objeto");
        } else {
            String nomeI = item.getNome();
            nomeI = nomeI.substring(0,1).toUpperCase()+nomeI.substring(1);
            System.out.println(nomeI + " destruido(a)");
            System.out.println(msg);
            item.setExecutando(true);
            item.executouAcao();
            jogador.removerItemInventario(item);
            jogador.removerItemMao(item);
            area.removerItem(item);
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("destruir");
        addComando("destrua");
    }

}
