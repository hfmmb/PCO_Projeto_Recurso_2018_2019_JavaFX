package gui.controllers.categoria;

import gui.controllers.GuiController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CategoriaController extends GuiController {


    public Button buttonDialogCategoriaVoltar;
    public RadioButton radioButtonDialogCategoriaSupervisorOrientado;
    public RadioButton radioButtonDialogCategoriaOrientado;
    public RadioButton radioButtonDialogCategoriaSupervisor;
    public TextField textFieldDialogCategoriaNome;
    public Button buttonDialogCategoriaCriar;
    public ComboBox comboBoxDialogCategoriaOrientado;
    private ToggleGroup toggleGroup = new ToggleGroup();

    public void setup(){
        radioButtonDialogCategoriaSupervisorOrientado.setToggleGroup(toggleGroup);
        radioButtonDialogCategoriaSupervisor.setToggleGroup(toggleGroup);
        radioButtonDialogCategoriaOrientado.setToggleGroup(toggleGroup);
    }

    //Dummy Listeners, implemented in MainSystemGui
    public void buttonDialogCategoriaVoltarActionListener(){
        buttonDialogCategoriaVoltar.setOnAction(actionEvent -> {});
    }
    public void radioButtonDialogCategoriaSupervisorOrientadoActionListener(){
        radioButtonDialogCategoriaSupervisorOrientado.setOnAction(actionEvent -> {

        });
    }
    public void radioButtonDialogCategoriaOrientadoActionListener(){
        radioButtonDialogCategoriaOrientado.setOnAction(actionEvent -> {

        });
    }
    public void radioButtonDialogCategoriaSupervisorActionListener(){
        radioButtonDialogCategoriaSupervisor.setOnAction(actionEvent -> {

        });
    }

    public void buttonDialogCategoriaCriarActionListener() {buttonDialogCategoriaCriar.setOnAction(actionEvent -> {

    });

    }
}