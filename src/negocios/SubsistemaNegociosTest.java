package negocios;

import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsavel por fazer testes unitarios de algumas funcoes do programa
 */
public class SubsistemaNegociosTest {
    private SubsistemaNegocios subsistemaNegocios;
    private UnidadesMedidaImperial unidadesMedidaImperial;
    private UnidadesMedidaMetrico unidadesMedidaMetrico;
    private Plano plano;
    @org.junit.jupiter.api.BeforeEach
    void setup(){
        subsistemaNegocios = new SubsistemaNegocios();
        subsistemaNegocios.registarSupervisor("Kamehameha","","King");
        subsistemaNegocios.registarOrientado("Oda","Nobunaga");


        unidadesMedidaImperial = new UnidadesMedidaImperial(25.0);
        unidadesMedidaImperial.jardasParaChain();
        unidadesMedidaMetrico = new UnidadesMedidaMetrico(100.0);
        unidadesMedidaMetrico.metrosParaCm();

        plano = new Plano("0","10",new Indicador("Teste",0.0,"Metros"),"Kamehameha");

    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getSupervisorStatusSupervisor(){
        assertTrue(subsistemaNegocios.getSupervisorStatus("Kamehameha"));
    }
    @org.junit.jupiter.api.Test
    void getSupervisorStatusOrientado(){
        assertFalse(subsistemaNegocios.getSupervisorStatus("Oda"));
    }

    @org.junit.jupiter.api.Test
    void getUnidade(){
        assertEquals("Chain",unidadesMedidaImperial.getUnidade());
    }
    @org.junit.jupiter.api.Test
    void valueInstanceUnidadeMedidaMetrico(){
        assertEquals(true,  plano.getIndicador().getUnidadeMedida() instanceof UnidadesMedidaMetrico);
    }
}
