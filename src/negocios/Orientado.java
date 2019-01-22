package negocios;

import java.util.HashMap;
import java.util.Map;

public class Orientado extends Utilizador {
    private Map<String,Categoria> categoriasMap = new HashMap<>();
    public Orientado(String utilizador, String password){
        super(utilizador, password);
    }

    @Override
    public String getUtilizador() {
        return super.getUtilizador();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public void adicionarCategoria(Categoria categoria) {
        String nome = categoria.getNome();
        categoriasMap.putIfAbsent(nome,categoria);
        insertCategoria(nome);
    }

    public void removerCategoria(String nomeCategoria){
        categoriasMap.remove(nomeCategoria);
        removerCategoria(nomeCategoria);
    }
}
