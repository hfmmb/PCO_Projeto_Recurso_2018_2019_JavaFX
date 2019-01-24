package gui.controllers.indicador;

import gui.controllers.GuiController;
import javafx.scene.control.*;

public class IndicadorController extends GuiController {

    public Button buttonDialogIndicadorCancel;
    public ComboBox comboBoxDialogIndicadorCategoria;
    public Button buttonDialogIndicadorCriar;
    public RadioButton radioButtonDialogIndicadorManual;
    public RadioButton radioButtonDialogIndicadorAutomatico;
    public ComboBox comboBoxDialogIndicadorExtensoes;
    public ComboBox comboBoxDialogIndicadorUnidades;
    public TextField textFieldDialogIndicadorNome;
    public Label labelDialogIndicadorLogin;
    private ToggleGroup radioButtonGroup = new ToggleGroup();

    public void setup(){
        radioButtonDialogIndicadorAutomatico.setToggleGroup(radioButtonGroup);
        radioButtonDialogIndicadorManual.setToggleGroup(radioButtonGroup);
        radioButtonDialogIndicadorManual.setSelected(true);
        comboBoxDialogIndicadorExtensoes.setDisable(true);
    }

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
        radioButtonDialogIndicadorAutomatico.setOnAction(actionEvent -> {
            comboBoxDialogIndicadorExtensoes.setDisable(true);
        });
    }

    public void radioButtonDialogIndicadorManualActionListener() {
        radioButtonDialogIndicadorManual.setOnAction(actionEvent -> {
            comboBoxDialogIndicadorExtensoes.setDisable(false);
        });
    }
}