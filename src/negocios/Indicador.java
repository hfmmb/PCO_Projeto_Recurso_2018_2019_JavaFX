package negocios;

import negocios.unidades.UnidadesMedida;
import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;
import negocios.unidades.UnidadesMedidaOutra;

import java.util.HashSet;
import java.util.Set;

public class Indicador {
    private String designacao;
    private UnidadesMedida unidadeMedida;
    private Set<Observacao> historicoObservacoesSet = new HashSet<>();
    public Indicador(String designacao, Double valorUnidade, String unidade){
        this.designacao = designacao;
        this.unidadeMedida = criarUnidadeMedida(valorUnidade, unidade);
        historicoObservacoesSet.add(new Observacao(valorUnidade.toString(),unidade));
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

    public Set getUnidadesMedida(){
        return unidadeMedida.getUnidadesMedidaRegistadas();
    }

    public Set<Observacao> getHistoricoIndicador() {
        return historicoObservacoesSet;
    }

    private UnidadesMedida criarUnidadeMedida(Double valor ,String unidade){
        if(unidade.equals("Metros")){
            return new UnidadesMedidaMetrico(valor);
        } else if (unidade.equals("Milhas")){
            return new UnidadesMedidaImperial(valor);
        }else {
            return new UnidadesMedidaOutra(valor.toString(), unidade);
        }
    }
}
