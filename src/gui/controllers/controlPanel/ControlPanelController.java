package gui.controllers.controlPanel;

import gui.controllers.GuiController;
import javafx.scene.control.*;

public class ControlPanelController extends GuiController {


    public Button buttonDialogControlPanelVoltar;
    public Button buttonDialogControlPanelCriarPlanosOrientado;

    public Button buttonDialogControlPanelCriarIndicadores;
    public Button buttonDialogControlPanelCriarCategoria;
    public Button buttonDialogControlPanelTerminal;
    public Button buttonDialogControlPanelConsultarHistoricoIndicador;

    public void setup(){
    }

    //Dummy Listeners, implemented in MainSystemGui
    public void buttonDialogControlPanelVoltarActionListener(){
        buttonDialogControlPanelVoltar.setOnAction(actionEvent -> {});
    }
    public void buttonDialogControlPanelCriarPlanosOrientadoActionListener(){
        buttonDialogControlPanelCriarPlanosOrientado.setOnAction(actionEvent -> {});
    }
    public void buttonDialogControlPanelCriarIndicadoresActionListener(){
        buttonDialogControlPanelCriarIndicadores.setOnAction(actionEvent -> {});
    }

    public void buttonDialogControlPanelConsultarHistoricoIndicadorActionListener(){
    buttonDialogControlPanelConsultarHistoricoIndicador.setOnAction(actionEvent -> {

    });
}
    public void buttonDialogControlPanelCriarCategoriaActionListener(){
        buttonDialogControlPanelCriarCategoria.setOnAction(actionEvent -> {

        });
    }


    public void buttonDialogControlPanelTerminalActionListener(){
        buttonDialogControlPanelTerminal.setOnAction(actionEvent -> {
        });
    }
}