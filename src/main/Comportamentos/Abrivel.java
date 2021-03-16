package Comportamentos;

import Area.Area;
import Game.Item;
import Game.Jogador;
import java.util.ArrayList;

public class Abrivel extends Comportamento {

    private ArrayList<Item> itensContidos;
    private ArrayList<Item> itensNecessarios;

    public Abrivel() {
    }

    public Abrivel(ArrayList<Item> itensNecessarios, ArrayList<Item> itensContidos) {
        this.itensContidos = itensContidos;
        this.itensNecessarios = itensNecessarios;
    }

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
        Area area = jogador.getAreaAtual();

        if (itensNecessarios != null && !jogador.maoContem(itensNecessarios)) {
            System.out.println("Você precisa de uma certa chave em mãos para abrir o compartimento");
        } else {
            System.out.println("Você abriu o(a) " + item.getNome());
            System.out.print("Itens encontrados dentro do(a) " + item.getNome() + ": ");
            for (Item i : itensContidos) {
                System.out.print(i.getNome() + " | ");
            }
            System.out.println("");
            Jogador.getInstancia().getAreaAtual().addItem(itensContidos);
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("abrir");
        addComando("abra");
        addComando("abre");
    }

}
