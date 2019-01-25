package negocios.unidades;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public abstract class UnidadesMedida {
    private static Set<String> unidadesMedidaRegistadas = new HashSet<>();
    protected String unidade;

    /**
     *
     * @param unidade
     */
    protected UnidadesMedida(String unidade){
        this.unidade = unidade;
        if(!unidadesMedidaRegistadas.contains(unidade)){
            unidadesMedidaRegistadas.add(unidade);
        }
    }

    /**
     *
     * @return
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     *
     * @param unidade
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
        if(!unidadesMedidaRegistadas.contains(unidade)){
            unidadesMedidaRegistadas.add(unidade);
        }
    }

    /**
     *
     * @return
     */
    public static Set<String> getUnidadesMedidaRegistadas() {
        return unidadesMedidaRegistadas;
    }
}
