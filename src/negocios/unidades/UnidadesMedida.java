package negocios.unidades;

import java.util.HashSet;
import java.util.Set;

//Por em set
public abstract class UnidadesMedida {
    private static Set<String> unidadesMedidaRegistadas = new HashSet<>();
    protected String unidade;

    protected UnidadesMedida(String unidade){
        this.unidade = unidade;
        if(!unidadesMedidaRegistadas.contains(unidade)){
            unidadesMedidaRegistadas.add(unidade);
        }
    }
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public static Set<String> getUnidadesMedidaRegistadas() {
        return unidadesMedidaRegistadas;
    }
}
