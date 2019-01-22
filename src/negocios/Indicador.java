package negocios;

import negocios.unidades.UnidadesMedida;

import java.util.List;

public class Indicador {
    private String tipo;
    private UnidadesMedida unidadeMedida;
    public Indicador(String tipo, UnidadesMedida unidadeMedida){
        this.tipo = tipo;
        this.unidadeMedida = unidadeMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UnidadesMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadesMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public List getListUnidadesMedida(){
        return unidadeMedida.getUnidadesMedidaRegistadas();
    }
}
