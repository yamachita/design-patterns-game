package Comportamentos;

import Game.Item;
import Game.Jogador;
import java.util.ArrayList;

public class UsavelFixo extends Comportamento{
    
    String msg;
    ArrayList<Item> itensNecessarios;

    public UsavelFixo(ArrayList<Item> itensNecessarios, String msg) {
        this.itensNecessarios = itensNecessarios;
        this.msg = msg;
    }

    @Override
    public void executar(Item item) {
        Jogador jogador = Jogador.getInstancia();
        if(itensNecessarios == null || jogador.maoContem(itensNecessarios)){
            System.out.println("Você usou o(a) " + item.getNome());
            System.out.println(msg);
        }else{
            System.out.println("Você não pode usar o(a) "+ item.getNome());
        }
    }

    @Override
    protected void adicionarComandos() {
        addComando("usar");
        addComando("use");
        addComando("usa");
    }
    
}
