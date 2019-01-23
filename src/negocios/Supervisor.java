package negocios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Supervisor extends Utilizador {
    private String especialidade;
    private Set<Orientado> orientadoSet = new HashSet<>();
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

    /**
     * Associa um orientado a um supervisor
     */
    public void associarOrientadoSupervisor(Orientado orientado){
        this.orientadoSet.add(orientado);
    }

    public void desassociarOrientadoSupervisor(Orientado orientado){
        this.orientadoSet.remove(orientado);
    }
    public Set<Orientado> getOrientadosAssociadosSupervisor(){
        return this.orientadoSet;
    }
    public Set<String> getUsernameOrientadosAssociadosSupervisor(){
        Set<String> set = new HashSet<>();
        Iterator iterator = orientadoSet.iterator();
        Orientado orientado;
        while (iterator.hasNext()){
            orientado = (Orientado) iterator.next();
            set.add(orientado.getUtilizador());
        }
        return set;
}}
