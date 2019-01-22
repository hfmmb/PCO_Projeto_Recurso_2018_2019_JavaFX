/**
 *TODO 0: Fazer o registo de utilizadores novos. #DONE
 *TODO 1: Fazer o login de utilizadores. #DONE
 *TODO 2: Criar Categorias
 *TODO 3: Criar Indicadores
 *TODO 4: Permitir ao Orientado criar Indicadores
 *TODO 5: Permitir ao Orientado ver indicadores em que foi marcado
 *TODO 6:
 *TODO 7:
 *TODO 8:
 *TODO 9:
 *TODO 10:
 * @autor: Hélder Filipe Mendonça de Medeiros Braga
 * @since: 19/01/2019
 */

package gui;

import gui.indicador.IndicadorController;
import gui.user.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.jfr.Experimental;
import jdk.jfr.Unsigned;
import negocios.SubsistemaNegocios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class MainSystemGui extends Application {
    private Stage window; //Janela JavaFX
    private Scene loginRegisterDialog, indicadorDialog; //Layout das diferentes janelas
    @Override
    public void start(Stage primaryStage) throws Exception{
        SubsistemaNegocios subsistema_negocios = SubsistemaNegocios.getInstance(); //Obtem a instancia do Singleton Sistema de Negocios
        subsistema_negocios.setupEnvironment(); //Cria alguns defaults para o programa;

        window = primaryStage;
        FXMLLoader fxmlLoaderUser = new FXMLLoader(getClass().getResource("user/User.fxml"));
        Parent root = fxmlLoaderUser.load();
        loginRegisterDialog = new Scene(root, 350,250);

        FXMLLoader fxmlLoaderIndicador = new FXMLLoader(getClass().getResource("indicador/Indicador.fxml"));
        Parent indicador = fxmlLoaderIndicador.load();
        indicadorDialog = new Scene(indicador, 450,300);

        window.setTitle("Login");
        window.setScene(loginRegisterDialog);
        window.show();
        UserController userGuiController = fxmlLoaderUser.getController();//Aponta para controller da janela User
        IndicadorController indicadorGuiController = fxmlLoaderIndicador.getController();//Aponta para controller da janela Indicador


        indicadorGuiController.comboBoxDialogIndicadorCategoria.getItems().addAll(subsistema_negocios.getCategorias()); //Popula a comboBox das Categorias
        indicadorGuiController.comboBoxDialogIndicadorCategoria.getSelectionModel().select(5); //Seleciona a categoria "Uncategorized\Sem categoria"



        userGuiController.buttonDialogUserRegister.setOnAction(actionEvent -> {
            /*
             * Action listener da janela de Login e Registo, para o botao de efectuar o Registo de supervisores e orientados
             * Verifica se os campos de username e password estao vazios ou não, e verifica se o utilizador a registar
             * é do tipo Orientado ou do tipo Supervisor
             * */
            if(userGuiController.radioButtonDialogUserOrientado.isSelected() &&
                    userGuiController.textFieldDialogUserUsername.getLength()>0 &&
                    userGuiController.passwordFieldDialogUserPassword.getLength()>0){

                subsistema_negocios.registarOrientado(
                        userGuiController.textFieldDialogUserUsername.getText(),
                        userGuiController.passwordFieldDialogUserPassword.getText());
                System.out.print("Orientado registado com sucesso!");
            }
            else if(userGuiController.radioButtonDialogUserSupervisor.isSelected() &&
                    userGuiController.textFieldDialogUserUsername.getLength()>0 &&
                    userGuiController.passwordFieldDialogUserPassword.getLength()>0 &&
                    userGuiController.textFieldDialogUserEspecialidade.getLength()>0){

                subsistema_negocios.registarSupervisor(
                        userGuiController.textFieldDialogUserUsername.getText(),
                        userGuiController.passwordFieldDialogUserPassword.getText(),userGuiController.textFieldDialogUserEspecialidade.getText());
                System.out.print("Supervisor registado com sucesso!");
            }
            else{System.out.println("Credenciais invalidas!");}

        });

        userGuiController.buttonDialogUserLogin.setOnAction(actionEvent -> {
            /*
             * Action listener da janela de Login e Registo, para o botao de efectuar o Login de supervisores e orientados
             * Faz o login de orientados e supervisores
             * */
                Integer checker;
                String username = userGuiController.textFieldDialogUserUsername.getText();
                String password = userGuiController.passwordFieldDialogUserPassword.getText();

                if(username.length()>0 && password.length()>0){
                checker = subsistema_negocios.checkLoginCredentials(username, password);

                    switch (checker){
                        case 2:
                            System.out.print("Bem vindo Supervisor "+username+"!");
                            userGuiController.labelDialogUserLoginSuccess.setText("Bem vindo Supervisor "+ username+"!");
                            window.setScene(indicadorDialog);
                            window.setTitle("Indicador");
                            //indicadorGuiController.comboBoxDialogIndicadorCategoria.getItems().addAll();
                            break;
                        case 1:
                            System.out.print("Bem vindo Orientado "+username+"!");
                            userGuiController.labelDialogUserLoginSuccess.setText("Bem vindo Orientado "+ username+"!");
                            window.setScene(indicadorDialog);
                            window.setTitle("Indicador");
                            //indicadorGuiController.comboBoxDialogIndicadorCategoria.getItems().addAll(set);
                            break;
                        case -1:
                            System.out.println("Password incorreta!");
                            userGuiController.labelDialogUserLoginSuccess.setText("Password incorreta!");
                            break;
                        case -2:
                            System.out.println("Utilizador inexistente!");
                            userGuiController.labelDialogUserLoginSuccess.setText("Utilizador inexistente!");
                            break;
                    }
                }
                else {
                    System.out.println("Username ou password vazios!");
                    userGuiController.labelDialogUserLoginSuccess.setText("Username ou password vazios!");
                }
        });

        indicadorGuiController.buttonDialogIndicadorCancel.setOnAction(actionEvent -> {
            window.setScene(loginRegisterDialog);
            window.setTitle("Login");
        });

        indicadorGuiController.buttonDialogIndicadorCriar.setOnAction(actionEvent -> {
        });

        indicadorGuiController.radioButtonDialogIndicadorAutomatico.setOnAction(actionEvent -> {
            indicadorGuiController.radioButtonDialogIndicadorAutomatico.setSelected(true);
            indicadorGuiController.radioButtonDialogIndicadorManual.setSelected(false);
        });

        indicadorGuiController.radioButtonDialogIndicadorManual.setOnAction(actionEvent -> {
            indicadorGuiController.radioButtonDialogIndicadorAutomatico.setSelected(false);
            indicadorGuiController.radioButtonDialogIndicadorManual.setSelected(true);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
