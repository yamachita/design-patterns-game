package Comportamentos;

import Area.Area;
import Game.Item;
import Game.Jogador;
import java.util.ArrayList;

public class PortaAbrivel extends Comportamento {

    private ArrayList<Item> itensNecessarios;

    public PortaAbrivel(ArrayList<Item> itensNecessarios) {
        this.itensNecessarios = itensNecessarios;
    }

    public void setItensNecessarios(ArrayList<Item> itensNecessarios) {
        this.itensNecessarios = itensNecessarios;
    }

    @Override
    public void executar(Item porta) {
        Jogador jogador = Jogador.getInstancia();
        Area area = jogador.getAreaAtual();

        if (!jogador.maoContem(itensNecessarios)) {
            System.out.println("É necessário ter uma certa chave em mãos para abrir esta porta");
        } else {
            String nomeI = porta.getNome();
            nomeI = nomeI.substring(0,1).toUpperCase()+nomeI.substring(1);
            System.out.println(nomeI + " aberto(a)");
            area.removerItem(porta);
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("abrir");
        addComando("abra");
    }

}
