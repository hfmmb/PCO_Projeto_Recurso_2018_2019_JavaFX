package negocios;

public class Supervisor extends Utilizador {
    private String especialidade;
    public Supervisor(String utilizador, String password, String especialidade){
        super(utilizador, password);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Permite ao supervisor inserir uma nova categoria num determinado orientado
     * @param nomeCategoria
     * @param orientado
     */
    protected void inserirCategoriaOrientado(String nomeCategoria, Orientado orientado) {
        orientado.adicionarCategoria(new Categoria(nomeCategoria)); //Adiciona uma categoria ao orientado
        insertCategoria(nomeCategoria); //Atualiza o mapa de todas as categorias
    }
    /**
     * Permite ao supervisor remover uma categoria existente num determinado orientado
     * @param nomeCategoria
     * @param orientado
     */

    protected void removerCategoriaOrientado(String nomeCategoria, Orientado orientado) {
        orientado.removerCategoria(nomeCategoria); //Retira uma categoria ao orientado
        removerCategoria(nomeCategoria); //Atualiza o mapa de todas as categorias
    }
}
