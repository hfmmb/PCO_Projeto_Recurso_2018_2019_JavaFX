package negocios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

public void criarNovoPlano(String valorMinimoDesejado, String valorMaximoDesejado, String designacaoIndicador, Double valorUnidade, String unidade, String nomeSupervisor) {
        Plano plano = new Plano(valorMinimoDesejado,valorMaximoDesejado, new Indicador(designacaoIndicador,valorUnidade,unidade),nomeSupervisor);
        planosSet.add(plano);
}
public Set<Plano> getPlanosSet(){
        return planosSet;
}

}
