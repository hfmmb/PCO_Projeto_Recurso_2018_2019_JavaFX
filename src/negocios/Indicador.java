package negocios;

import negocios.unidades.UnidadesMedida;

public class Indicador {
    private String tipo;
    private UnidadesMedida unidadesMedida;
    public Indicador(String tipo, UnidadesMedida unidadesMedida){
        this.tipo = tipo;
        this.unidadesMedida = unidadesMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }
    private void gerarValor(){

    }
}
