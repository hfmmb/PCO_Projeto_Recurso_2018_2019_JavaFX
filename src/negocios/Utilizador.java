package negocios;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe abstrata responsavel por criar utilizadores, adicionalmente tambem faz a gestao de alguns elementos
 * comuns as suas subclasses.
 */
public abstract class Utilizador {
    protected String utilizador;
    protected String password;
    private static Set<String> todasCategoriasSet = new HashSet();

    protected Utilizador(String utilizador, String password){
        this.utilizador = utilizador;
        this.password = password;
    }

    /**
     * Obtem o username do utilizador
     * @return Retorna o username do utilizador
     */
    protected String getUtilizador() {
        return utilizador;
    }

    /**
     * Obtem a password do utilizador
     * @return Retorna a password do utilizador
     */
    protected String getPassword() {
        return password;
    }

    /**
     * Insere uma categoria ao Set que contem todas as categorias registadas
     * @param categoria Nome da categoria
     */
    protected void insertCategoria(String categoria){
        if(!todasCategoriasSet.contains(categoria)) {
            todasCategoriasSet.add(categoria);
        }
    }

    /**
     * Obtem o Set que contem todas as categorias registadas no sistema
     * @return Retorna o set de categorias registadas no sistema
     */
    public static Set<String> getTodasCategoriasRegistadas(){
        return todasCategoriasSet;
}

    /**
     * Remove uma categoria ao Set que contem todas as categorias registadas
     * @param categoria Nome da categoria
     */
    protected void removerCategoria(String categoria){
        todasCategoriasSet.remove(categoria);
}

}
