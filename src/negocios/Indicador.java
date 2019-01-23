package negocios;

import negocios.unidades.UnidadesMedida;

import java.util.HashSet;
import java.util.Set;

public class Indicador {
    private String designacao;
    private UnidadesMedida unidadeMedida;
    private Set<HistoricoIndicador> historicoIndicador = new HashSet<>();
    public Indicador(String designacao, UnidadesMedida unidadeMedida){
        this.designacao = designacao;
        this.unidadeMedida = unidadeMedida;
        historicoIndicador.add(new HistoricoIndicador(unidadeMedida.getUnidade()));
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public UnidadesMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadesMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Set getSetUnidadesMedida(){
        return unidadeMedida.getUnidadesMedidaRegistadas();
    }

    public Set<HistoricoIndicador> getHistoricoIndicador() {
        return historicoIndicador;
    }
}
