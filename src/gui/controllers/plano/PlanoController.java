package gui.controllers.plano;

import gui.controllers.GuiController;
import javafx.scene.control.*;

public class PlanoController extends GuiController {


    public TextField textFieldDialogPlanoValorMinimo;
    public TextField textFieldDialogPlanoValorMaximo;
    public ComboBox comboBoxDialogPlanoIndicador;
    public Button buttonDialogPlanoCriar;
    public Button buttonDialogPlanoCancel;

    public void setup(){

    }

    //Dummy Listeners, implemented in MainSystemGui
    public void buttonDialogPlanoCriarActionListener(){
        buttonDialogPlanoCriar.setOnAction(actionEvent -> {});
    }

    public void buttonDialogPlanoCancelActionListener() {
        buttonDialogPlanoCancel.setOnAction(actionEvent -> {});// Dummy, implemented in MainSystemGui
    }

    public void textFieldDialogPlanoValorMinimoActionListener(){
        textFieldDialogPlanoValorMinimo.setOnAction(actionEvent ->{

        });
    }

    public void textFieldDialogPlanoValorMaximoActionListener() {
        textFieldDialogPlanoValorMaximo.setOnAction(actionEvent -> {

        });
    }

    public void comboBoxDialogPlanoIndicadorActionListener() {
        comboBoxDialogPlanoIndicador.setOnAction(actionEvent -> {
        });
    }
}