package negocios.unidades;

/**
 * Classe responsavel por manter unidades do sistema metrico e fazer conversoes das mesmas
 */
public class UnidadesMedidaMetrico extends UnidadesMedida {
    private double valor;
    private String unidade;

    public UnidadesMedidaMetrico(Double valor){
        super("Metros");
        this.valor = valor;
        }

    public double metrosParaMm(){
        valor = metrosParaCm() * 10;
        unidade = "Milimetros";
        return valor;
    }
    public double metrosParaCm(){
        valor = metrosParaDec() * 10;
        unidade = "Centimetros";
        return valor;

    }
    public double metrosParaDec(){
        valor = valor * 10;
        unidade = "Decimetros";
        return valor;
    }

    public double metrosParaDm(){
        valor = valor / 10;
        unidade = "Decametros";
    return valor;
    }
    public double metrosParaHm(){
        valor = metrosParaDm() / 10;
        unidade = "Hectometros";
        return valor;

    }
    public double metrosParaKm(){
    valor = metrosParaHm() / 10;
    unidade = "Kilometros";
    return valor;
    }

    public static double metrosParaJardas(Double metros){
        return metros* 1.0936; //
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
