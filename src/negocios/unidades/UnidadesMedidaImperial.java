package negocios.unidades;

/**
 * Classe responsavel por manter unidades do sistema imperial e fazer conversoes das mesmas
 */
public class UnidadesMedidaImperial extends UnidadesMedida {
    private double valor;
    private String unidade;
    public UnidadesMedidaImperial(Double valor){
        super("Jardas");
        this.valor = valor;
    }

    public double jardasParaPolegadas(){
        valor = jardasParaPes() * 12; //1 pe == 12 polegadas
        unidade = "Polegadas";
        return valor;

    }
    public double jardasParaPes(){
        valor = valor * 3; //1 jarda == 3 pes
        unidade = "Pes";
        return valor;
    }

    public double jardasParaChain(){
        valor = valor / 22;// 22 jarda = 1 chain
        unidade = "Chain";
        return valor;
    }

    public double jardasParaFurlong(){
        valor = jardasParaChain() / 10;
        unidade = "Furlong";
        return valor;

    }
    public double jardasParaMilhas(){
        valor = jardasParaFurlong() / 8;
        unidade = "Milhas";
        return valor;
    }

    public static double JardasParaMetros(Double jardas){
        return jardas/ 1.0936;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
