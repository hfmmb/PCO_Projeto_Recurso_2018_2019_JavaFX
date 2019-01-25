package negocios;

import negocios.unidades.UnidadesMedida;
import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;
import negocios.unidades.UnidadesMedidaOutra;

import java.util.*;

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
    private Set<HistoricoIndicador> historicoIndicadorSet = new HashSet<>();
    private static Map<Integer,Indicador> indicadoresRegistadosMap = new HashMap<>();

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
        historicoIndicadorSet.add(new HistoricoIndicador(valorUnidade.toString()));
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
        historicoIndicadorSet.add(new HistoricoIndicador("0.0"));
    }

    /**
     *
     * @return
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     *
     * @return
     */
    public UnidadesMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     *
     * @param unidadeMedida
     */
    public void setUnidadeMedida(UnidadesMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /**
     *
     * @return
     */
    public Boolean getTipo() {
        return tipo;
    }

    /**
     *
     * @param designacao
     * @param tipo
     * @param valorUnidade
     * @param unidade
     */
    public static void addIndicadorMap(String designacao, Boolean tipo, Double valorUnidade, String unidade){
        Indicador indicador;
        if(!tipo){
            indicador = new Indicador(designacao,valorUnidade,unidade);
            indicadoresRegistadosMap.putIfAbsent(indicadoresRegistadosMap.size(),indicador);//Manual
        }else{
            indicador = new Indicador(designacao,unidade);
            indicadoresRegistadosMap.putIfAbsent(indicadoresRegistadosMap.size(),indicador); //Automatico
        }

    }

    /**
     *
     * @param indicador
     */
    public static void addIndicadorMap(Indicador indicador){
            indicadoresRegistadosMap.putIfAbsent(indicadoresRegistadosMap.size(),indicador);
        }

    /**
     *
     * @param indicador
     */
    public static void removeIndicadorSet(Indicador indicador){
        indicadoresRegistadosMap.remove(indicador);
    }

    /**
     *
     * @return
     */
    public static Map<Integer,Indicador> getIndicadoresRegistadosMap(){
        return indicadoresRegistadosMap;
    }

    /**
     *
     * @return
     */
    public Set getUnidadesMedida(){
        return unidadeMedida.getUnidadesMedidaRegistadas();
    }

    /**
     *
     * @return
     */
    public Set<Observacao> getHistoricoObservacoesIndicador() {
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

    /**
     *
     * @param opcao
     */
    public void convertUnidadeMedida(int opcao){
        switch (opcao){
            case 0:
                ((UnidadesMedidaMetrico) unidadeMedida).metrosParaMm();
                break;
            case 1:
                ((UnidadesMedidaMetrico) unidadeMedida).metrosParaCm();
                break;
            case 2:
                ((UnidadesMedidaMetrico) unidadeMedida).metrosParaDec();
                break;
            case 3:
                ((UnidadesMedidaMetrico) unidadeMedida).metrosParaDm();
                break;
            case 4:
                ((UnidadesMedidaMetrico) unidadeMedida).metrosParaHm();
                break;
            case 5:
                ((UnidadesMedidaMetrico) unidadeMedida).metrosParaKm();
                break;
            case 6:
                unidadeMedida = new UnidadesMedidaMetrico(UnidadesMedidaImperial.JardasParaMetros(((UnidadesMedidaImperial) unidadeMedida ).getValor()));
                break;
            case 7:
                ((UnidadesMedidaImperial) unidadeMedida).jardasParaPolegadas();
                break;
            case 8:
                ((UnidadesMedidaImperial) unidadeMedida).jardasParaPes();
                break;
            case 9:
                ((UnidadesMedidaImperial) unidadeMedida).jardasParaChain();
                break;
            case 10:
                ((UnidadesMedidaImperial) unidadeMedida).jardasParaFurlong();
                break;
            case 11:
                ((UnidadesMedidaImperial) unidadeMedida).jardasParaMilhas();
                break;
            case 12:
                unidadeMedida = new UnidadesMedidaImperial(UnidadesMedidaMetrico.metrosParaJardas(((UnidadesMedidaMetrico) unidadeMedida ).getValor()));
                break;
        }
    }

    public Set<HistoricoIndicador> getHistoricoIndicadorSet() {
        return historicoIndicadorSet;
    }

    /**
     *
     */
    public void updateHistoricoIndicadorSet(){
        if (this.getUnidadeMedida() instanceof UnidadesMedidaMetrico){
            Double valor = ((UnidadesMedidaMetrico) this.getUnidadeMedida()).getValor();
            historicoIndicadorSet.add(new HistoricoIndicador(valor.toString()));
        }
        else if (this.getUnidadeMedida() instanceof UnidadesMedidaImperial){
            Double valor = ((UnidadesMedidaImperial) this.getUnidadeMedida()).getValor();
            historicoIndicadorSet.add(new HistoricoIndicador(valor.toString()));
        }
        else {

        }
    }
}
