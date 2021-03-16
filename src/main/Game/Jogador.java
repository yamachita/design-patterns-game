package Game;

import Area.Area;
import java.util.ArrayList;

public class Jogador {

    private Area areaAtual;
    private ArrayList<Item> inventario;
    private ArrayList<Item> mao;
    private static Jogador instancia = null;

    public static Jogador getInstancia() {
        if (instancia == null) {
            instancia = new Jogador();
        }
        return instancia;
    }

    public Jogador() {
        inventario = new ArrayList<>();
        mao = new ArrayList<>();
    }

    public void addInventario(Item item) {
        inventario.add(item);
    }

    public boolean inventarioContem(Item item) {
        return inventario.contains(item);
    }

    public Area getAreaAtual() {
        return areaAtual;
    }

    public void setAreaAtual(Area areAtual) {
        this.areaAtual = areAtual;
    }

    public void exibirInventario() {
        System.out.println("*MOCHILA*");

        if (inventario.isEmpty()) {
            System.out.println("vazio");
        } else {
            for (Item i : inventario) {
                System.out.print(i.getNome() + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public ArrayList<Item> getMao() {
        return mao;
    }

    public void addMao(Item item) {
        mao.add(item);
    }

    public boolean maoContem(Item item) {
        return mao.contains(item);
    }

    public void exibirMao() {
        for (Item i : mao) {
            System.out.println(i.getNome());
        }
    }

    public void removerItemInventario(Item item) {
        inventario.remove(item);
    }

    public void removerItemMao(Item item) {
        mao.remove(item);
    }

    public boolean maoContem(String nome) {

        for (Item i : mao) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }

        return false;
    }

    public boolean maoContem(ArrayList<Item> it) {
        if (it != null) {
            return mao.containsAll(it);
        }
        return false;
    }

    public boolean inventarioContem(ArrayList<Item> it) {
        if (it != null) {
            return mao.containsAll(it);
        }
        return false;
    }

    public boolean maoCheia() {
        if (mao.size() > 1) {
            return true;
        } else {
            return false;
        }
    }
}
