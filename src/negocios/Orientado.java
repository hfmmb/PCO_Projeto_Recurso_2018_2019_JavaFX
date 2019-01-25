package negocios;

import java.util.*;

public class Orientado extends Utilizador {
    private Map<String,Categoria> categoriasMap = new HashMap<>();
    private Set<Plano> planosSet = new HashSet<>();
    public Orientado(String utilizador, String password){
        super(utilizador, password);
    }

    public void adicionarCategoria(String nome) {
        Categoria categoria = new Categoria(nome);
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

public void criarNovoPlano(Date date, String valorMinimoDesejado, String valorMaximoDesejado, String designacaoIndicador, Double valorUnidade, String unidade, String nomeSupervisor) {
    planosSet.add(new Plano(date,valorMinimoDesejado,valorMaximoDesejado, new Indicador(designacaoIndicador,valorUnidade,unidade),nomeSupervisor));
}
public Set<Plano> getPlanosSet(){
        return planosSet;
}

}
