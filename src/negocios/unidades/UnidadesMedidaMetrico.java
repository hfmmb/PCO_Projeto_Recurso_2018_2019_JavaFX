package negocios.unidades;

/**
 * Classe responsavel por manter unidades do sistema metrico e fazer conversoes das mesmas
 */
public class UnidadesMedidaMetrico extends UnidadesMedida {
    private double valor;

    /**
     *
     * @param valor
     */
    public UnidadesMedidaMetrico(Double valor){
        super("Metros");
        this.valor = valor;
        }

    /**
     *
     * @return
     */
    public double metrosParaMm(){
        valor = metrosParaCm() * 10;
        unidade = "Milimetros";
        return valor;
    }

    /**
     *
     * @return
     */
    public double metrosParaCm(){
        valor = metrosParaDec() * 10;
        unidade = "Centimetros";
        return valor;

    }

    /**
     *
     * @return
     */
    public double metrosParaDec(){
        valor = valor * 10;
        unidade = "Decimetros";
        return valor;
    }

    /**
     *
     * @return
     */
    public double metrosParaDm(){
        valor = valor / 10;
        unidade = "Decametros";
    return valor;
    }

    /**
     *
     * @return
     */
    public double metrosParaHm(){
        valor = metrosParaDm() / 10;
        unidade = "Hectometros";
        return valor;
    }

    /**
     *
     * @return
     */
    public double metrosParaKm(){
    valor = metrosParaHm() / 10;
    unidade = "Kilometros";
    return valor;
    }

    /**
     *
     * @param metros
     * @return
     */
    public static double metrosParaJardas(Double metros){
        return metros* 1.0936; //
    }

    /**
     *
     * @return
     */
    public double getValor() {
        return valor;
    }
}
