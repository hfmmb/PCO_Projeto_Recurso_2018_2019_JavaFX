package gui.controllers.indicador;

import gui.controllers.GuiController;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class IndicadorController extends GuiController {

    public Button buttonDialogIndicadorCancel;
    public ComboBox comboBoxDialogIndicadorCategoria;
    public Button buttonDialogIndicadorCriar;
    public RadioButton radioButtonDialogIndicadorManual;
    public RadioButton radioButtonDialogIndicadorAutomatico;
    public ComboBox comboBoxDialogIndicadorExtensoes;
    public ComboBox comboBoxDialogIndicadorUnidades;
    public TextField textFieldDialogIndicadorNome;

    //Dummy Listeners, implemented in MainSystemGui
    public void buttonDialogIndicadorCancelActionListener(){
        buttonDialogIndicadorCancel.setOnAction(actionEvent -> {});
    }

    public void comboBoxDialogIndicadorCategoriaActionListener() {
        comboBoxDialogIndicadorCategoria.setOnAction(actionEvent -> {});// Dummy, implemented in MainSystemGui
    }

    public void buttonDialogIndicadorCriarActionListener(){
        buttonDialogIndicadorCriar.setOnAction(actionEvent ->{});
    }

    public void radioButtonDialogIndicadorAutomaticoActionListener() {
        radioButtonDialogIndicadorAutomatico.setOnAction(actionEvent -> {});
    }

    public void radioButtonDialogIndicadorManualActionListener() {
        radioButtonDialogIndicadorManual.setOnAction(actionEvent -> {});
    }
}