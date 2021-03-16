package Area;

import Game.Item;
import Game.Saida;
import java.util.ArrayList;

public class Area {

    private String nome;
    private String descricao;
    private ArrayList<Item> itens;
    private ArrayList<Saida> saidas;
    private AreaEscura areaEscura;

    public Area(String nome, String descricao) {
        itens = new ArrayList<>();
        saidas = new ArrayList<>();
        this.nome = nome;
        this.descricao = descricao;
    }

    public Area(String nome, String descricao, AreaEscura areaEscura) {
        itens = new ArrayList<>();
        saidas = new ArrayList<>();
        this.nome = nome;
        this.descricao = descricao;
        this.areaEscura = areaEscura;
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void addSaida(Saida saida) {
        saidas.add(saida);
    }

    public void addSaida(ArrayList<Saida> s) {
        saidas.addAll(s);
    }

    public ArrayList<Saida> getSaidas() {
        return saidas;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void exibirItens() {
        for (Item i : itens) {
            System.out.println(i.getNome());
        }
    }

    public void exibirArea() {
        System.out.println(nome + "\n" + descricao);
        if (!(itens.isEmpty())) {
            System.out.print("O que você vê: ");
            for (Item i : itens) {
                System.out.print(i.getNome() + " | ");
            }
            System.out.println();
        }

    }

    public boolean isEscura() {
        return false;
    }

    public String getDescricao2() {
        return areaEscura.getDescricao();
    }

    public void revelarItens() {
        itens.addAll(areaEscura.getItensInvisiveis());
        areaEscura.apagaItensInvisiveis();
    }

    public boolean temAreaEscura() {
        if (areaEscura == null) {
            return false;
        }
        return true;
    }

    public boolean contemItem(Item item) {
        return itens.contains(item);
    }

    public boolean contemItem(ArrayList<Item> item) {
        if (item != null) {
            return itens.containsAll(item);
        }
        return false;
    }

    public void addItem(ArrayList<Item> i) {
        itens.addAll(i);
    }

    public boolean contemItemInvisivel(ArrayList<Item> item) {
        if (item == null || (areaEscura == null || areaEscura.getItensInvisiveis().isEmpty())) {
            return false;
        } else {
            return areaEscura.getItensInvisiveis().containsAll(item);
        }
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
