package negocios.unidades;

import java.util.ArrayList;
import java.util.List;

public abstract class UnidadesMedida {
    private static List<String> unidadesMedidaRegistadas = new ArrayList<>();
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

    public static List<String> getUnidadesMedidaRegistadas() {
        return unidadesMedidaRegistadas;
    }
}
