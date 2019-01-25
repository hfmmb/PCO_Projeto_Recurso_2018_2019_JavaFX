package negocios;

import java.util.*;

/**
 *
 */
public class Orientado extends Utilizador {
    private Map<String,Categoria> categoriasMap = new HashMap<>();
    private Set<Plano> planosSet = new HashSet<>();
    public Orientado(String utilizador, String password){
        super(utilizador, password);
    }

    /**
     *
     * @param nome
     */
    public void adicionarCategoria(String nome) {
        Categoria categoria = new Categoria(nome);
        categoriasMap.putIfAbsent(nome,categoria);
        insertCategoria(nome);
    }

    /**
     *
     * @param nomeCategoria
     */
    public void retirarCategoria(String nomeCategoria){
        categoriasMap.remove(nomeCategoria);
        removerCategoria(nomeCategoria);
    }

    /**
     *
     * @return
     */
    public Map<String,Categoria> getCategoriasMap(){
        return categoriasMap;
    }

    /**
     *
     * @param nome
     * @return
     */
    public Categoria getCategoriasMapElement(String nome){
        return categoriasMap.get(nome);
    }

    /**
     *
     * @param date
     * @param valorMinimoDesejado
     * @param valorMaximoDesejado
     * @param designacaoIndicador
     * @param valorUnidade
     * @param unidade
     * @param nomeSupervisor
     */
    public void criarNovoPlano(Date date, String valorMinimoDesejado, String valorMaximoDesejado, String designacaoIndicador, Double valorUnidade, String unidade, String nomeSupervisor) {
    planosSet.add(new Plano(date,valorMinimoDesejado,valorMaximoDesejado, new Indicador(designacaoIndicador,valorUnidade,unidade),nomeSupervisor));

}

    /**
     *
     * @return
     */
    public Set<Plano> getPlanosSet(){
        return planosSet;
}

}
