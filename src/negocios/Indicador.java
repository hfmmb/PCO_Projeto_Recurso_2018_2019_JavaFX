package negocios;

import negocios.unidades.UnidadesMedida;
import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;
import negocios.unidades.UnidadesMedidaOutra;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  Classe Indicador, contem indicadores de desempenho de alguma coisa, por exemplo, um indicador pode ser de pulsação,
 *  distancia percorrida num dia, etc... Estes podem operar em modo automatico ou manual, automatico sao geridos pelo
 *  sistema, manuais sao geridos por utilizadores.
 */
public class Indicador {
    private String designacao;
    private Boolean tipo; //true para Automatico, false para Manual
    private UnidadesMedida unidadeMedida;
    private Set<Observacao> historicoObservacoesIndicadorSet = new HashSet<>();
    private static Set<Indicador> indicadoresRegistadosSet = new HashSet<>();

    /**
     * Construtor de um indicador do tipo manual
     * @param designacao Descricao ou nome dado ao indicador
     * @param valorUnidade Valor do indicador quando e criado
     * @param unidade unidade de medida, "Metros", "Imperial" ou "Outra"
     */
    public Indicador(String designacao, Double valorUnidade, String unidade){
        this.designacao = designacao;
        this.tipo = false;
        this.unidadeMedida = criarUnidadeMedida(valorUnidade, unidade);
        historicoObservacoesIndicadorSet.add(new Observacao(valorUnidade.toString(),unidade));
    }

    /**
     * Construtor de um indicador do tipo automatico
     * @param designacao Descricao do indicador ou nome deste
     * @param unidade unidade de medida
     */
    public Indicador(String designacao, String unidade){
        this.designacao = "Automatico Indicador " + designacao;
        this.tipo = true;
        this.unidadeMedida = criarUnidadeMedida(0.0, unidade);
        historicoObservacoesIndicadorSet.add(new Observacao("0.0", unidade));
    }

    public String getDesignacao() {
        return designacao;
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

    public Set getUnidadesMedida(){
        return unidadeMedida.getUnidadesMedidaRegistadas();
    }

    public Set<Observacao> getHistoricoIndicador() {
        return historicoObservacoesIndicadorSet;
    }

    /**
     * Faz a decisao do tipo de unidade de medida a usar, pode usar uma das implementadas que permitem conversoes,
     * ou uma descritiva apenas que nao permite conversoes.
     * @param valor Valor da unidade
     * @param unidade Tipo de unidade a que o valor pertence (Metros, Milhas, Lumens)
     * @return Retorna a unidade de medida
     */
    private UnidadesMedida criarUnidadeMedida(Double valor ,String unidade){
        if(unidade.equals("Metros")){
            return new UnidadesMedidaMetrico(valor);
        } else if (unidade.equals("Jardas")){
            return new UnidadesMedidaImperial(valor);
        }else {
            return new UnidadesMedidaOutra(valor.toString(), unidade);
        }
    }

    /**
     * Insere uma observacao na lista de observacoes do indicador, pode ser uma sugestao, particularidade, correcao
     * ou descricao de algum elemento do indicador, tem sempre associado a hora e o supervisor que o cria.
     * @param observacao Comentario sobre algum elemento do indicador em geral ou algo especifico
     * @param usernameSupervisor Nome do Supervisor que fez dito comentario
     */
    public void inserirObservacao(String observacao, String usernameSupervisor){
        historicoObservacoesIndicadorSet.add(new Observacao(observacao, usernameSupervisor));
    }

    /**
     * Retorna um set com todas as observacoes feitas ao indicador
     * @return Retorna um Set de Observacoes
     */
    public Set<Observacao> getHistoricoObservacoesIndicadorSet(){return historicoObservacoesIndicadorSet;}

    /**
     * Converte o historico de observacoes de um indicador para um Set de strings
     * @return Retorna um Set de Strings
     */
    public Set<String> getHistoricoObservacoesIndicadorSetString(){
        Iterator<Observacao> iterator = historicoObservacoesIndicadorSet.iterator();
        Set<String> historicoObservacoesIndicadorSetString = new HashSet<>();
        while (iterator.hasNext()){
            historicoObservacoesIndicadorSetString.add("TIMESTAMP: "+iterator.next().getTimestamp().toString() +
                    " OBSERVAÇÃO: "+ iterator.next().getObservacao() +
                    " SUPERVISOR: "+ iterator.next().getUsernameSupervisor().toString());
        }
        return historicoObservacoesIndicadorSetString;
    }
}
