package Controle;

import Game.Jogador;
import Game.Mundo;

public class Game {

    private Jogador jogador;
    private Interpretador interpretador;

    public Game() {
        Mundo.getInstancia();
        jogador = Jogador.getInstancia();
        interpretador = Interpretador.getInstancia();
        interpretador.setJogador(jogador);
    }

    public void iniciarGame() {
        jogador.getAreaAtual().exibirArea();
        String cmd = interpretador.getComando();
        
        while (!cmd.equalsIgnoreCase("sair")) {
            
            interpretador.analisarComando(cmd);
            cmd = interpretador.getComando();

        }
    }

}
