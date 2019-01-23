package negocios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Orientado extends Utilizador {
    private Map<String,Categoria> categoriasMap = new HashMap<>();
    private Set<Indicador> indicadoresSemCategoriaSet = new HashSet<>();
    private Map<Categoria,Indicador> indicadoresComCategoria = new HashMap<>();
    public Orientado(String utilizador, String password){
        super(utilizador, password);
    }

    public void adicionarCategoria(Categoria categoria) {
        String nome = categoria.getNome();
        categoriasMap.putIfAbsent(nome,categoria);
        insertCategoria(nome);
    }

    public void retirarCategoria(String nomeCategoria){
        categoriasMap.remove(nomeCategoria);
        removerCategoria(nomeCategoria);
    }
    public Map<String,Categoria> getCategoriasMap(){
        return categoriasMap;
    }
    public Categoria getCategoriasMapElement(String nome){
        return categoriasMap.get(nome);
    }

    public Map<Categoria, Indicador> getIndicadoresComCategoria() {
        return indicadoresComCategoria;
    }

    public Set<Indicador> getIndicadoresSemCategoriaSet() {
        return indicadoresSemCategoriaSet;
    }


}
