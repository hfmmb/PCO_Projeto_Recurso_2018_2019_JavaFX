/*
 *UC1: Criar categoria de indicador                                            #DONE
 *UC2: Criar indicador                                                         #DONE
 *UC3: Registar novo utilizador                                                #DONE
 *UC4: Efectuar recolha de observacoes de um indicador                         #DONE
 *TODO UC5: Establecer planos de objetivos de um indicador
 *UC6: Consultar historico de observacoes de um indicador                      #DONE
 *UC7: Comparar desempenho de um indicador em relacao ao plano establecido     #DNI
 *UC8: Criar versao alternativa a um plano de um indicador                     #DNI
 *UC9: Associar Supervisor a um orientado                                      #DONE
 *UC10: Fornecer informacao tecnica sobre o cumprimento de um plano            #DNI
 *UC11: Autenticar utilizador                                                  #DONE
 * @autor: Hélder Filipe Mendonça de Medeiros Braga
 * @since: 19/01/2019
 */

package gui;

import gui.controllers.categoria.CategoriaController;
import gui.controllers.controlPanel.ControlPanelController;
import gui.controllers.historicoObservacoesIndicador.HistoricoObservacaoController;
import gui.controllers.indicador.IndicadorController;
import gui.controllers.plano.PlanoController;
import gui.controllers.user.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocios.Indicador;
import negocios.Orientado;
import negocios.SubsistemaNegocios;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;

/**
 *
 */
public class MainSystemGui extends Application {
    private Stage window; //Janela JavaFX
    private Scene loginRegisterDialog, indicadorDialog, controlPanelDialog,categoriaDialog, planoDialog, historicoObservacoesIndicadorDialog; //Layout das diferentes janelas
    @Override
    public void start(Stage primaryStage) throws Exception {
        SubsistemaNegocios subsistema_negocios = SubsistemaNegocios.getInstance(); //Obtem a instancia do Singleton Sistema de Negocios
        subsistema_negocios.setupEnvironment(); //Cria alguns defaults para o programa;

        window = primaryStage;

        FXMLLoader fxmlLoaderUser = new FXMLLoader(getClass().getResource("controllers/user/User.fxml"));
        Parent root = fxmlLoaderUser.load();
        loginRegisterDialog = new Scene(root, 320, 250);

        FXMLLoader fxmlLoaderIndicador = new FXMLLoader(getClass().getResource("controllers/indicador/Indicador.fxml"));
        Parent indicador = fxmlLoaderIndicador.load();
        indicadorDialog = new Scene(indicador, 500, 300);

        FXMLLoader fxmlLoaderControlPanel = new FXMLLoader(getClass().getResource("controllers/controlPanel/ControlPanel.fxml"));
        Parent controlPanel = fxmlLoaderControlPanel.load();
        controlPanelDialog = new Scene(controlPanel, 250, 250);

        FXMLLoader fxmlLoaderCategoria = new FXMLLoader(getClass().getResource("controllers/categoria/Categoria.fxml"));
        Parent categoria = fxmlLoaderCategoria.load();
        categoriaDialog = new Scene(categoria, 260, 220);

        FXMLLoader fxmlLoaderPlano = new FXMLLoader(getClass().getResource("controllers/plano/Plano.fxml"));
        Parent plano = fxmlLoaderPlano.load();
        planoDialog = new Scene(plano, 300, 200);

        FXMLLoader fxmlLoaderHistoricoIndicador = new FXMLLoader(getClass().getResource("controllers/historicoObservacoesIndicador/HistoricoObservacoesIndicador.fxml"));
        Parent historicoObservacoesIndicador = fxmlLoaderHistoricoIndicador.load();
        historicoObservacoesIndicadorDialog = new Scene(historicoObservacoesIndicador, 400, 200);

        window.setTitle("Login");
        window.setScene(loginRegisterDialog);

        window.show();

        UserController userGuiController = fxmlLoaderUser.getController();//Aponta para controller da janela User
        IndicadorController indicadorGuiController = fxmlLoaderIndicador.getController();//Aponta para controller da janela Indicador
        ControlPanelController controlPanelGuiController = fxmlLoaderControlPanel.getController();
        CategoriaController categoriaGuiController = fxmlLoaderCategoria.getController();
        PlanoController planoGuiController = fxmlLoaderPlano.getController();
        HistoricoObservacaoController historicoIndicadorGuiController = fxmlLoaderHistoricoIndicador.getController();

        indicadorGuiController.comboBoxDialogIndicadorUnidades.getItems().addAll(
                subsistema_negocios.getUnidadesMedidaRegistadas());

        userGuiController.setup();
        indicadorGuiController.setup();
        controlPanelGuiController.setup();
        categoriaGuiController.setup();
        planoGuiController.setup();
        historicoIndicadorGuiController.setup();

        userGuiController.buttonDialogUserRegister.setOnAction(actionEvent -> {
            /*
             * Action listener da janela de Login e Registo, para o botao de efectuar o Registo de supervisores e orientados
             * Verifica se os campos de username e password estao vazios ou não, e verifica se o utilizador a registar
             * é do tipo Orientado ou do tipo Supervisor
             * */
            if (userGuiController.radioButtonDialogUserOrientado.isSelected() &&
                    userGuiController.textFieldDialogUserUsername.getLength() > 0 &&
                    userGuiController.passwordFieldDialogUserPassword.getLength() > 0) {

                subsistema_negocios.registarOrientado(
                        userGuiController.textFieldDialogUserUsername.getText(),
                        userGuiController.passwordFieldDialogUserPassword.getText());
                System.out.print("Orientado registado com sucesso!");
            } else if (userGuiController.radioButtonDialogUserSupervisor.isSelected() &&
                    userGuiController.textFieldDialogUserUsername.getLength() > 0 &&
                    userGuiController.passwordFieldDialogUserPassword.getLength() > 0 &&
                    userGuiController.textFieldDialogUserEspecialidade.getLength() > 0 &&
                    userGuiController.labelDialogUserLoginSuccess.getText().contains("Supervisor")) {

                subsistema_negocios.registarSupervisor(
                        userGuiController.textFieldDialogUserUsername.getText(),
                        userGuiController.passwordFieldDialogUserPassword.getText(), userGuiController.textFieldDialogUserEspecialidade.getText());
                System.out.print("Supervisor registado com sucesso!");
            } else {
                System.out.println("Credenciais invalidas!");
            }

        });

        userGuiController.buttonDialogUserLogin.setOnAction(actionEvent -> {
            /*
             * Action listener da janela de Login e Registo, para o botao de efectuar o Login de supervisores e orientados
             * Faz o login de orientados e supervisores
             * */
            Integer checker;
            String username = userGuiController.textFieldDialogUserUsername.getText();
            String password = userGuiController.passwordFieldDialogUserPassword.getText();

            if (username.length() > 0 && password.length() > 0) {
                checker = subsistema_negocios.checkLoginCredentials(username, password);

                switch (checker) {
                    case 2:

                        System.out.println("Bem vindo Supervisor " + username + "!");
                        userGuiController.labelDialogUserLoginSuccess.setText("Bem vindo Supervisor " + username + "!");
                        userGuiController.radioButtonDialogUserSupervisor.setDisable(false);
                        window.setScene(controlPanelDialog);
                        window.setTitle("Control Panel");
                        controlPanelGuiController.buttonDialogControlPanelCriarPlanosOrientado.setDisable(false);
                        break;

                    case 1:

                        System.out.println("Bem vindo Orientado " + username + "!");
                        userGuiController.labelDialogUserLoginSuccess.setText("Bem vindo Orientado " + username + "!");
                        userGuiController.radioButtonDialogUserSupervisor.setDisable(true);
                        window.setScene(controlPanelDialog);
                        window.setTitle("Control Panel");
                        controlPanelGuiController.buttonDialogControlPanelCriarPlanosOrientado.setDisable(true);
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
            } else {
                System.out.println("Username ou password vazios!");
                userGuiController.labelDialogUserLoginSuccess.setText("Username ou password vazios!");
            }
        });

        indicadorGuiController.buttonDialogIndicadorCancel.setOnAction(actionEvent -> {
            window.setScene(controlPanelDialog);
            window.setTitle("Login");
            indicadorGuiController.comboBoxDialogIndicadorCategoria.getItems().clear();
        });

        indicadorGuiController.buttonDialogIndicadorCriar.setOnAction(actionEvent -> {
            if (indicadorGuiController.textFieldDialogIndicadorNome.getText().length() > 0 &&
                    indicadorGuiController.comboBoxDialogIndicadorUnidades.getSelectionModel().getSelectedItem() != null &&
                    indicadorGuiController.comboBoxDialogIndicadorCategoria.getSelectionModel().getSelectedItem() != null) {
                String designacao = indicadorGuiController.textFieldDialogIndicadorNome.getText();
                String unidade = indicadorGuiController.comboBoxDialogIndicadorUnidades.getSelectionModel().getSelectedItem().toString();

                if (indicadorGuiController.radioButtonDialogIndicadorAutomatico.isSelected()) {
                    subsistema_negocios.addIndicador(designacao, true, null, unidade);
                    System.out.println("Indicador automatico criado com sucesso!");

                } else {
                    subsistema_negocios.addIndicador(designacao, false, 0.0, unidade);
                    System.out.println("Indicador manual criado com sucesso!");
                }

            } else {
                System.out.println("Existem campos nao preenchidos!");
            }
        });

        controlPanelGuiController.buttonDialogControlPanelVoltar.setOnAction(actionEvent -> {
            window.setScene(loginRegisterDialog);
            userGuiController.textFieldDialogUserUsername.clear();
            userGuiController.passwordFieldDialogUserPassword.clear();
            userGuiController.textFieldDialogUserEspecialidade.clear();
            userGuiController.labelDialogUserLoginSuccess.setText("Introduza as suas credenciais abaixo.");
        });

        categoriaGuiController.buttonDialogCategoriaVoltar.setOnAction(actionEvent -> {
            window.setScene(controlPanelDialog);
            categoriaGuiController.comboBoxDialogCategoriaOrientado.getItems().clear();
        });

        categoriaGuiController.buttonDialogCategoriaCriar.setOnAction(actionEvent -> {
            String username = userGuiController.textFieldDialogUserUsername.getText();
            String nomeCategoria = categoriaGuiController.textFieldDialogCategoriaNome.getText();
            if (categoriaGuiController.textFieldDialogCategoriaNome.getText().length() > 0) {

                if (categoriaGuiController.radioButtonDialogCategoriaOrientado.isSelected()) {//Orientado insere categoria em si mesmo
                    subsistema_negocios.inserirCategoriaComoOrientado(username, nomeCategoria);
                    System.out.println("Nova categoria criada com sucesso para o orientado " + username + "!");

                } else if (categoriaGuiController.radioButtonDialogCategoriaSupervisor.isSelected()) {//Supervisor insere categoria no sistema
                    subsistema_negocios.inserirCategoriaComoSupervisor(username, nomeCategoria);
                    System.out.println("Nova categoria criada com sucesso no sistema pelo supervisor " + username + "!");

                } else {//Supervisor insere categoria em categorias do orientado
                    String usernameOrientado = categoriaGuiController.comboBoxDialogCategoriaOrientado.getValue().toString();
                    subsistema_negocios.inserirCategoriaEmOrientadoComoSupervisor(username, usernameOrientado, nomeCategoria);
                    System.out.println("Nova categoria criada com sucesso no orientado " + usernameOrientado + " pelo supervisor " + username + "!");
                }
            }
        });

        controlPanelGuiController.buttonDialogControlPanelCriarIndicadores.setOnAction(actionEvent -> {
            window.setScene(indicadorDialog);
            indicadorGuiController.comboBoxDialogIndicadorCategoria.getItems().addAll(
                    subsistema_negocios.getCategorias()); //Popula a comboBox das Categorias
        });

        controlPanelGuiController.buttonDialogControlPanelCriarCategoria.setOnAction(actionEvent -> {
            window.setScene(categoriaDialog);
            if (subsistema_negocios.getSupervisorStatus(userGuiController.textFieldDialogUserUsername.getText())) {
                Set<String> set = subsistema_negocios.getOrientadosSupervisorUsername(userGuiController.textFieldDialogUserUsername.getText());
                categoriaGuiController.comboBoxDialogCategoriaOrientado.getItems().addAll(set);
                categoriaGuiController.comboBoxDialogCategoriaOrientado.setDisable(false);
                categoriaGuiController.radioButtonDialogCategoriaOrientado.setDisable(true);
                categoriaGuiController.radioButtonDialogCategoriaSupervisor.setDisable(false);
                categoriaGuiController.radioButtonDialogCategoriaSupervisorOrientado.setDisable(false);
            } else {
                categoriaGuiController.comboBoxDialogCategoriaOrientado.setDisable(true);
                categoriaGuiController.radioButtonDialogCategoriaOrientado.setDisable(false);
                categoriaGuiController.radioButtonDialogCategoriaSupervisor.setDisable(true);
                categoriaGuiController.radioButtonDialogCategoriaSupervisorOrientado.setDisable(true);
            }
        });

        controlPanelGuiController.buttonDialogControlPanelCriarPlanosOrientado.setOnAction(actionEvent -> {
            window.setScene(planoDialog);
            planoGuiController.comboBoxDialogPlanoOrientado.getItems().addAll(subsistema_negocios.getOrientadosSupervisorUsername(userGuiController.textFieldDialogUserUsername.getText()));
            planoGuiController.comboBoxDialogPlanoIndicador.getItems().addAll(subsistema_negocios.getIndicadoresRegistadosMap().values());

        });

        planoGuiController.buttonDialogPlanoCriar.setOnAction(actionEvent -> {
            ((Orientado)  subsistema_negocios.getUtilizador(
                    planoGuiController.comboBoxDialogPlanoOrientado.getSelectionModel().getSelectedItem().toString())).criarNovoPlano(
                            new Date(planoGuiController.textFieldDialogPlanoData.getText()),
                            planoGuiController.textFieldDialogPlanoValorMinimo.getText(),
                            planoGuiController.textFieldDialogPlanoValorMaximo.getText(),
                    planoGuiController.comboBoxDialogPlanoIndicador.getSelectionModel().getSelectedItem().toString(),
                    Double.parseDouble(planoGuiController.textFieldDialogPlanoValorLeituraIndicador.getText()),
                    ((Indicador) planoGuiController.comboBoxDialogPlanoIndicador.getSelectionModel().getSelectedItem()).getUnidadeMedida().getUnidade(),
                    userGuiController.textFieldDialogUserUsername.getText());
                    System.out.println("Novo plano criado com sucesso para o orientado " +
                            planoGuiController.comboBoxDialogPlanoOrientado.getSelectionModel().getSelectedItem().toString());
        });
        planoGuiController.buttonDialogPlanoCancel.setOnAction(actionEvent -> {

            planoGuiController.comboBoxDialogPlanoIndicador.getItems().clear();
            planoGuiController.textFieldDialogPlanoValorMinimo.clear();
            planoGuiController.textFieldDialogPlanoValorMaximo.clear();
            window.setScene(controlPanelDialog);

        });

        controlPanelGuiController.buttonDialogControlPanelConsultarHistoricoIndicador.setOnAction(actionEvent -> {
            window.setScene(historicoObservacoesIndicadorDialog);
            historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorIndicador.getItems().addAll(
                    subsistema_negocios.getIndicadoresRegistadosMap().values());
        });

        historicoIndicadorGuiController.buttonDialogHistoricoIndicadorVoltar.setOnAction(actionEvent -> {
            window.setScene(controlPanelDialog);


        });
    controlPanelGuiController.buttonDialogControlPanelTerminal.setOnAction(actionEvent -> {
        subsistema_negocios.terminalMode();
    });

    historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorIndicador.setOnAction(actionEvent -> {
        historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorRegisto.getItems().clear();
        historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorRegisto.getItems().addAll(
                subsistema_negocios.getIndicadoresRegistadosMap().get(
                        historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorIndicador.getSelectionModel().getSelectedIndex()).getHistoricoObservacoesIndicadorSet());

    });

    historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorRegisto.setOnAction(actionEvent -> {
        historicoIndicadorGuiController.labelDialogHistoricoIndicadorTimestamp.setText(
                subsistema_negocios.getIndicadoresRegistadosMap().get(
                        historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorIndicador.getSelectionModel().getSelectedIndex()).getHistoricoObservacoesIndicadorSet().iterator().next().getTimestamp().toString());
        historicoIndicadorGuiController.labelDialogHistoricoIndicadorObservacao.setText(
                subsistema_negocios.getIndicadoresRegistadosMap().get(
                        historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorIndicador.getSelectionModel().getSelectedIndex()).getHistoricoObservacoesIndicadorSet().iterator().next().getObservacao());
        historicoIndicadorGuiController.labelDialogHistoricoIndicadorSupervisor.setText(
                subsistema_negocios.getIndicadoresRegistadosMap().get(
                        historicoIndicadorGuiController.comboBoxDialogHistoricoIndicadorIndicador.getSelectionModel().getSelectedIndex()).getHistoricoObservacoesIndicadorSet().iterator().next().getUsernameSupervisor());
    });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
