package Comportamentos;

import Game.Item;
import java.util.ArrayList;

public abstract class Comportamento {
    private ArrayList<String> comandos;
    
    public Comportamento(){
        comandos = new ArrayList<>();
        adicionarComandos();
    }
    
    public ArrayList<String> getComandos(){
        return this.comandos;
    }
    
    public void addComando(String cmd){
        this.comandos.add(cmd);
    }
    
    public abstract void executar(Item item);
    protected abstract void adicionarComandos();
    
}
