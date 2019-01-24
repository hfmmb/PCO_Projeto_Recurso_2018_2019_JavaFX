package negocios;

import negocios.unidades.UnidadesMedida;
import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;
import negocios.unidades.UnidadesMedidaOutra;

import java.util.HashSet;
import java.util.Set;

public class Indicador {
    private String designacao;
    private Boolean tipo; //true para Automatico, false para Manual
    private UnidadesMedida unidadeMedida;
    private Set<Observacao> historicoObservacoesIndicadorSet = new HashSet<>();
    private static Set<Indicador> indicadoresRegistadosSet = new HashSet<>();
    public Indicador(String designacao, Double valorUnidade, String unidade){
        this.designacao = designacao;
        this.tipo = false;
        this.unidadeMedida = criarUnidadeMedida(valorUnidade, unidade);
        historicoObservacoesIndicadorSet.add(new Observacao(valorUnidade.toString(),unidade));
    }

    public Indicador(String designacao, String unidade){
        this.designacao = "Automatic Indicador " + designacao;
        this.tipo = true;
        this.unidadeMedida = criarUnidadeMedida(0.0, unidade);
        historicoObservacoesIndicadorSet.add(new Observacao("0.0", unidade));
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

    public Boolean getTipo() {
        return tipo;
    }
    public static void addIndicadorSet(String designacao, Boolean tipo,Double valorUnidade, String unidade){
        if(tipo == false){
            indicadoresRegistadosSet.add(new Indicador(designacao,valorUnidade,unidade));//Manual
        }else{
            indicadoresRegistadosSet.add(new Indicador(designacao,unidade)); //Automatico
        }
    }

    public static void removeIndicadorSet(Indicador indicador){
        indicadoresRegistadosSet.remove(indicador);
    }

    public static Set<Indicador> getIndicadoresRegistadosSet(){
        return indicadoresRegistadosSet;
    }

    public void setUnidadeMedida(UnidadesMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Set getUnidadesMedida(){
        return unidadeMedida.getUnidadesMedidaRegistadas();
    }

    public Set<Observacao> getHistoricoIndicador() {
        return historicoObservacoesIndicadorSet;
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
