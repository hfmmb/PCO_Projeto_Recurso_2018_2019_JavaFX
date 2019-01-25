package negocios.unidades;

/**
 * Classe responsavel por manter unidades do sistema imperial e fazer conversoes das mesmas
 */
public class UnidadesMedidaImperial extends UnidadesMedida {
    private double valor;

    /**
     *
     * @param valor
     */
    public UnidadesMedidaImperial(Double valor){
        super("Jardas");
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public double jardasParaPolegadas(){
        valor = jardasParaPes() * 12; //1 pe == 12 polegadas
        unidade = "Polegadas";
        return valor;
    }

    /**
     *
     * @return
     */
    public double jardasParaPes(){
        valor = valor * 3; //1 jarda == 3 pes
        unidade = "Pes";
        return valor;
    }

    /**
     *
     * @return
     */
    public double jardasParaChain(){
        valor = valor / 22;// 22 jarda = 1 chain
        unidade = "Chain";
        return valor;
    }

    /**
     *
     * @return
     */
    public double jardasParaFurlong(){
        valor = jardasParaChain() / 10;
        unidade = "Furlong";
        return valor;
    }

    /**
     *
     * @return
     */
    public double jardasParaMilhas(){
        valor = jardasParaFurlong() / 8;
        unidade = "Milhas";
        return valor;
    }

    /**
     *
     * @param jardas
     * @return
     */
    public static double JardasParaMetros(Double jardas){
        return jardas/ 1.0936;
    }

    /**
     *
     * @return
     */
    public double getValor() {
        return valor;
    }
}
