package Game;

import Comportamentos.Comportamento;
import java.util.ArrayList;
import java.util.Observable;

public class Item extends Observable {
    
    private String nome;
    private String descricao;
    private ArrayList<Comportamento> comportamentos;
    
    private boolean executando;
    
    public Item(String nome){
        this.nome = nome;
        this.comportamentos = new ArrayList<>();
    }

    public Item(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.comportamentos = new ArrayList<>();
    }
    
    public void addComportamento(Comportamento c){
        comportamentos.add(c);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public boolean executar(String cmd){
        for(Comportamento c : comportamentos ){
            for(String s : c.getComandos()){
                if(s.equalsIgnoreCase(cmd)){
                    c.executar(this);
                    return true;
                }
            }
        }
        return false;
    }
    
    public String getNome(){
        return this.nome;
    }

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }
    
    public void removerComportamento(Comportamento c){
        this.comportamentos.remove(c);
    }
    
    public void executouAcao(){
            setChanged();
            notifyObservers();
    }
}
