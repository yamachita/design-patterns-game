package Area;

import Game.Item;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class AreaObservadora extends Area implements Observer {
    
    private Observable observado;
    private String descricao2;
    private ArrayList<Item> itensNovos;

    public AreaObservadora(String nome, String descricao, AreaEscura areaEscura, Observable observado, String descricao2, ArrayList<Item> itensNovos) {
        super(nome, descricao, areaEscura);
        this.observado = observado;
        observado.addObserver(this);
        this.descricao2 = descricao2;
        this.itensNovos = itensNovos;
    }

    public AreaObservadora(String nome, String descricao, Observable observado, String descricao2, ArrayList<Item> itensNovos) {
        super(nome, descricao);
        this.observado = observado;
        observado.addObserver(this);
        this.descricao2 = descricao2;
        this.itensNovos = itensNovos;
    }

    @Override
    public void update(Observable o, Object o1) {
        super.setDescricao(getDescricao() + "\n" + this.descricao2);
        super.addItem(itensNovos);
    }
    
    

}
