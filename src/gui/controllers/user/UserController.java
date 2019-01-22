package gui.controllers.user;

import gui.controllers.GuiController;
import javafx.scene.control.*;

/**
 * Classe responsavel para servir de intermediaria entre a Classe "MainSystemGui e o codigo fxml estrutural da gui"
 * Sendo assim, tudo o que precise de estar na classe principal, é utilizado aqui para ficar menos "Verboso"
 */
public class UserController extends GuiController {

    public Button buttonDialogUserRegister;
    public TextField textFieldDialogUserUsername;
    public PasswordField passwordFieldDialogUserPassword;
    public Label labelDialogUserLoginSuccess;
    public RadioButton radioButtonDialogUserOrientado;
    public RadioButton radioButtonDialogUserSupervisor;
    public Button buttonDialogUserLogin;
    public TextField textFieldDialogUserEspecialidade;
    private ToggleGroup radioButtonGroup = new ToggleGroup();

    public void setup(){
        radioButtonDialogUserSupervisor.setToggleGroup(radioButtonGroup);
        radioButtonDialogUserSupervisor.setDisable(true);
        radioButtonDialogUserOrientado.setToggleGroup(radioButtonGroup);
        radioButtonDialogUserOrientado.setSelected(true);
        textFieldDialogUserEspecialidade.setDisable(true);
    }

    //Action Listeners
    public void buttonDialogUserRegisterActionListener(){
        buttonDialogUserRegister.setOnAction(actionEvent -> {}); //Dummy, implementado na classe principal da gui "MainSystemGui"
    }

    public void buttonDialogUserLoginActionListener(){
        buttonDialogUserLogin.setOnAction(actionEvent -> {}); //Dummy, implementado na classe principal da gui "MainSystemGui"
    }


    public void radioButtonDialogUserSupervisorActionListener() {
        radioButtonDialogUserSupervisor.setOnAction(actionEvent -> {
            textFieldDialogUserEspecialidade.setDisable(false); //Bloqueia o botao
    });
    }

    public void radioButtonDialogUserOrientadoActionListener() {
        radioButtonDialogUserOrientado.setOnAction(actionEvent -> {
        textFieldDialogUserEspecialidade.setDisable(true); //Desbloqueia o botao
        });
    }
}
