package negocios;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Classe abstrata responsavel por criar utilizadores
 */
public abstract class Utilizador {
    protected String utilizador;
    protected String password;
    protected Map<String,Indicador> indicadoresMap;
    private static Set todasCategoriasSet = new HashSet();
    protected Utilizador(String utilizador, String password){
        this.utilizador = utilizador;
        this.password = password;
    }


    protected Utilizador(String utilizador, String password, Indicador indicador){
        this.utilizador = utilizador;
        this.password = password;
        this.indicadoresMap.putIfAbsent(indicador.getDesignacao(),indicador);
    }


    /**
     * Obtem o username do utilizador
     * @return
     */
    protected String getUtilizador() {
        return utilizador;
    }

    /**
     * Obtem a password do utilizador
     * @return
     */
    protected String getPassword() {
        return password;
    }

    /**
     * Insere uma categoria ao Set que contem todas as categorias registadas
     * @param categoria
     */
    protected void insertCategoria(String categoria){
        if(!todasCategoriasSet.contains(categoria)) {
            todasCategoriasSet.add(categoria);
        }
    }
    public static Set getTodasCategoriasRegistadas(){
        return todasCategoriasSet;
}
    /**
     * Remove uma categoria ao Set que contem todas as categorias registadas
     * @param categoria
     */

    protected void removerCategoria(String categoria){
        todasCategoriasSet.remove(categoria);
}
}
