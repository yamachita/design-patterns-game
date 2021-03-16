package Controle;
import Area.Area;
import Game.Item;
import Game.Jogador;
import Game.Saida;

import java.util.ArrayList;
import java.util.Scanner;

public class Interpretador {

    private static Interpretador instancia = null;
    private Jogador jogador;
    private Scanner teclado;
    private Area areaAtual;

    public Interpretador() {
        jogador = Jogador.getInstancia();
        teclado = new Scanner(System.in);
        areaAtual = jogador.getAreaAtual();
    }

    public static Interpretador getInstancia() {
        if (instancia == null) {
            instancia = new Interpretador();
        }
        return instancia;
    }

    public String getComando() {

        System.out.print("> ");
        return teclado.nextLine();

    }

    public void analisarComando(String cmd) {

        String[] vComando = tratarComando(cmd);

        if (cmd.equalsIgnoreCase("abrir mochila")) {
            Jogador.getInstancia().exibirInventario();
        } else {
            if (!(vComando.length > 1)) {
                System.out.println("Comando inválido");
            } else {
                if (comandoDirecional(vComando)) {
                    analisarComandoDirecional(vComando);
                } else {
                    analisarComandoItem(vComando);
                }
            }
        }
    }

    private boolean comandoDirecional(String[] comando) {
        if (comando[0].equalsIgnoreCase("ir")) {
            return true;
        }
        return false;
    }

    private void analisarComandoDirecional(String[] comando) {
        for (Saida s : areaAtual.getSaidas()) {
            if (comando[1].equalsIgnoreCase(s.getDirecao())) {
                s.verificarBloqueio();
                if (!s.isBloqueada()) {
                    jogador.setAreaAtual(s.getAreaSeguinte());
                    areaAtual = jogador.getAreaAtual();
                    areaAtual.exibirArea();
                } else {
                    System.out.print("Saída bloqueada.");
                    System.out.println(" "+s.getDescricao());
                }
                return;
            }
        }

        System.out.println("Não há saida na direção " + comando[1]);
    }

    private void analisarComandoItem(String[] comando) {

        ArrayList<Item> itens = new ArrayList<>();
        itens.addAll(areaAtual.getItens());
        itens.addAll(jogador.getInventario());
        itens.addAll(jogador.getMao());

        Item item = null;

        for (Item it : itens) {
            if (it.getNome().equalsIgnoreCase(comando[1])) {
                item = it;
            }
        }
        if (item == null) {
            System.out.println("Comando inválido");
        } else {
            if (!item.executar(comando[0])) {
                System.out.println("Comando inválido");
            }
        }
    }

    private String[] tratarComando(String comando) {

        comando = comando.trim();
        comando = comando.replaceAll(" o ", " ");
        comando = comando.replaceAll(" a ", " ");
        comando = comando.replaceAll(" para ", " ");
        comando = comando.replaceAll(" de ", " ");
        comando = comando.replaceAll(" da ", " ");
        comando = comando.replaceAll(" do ", " ");
        comando = comando.replaceAll(" pra ", " ");
        comando = comando.replaceAll(" pro ", " ");
        
        String[] vComando = comando.split(" ");

        return vComando;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
