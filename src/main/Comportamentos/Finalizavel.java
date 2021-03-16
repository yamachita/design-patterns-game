package Comportamentos;

import Game.Item;
import Game.Jogador;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Finalizavel extends Comportamento implements Observer {

    Observable observado;
    String msg;
    String msg2;
    ArrayList<Item> itensNecessarios;
    boolean fim = false;

    public Finalizavel(ArrayList<Item> itensNecessarios, Observable observado, String msg, String msg2) {
        this.itensNecessarios = itensNecessarios;
        observado.addObserver(this);
        this.msg = msg;
        this.msg2 = msg2;
        this.observado = observado;
    }

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
        if (jogador.maoContem(itensNecessarios)) {
            if (!fim) {
                System.out.println(msg);
            } else {
                System.out.println(msg2);
                System.exit(0);
            }
        } else {
            System.out.println("Você não pode usar o(a) " + item.getNome());
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("usar");
        addComando("use");
        addComando("usa");
    }

    @Override
    public void update(Observable o, Object arg) {
        fim = true;
    }

}
