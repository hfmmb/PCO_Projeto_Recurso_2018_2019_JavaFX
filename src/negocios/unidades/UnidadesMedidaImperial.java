package negocios.unidades;

/**
 * Classe responsavel por manter unidades do sistema metrico e fazer conversoes das mesmas
 */
public class UnidadesMedidaImperial extends UnidadesMedida {
    private double valor;
    private String unidade;
    public UnidadesMedidaImperial(Double valor){
        super("metros");
        this.valor = valor;
    }

    public double metrosParaMm(){
        valor = metrosParaCm() * 10;
        unidade = "milimetros";
        return valor;
    }
    public double metrosParaCm(){
        valor = metrosParaDec() * 10;
        unidade = "centimetros";
        return valor;

    }
    public double metrosParaDec(){
        valor = valor * 10;
        unidade = "decimetros";
        return valor;
    }

    public double metrosParaDm(){
        valor = valor / 10;
        unidade = "decametros";
        return valor;
    }
    public double metrosParaHm(){
        valor = metrosParaDm() / 10;
        unidade = "hectometros";
        return valor;

    }
    public double metrosParaKm(){
        valor = metrosParaHm() / 10;
        unidade = "kilometros";
        return valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
