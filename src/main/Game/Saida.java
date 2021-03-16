package Game;

import Area.Area;
import java.util.ArrayList;

public class Saida {

    private String direcao;
    private Area areaSeguinte;
    private ArrayList<Item> itensNecessarios;
    private ArrayList<Item> itensBloqueio;
    private boolean bloqueada;
    private String descricao;

    public Saida(String direcao, Area areaSeguinte) {
        itensNecessarios = new ArrayList<>();
        itensBloqueio = new ArrayList<>();
        this.direcao = direcao;
        this.areaSeguinte = areaSeguinte;
        this.bloqueada = false;
    }

    public Saida(String direcao, Area areaSeguinte, ArrayList<Item> itensNecessarios, ArrayList<Item> itensBloqueio, String descricao) {
        this.direcao = direcao;
        this.areaSeguinte = areaSeguinte;
        this.itensNecessarios = itensNecessarios;
        this.itensBloqueio = itensBloqueio;
        this.descricao = descricao;
        this.bloqueada = true;
    }

    public void verificarBloqueio() {

        Jogador jogador = Jogador.getInstancia();
        if (((itensBloqueio == null || itensBloqueio.isEmpty()) && (itensNecessarios == null || itensNecessarios.isEmpty()))) {
            bloqueada = false;
        } else {
            if ((itensNecessarios == null || jogador.inventarioContem(itensNecessarios) || jogador.maoContem(itensNecessarios)) && !(jogador.getAreaAtual().contemItem(itensBloqueio)) && !(jogador.getAreaAtual().contemItemInvisivel(itensBloqueio))) {
                bloqueada = false;
            } else {
                bloqueada = true;
            }
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public Area getAreaSeguinte() {
        return areaSeguinte;
    }

    public void setAreaSeguinte(Area areaSeguinte) {
        this.areaSeguinte = areaSeguinte;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

}
