package gui.controllers.historicoIndicador;

import gui.controllers.GuiController;
import javafx.scene.control.*;

public class HistoricoIndicadorController extends GuiController {


    public ComboBox comboBoxDialogHistoricoIndicadorRegisto;
    public ComboBox comboBoxDialogHistoricoIndicadorIndicador;
    public Label labelDialogHistoricoIndicadorTimestamp;
    public Label labelDialogHistoricoIndicadorValor;
    public Button buttonDialogHistoricoIndicadorVoltar;

    public void setup(){

    }

    //Dummy Listeners, implemented in MainSystemGui
    public void comboBoxDialogHistoricoIndicadorRegistoActionListener(){
        comboBoxDialogHistoricoIndicadorRegisto.setOnAction(actionEvent -> {});
    }
    public void comboBoxDialogHistoricoIndicadorIndicadorActionListener(){
        comboBoxDialogHistoricoIndicadorIndicador.setOnAction(actionEvent -> {

        });
    }

    public void buttonDialogHistoricoIndicadorVoltarActionListener() {
        buttonDialogHistoricoIndicadorVoltar.setOnAction(actionEvent -> {

    });

    }
}