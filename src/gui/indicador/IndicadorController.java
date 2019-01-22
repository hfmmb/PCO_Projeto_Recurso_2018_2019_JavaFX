package gui.indicador;

import gui.GuiController;
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

    public void buttonDialogIndicadorCancelActionListener(){
        /*
        * Button Listener
        *
        * */
        buttonDialogIndicadorCancel.setOnAction(actionEvent -> {
            System.out.print("Teste");

        });// Dummy, implemented in MainSystemGui

    }


    public void comboBoxDialogIndicadorCategoriaActionListener() {
        comboBoxDialogIndicadorCategoria.setOnAction(actionEvent -> {
            System.out.print("Teste1");

        });// Dummy, implemented in MainSystemGui
    }

    public void buttonDialogIndicadorCriarActionListener(){
    buttonDialogIndicadorCriar.setOnAction(actionEvent ->{

    });
    }

    public void radioButtonDialogIndicadorAutomaticoActionListener() {radioButtonDialogIndicadorAutomatico.setOnAction(actionEvent -> {

    });
    }

    public void radioButtonDialogIndicadorManualActionListener() {radioButtonDialogIndicadorManual.setOnAction(actionEvent -> {

    });
    }
}