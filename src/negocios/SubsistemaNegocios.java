package negocios;

import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;

import java.util.*;

// Fazer map indicadores em vez de lista

/**
 * O SubsistemaNegocios é a classe principal do pacote negocios e é responsavel por fazer a logica e funcionamento
 * principal do programa/backend, esta faz logins, cria utilizadores, faz associacoes, etc...
 */
public class SubsistemaNegocios {
    private static SubsistemaNegocios subsistema_negocios = null;
    private Map<String,Utilizador> utilizadoresRegistadosMap = new HashMap();

    /**
     * Retorna a instancia da classe de negocios visto que esta utiliza o padrao de desenho Singleton
     * @return
     */
    public static SubsistemaNegocios getInstance(){
        if(subsistema_negocios == null){
            subsistema_negocios = new SubsistemaNegocios();}
        return subsistema_negocios;
    }
    /**
     * Cria alguns valores predefinidos para ajudar com o debug e teste do programa Utilizadores, Categorias, etc...
     */
    public void setupEnvironment(){
        //Regista orientados no sistema
        registarOrientado("Dante","Alighieri");
        registarOrientado("Mike", "Tyson");
        registarOrientado("Muhammad","Ali");
        registarOrientado("Tokugawa","Ieyasu");

        //Regista supervisores no sistema
        registarSupervisor("Miura", "Kentaro","Mangaka");
        registarSupervisor("Admiral Yi","Sun-shin","Admiral");
        registarSupervisor("Paul","Atreides","General");
        registarSupervisor("John","Titor","Engenheiro");

        //Faz setup de alguns orientados para testar o sistema
        Orientado orientado = (Orientado) utilizadoresRegistadosMap.get("Muhammad");
        Orientado orientado2 = (Orientado) utilizadoresRegistadosMap.get("Mike");
        Orientado orientado3 = (Orientado) utilizadoresRegistadosMap.get("Dante");
        Orientado orientado4 = (Orientado) utilizadoresRegistadosMap.get("Tokugawa");

        //Faz setup de alguns supervisores para testar o sistema
        Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get("Paul");

        //Inicializar algumas categorias no sistema no orientado...

        orientado.adicionarCategoria("Boa Forma");
        orientado.adicionarCategoria("Brevet");
        orientado.adicionarCategoria("Preparacao para maratona");
        orientado.adicionarCategoria("Saude Geral");
        orientado.adicionarCategoria("Saude Cardiaca");

        orientado.criarNovoPlano(new Date(),"0","100","Pushups por dia",
                                                10.0,"Pushups",supervisor.getUtilizador());
        orientado2.criarNovoPlano(new Date(),"2","20",
                "Distancia corrida por dia",10.0,"Metros",supervisor.getUtilizador());
        orientado3.criarNovoPlano(new Date(),"5","10","Jardas saltadas por semana",
                20.0,"Jardas",supervisor.getUtilizador());

        //Associa alguns orientados a um supervisor
        supervisor.associarOrientadoSupervisor(orientado);
        supervisor.associarOrientadoSupervisor(orientado2);
        supervisor.associarOrientadoSupervisor(orientado3);
        supervisor.associarOrientadoSupervisor(orientado4);
    }

    /**
     * Regista um novo Orientado
     * @param username
     * @param password
     */
    public void registarOrientado(String username, String password){
        utilizadoresRegistadosMap.put(username, new Orientado(username, password));
    }

    /**
     * Regista um novo supervisor
     * @param username
     * @param password
     */
    public void registarSupervisor(String username, String password, String especialidade){
        utilizadoresRegistadosMap.put(username, new Supervisor(username,password,especialidade));
    }

    /**
     * Verifica se um username e password sao validos e retorna login efectuado em caso positivo
     * @param username
     * @param password
     * @return
     */
    public Integer checkLoginCredentials(String username, String password){
        Utilizador utilizador;
        try {
            utilizador = utilizadoresRegistadosMap.get(username);
        }
        catch (NullPointerException e){
            System.out.println("Invalid credentials");
            return -2; //Utilizador nao existe
        }
        if(utilizador.getUtilizador().equals(username) && utilizador.getPassword().equals(password)){
            if(utilizador instanceof Orientado){
                return 1; //Orientado
            }
            else{
                return 2; //Supervisor
            }
        }
        return -1; //Password errada
    }

    /**
     * Retorna um objeto do tipo Utilizador
     * @param utilizador
     * @return
     */
    public Utilizador getUtilizador(String utilizador){
        return utilizadoresRegistadosMap.get(utilizador);
    }

    /**
     * Retorna um Set com todas as categorias registadas
     * @return
     */
    public Set getCategorias(){
        return Utilizador.getTodasCategoriasRegistadas();
    }

    /**
     *
     * @return Retorna um set com as unidades de medida registadas no sistema
     */
    public Set<String> getUnidadesMedidaRegistadas(){
        Orientado orientado = new Orientado("Dummy", "Dummy");
        orientado.criarNovoPlano(new Date(),"0","1","Dummy",0.0,"Metros","Dummy");
        orientado.criarNovoPlano(new Date(),"0","1","Dummy",0.0,"Milhas","Dummy");
        return orientado.getPlanosSet().iterator().next().getIndicador().getUnidadesMedida();

    }

    /**
     * Retorna true se o username dado pertence a um supervisor, false se pertence a um orientado
     * @return True se for um Supervisor, False se for um Orientado
     */
    public boolean getSupervisorStatus(String username){
         return utilizadoresRegistadosMap.get(username) instanceof Supervisor;
        }

    /**
     * Insere uma categoria num orientado como supervisor
     * @param usernameSupervisor Username do supervisor
     * @param usernameOrientado Username do orientado
     * @param nomeCategoria Nome da categoria
     * @return True se foi inserida a categoria, false caso nao aconteça
     */
    public boolean inserirCategoriaEmOrientadoComoSupervisor(String usernameSupervisor, String usernameOrientado, String nomeCategoria){
        if (utilizadoresRegistadosMap.get(usernameSupervisor) instanceof Supervisor && utilizadoresRegistadosMap.get(usernameOrientado) instanceof Orientado) {
            Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get(usernameSupervisor);
            Orientado orientado = (Orientado) utilizadoresRegistadosMap.get(usernameOrientado);
            supervisor.inserirCategoriaOrientado(nomeCategoria, orientado);
        return true;
        }
        return false;
    }

    /**
     * Insere uma categoria como utilizador do tipo supervisor retorna true caso tenha sucesso, caso contrario retorna false
     * @param usernameSupervisor Username do supervisor
     * @param nomeCategoria Nome da categoria
     * @return True caso o username dado pertenca a um supervisor e a categoria tenha sido inserida, false caso contrario
     */
    public boolean inserirCategoriaComoSupervisor(String usernameSupervisor, String nomeCategoria) {
        if(utilizadoresRegistadosMap.get(usernameSupervisor) instanceof Supervisor){
        Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get(usernameSupervisor);
        supervisor.insertCategoria(nomeCategoria);
        return true;
        }
        return false;
    }

    /**
     * Insere uma categoria como utilizador do tipo orientado retorna true caso tenha sucesso, caso contrario retorna false
     * @param usernameOrientado Username do Orientado
     * @param nomeCategoria Nome da categoria
     * @return True se o username for de um utilizador do tipo orientado e a categoria tenha sido inserida, false se tal nao acontece
     */
        public boolean inserirCategoriaComoOrientado(String usernameOrientado, String nomeCategoria){
            if(utilizadoresRegistadosMap.get(usernameOrientado) instanceof Orientado){
                Orientado orientado = (Orientado) utilizadoresRegistadosMap.get(usernameOrientado);
                orientado.insertCategoria(nomeCategoria);
            return true;
            }
            return false;
    }

    /**
     * Obtem os orientados associados a um determinado supervisor
     * @param usernameSupervisor Username do supervisor
     * @return Set de Orientados associados ao supervisor
     */
    public Set<Orientado> getOrientadosSupervisor(String usernameSupervisor){
            Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get(usernameSupervisor);
            return supervisor.getOrientadosAssociadosSupervisor();
    }


    /**
     * Obtem o username dos orientados associados a um determinado supervisor
     * @param usernameSupervisor Username do supervisor
     * @return Set de usernames de orientados associados ao supervisor
     */
    public Set<String> getOrientadosSupervisorUsername(String usernameSupervisor){
        Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get(usernameSupervisor);
        return supervisor.getUsernameOrientadosAssociadosSupervisor();
    }


    /**
     * Associa um determinado orientado a um supervisor
     * @param usernameSupervisor Username do supervisor
     * @param usernameOrientado Username do orientado
     */

    public void associarOrientadoSupervisor(String usernameSupervisor, String usernameOrientado){
        Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get(usernameSupervisor);
        Orientado orientado = (Orientado) utilizadoresRegistadosMap.get(usernameOrientado);
        supervisor.associarOrientadoSupervisor(orientado);
    }

    /**
     * Desassocia um determinado orientado de um supervisor
     * @param usernameSupervisor Username do supervisor
     * @param usernameOrientado Username do orientado
     */
    public void desassociarOrientadosSupervisor(String usernameSupervisor, String usernameOrientado){
        Supervisor supervisor = (Supervisor) utilizadoresRegistadosMap.get(usernameSupervisor);
        Orientado orientado = (Orientado) utilizadoresRegistadosMap.get(usernameOrientado);
        supervisor.desassociarOrientadoSupervisor(orientado);
    }
    public void addIndicador(String designacao,Boolean tipo,Double valorUnidade, String unidade){
        Indicador.addIndicadorSet(designacao,tipo,valorUnidade,unidade);
    }
    public Set<Indicador> getIndicadoresRegistadosSet(){
        return Indicador.getIndicadoresRegistadosSet();
    }

    public void terminalMode(){
        /*
         *TODO UC4: Efectuar recolha de observacoes de um indicador
         *TODO UC5: Establecer planos de objetivos de um indicador
         *TODO UC6: Consultar historico de observacoes de um indicador
         */
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0){
        System.out.println("[1] Associar Supervisor Orientado               [2] Desassociar Supervisor Orientado\n" +
                           "[3] Recolher observacao indicador               [4] Establecer plano objetivos indicador\n" +
                           "[5] Consultar historico observacoes indicador   [6] Converter entre unidades nativas\n\nSelecione uma opcao: ");
        opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                System.out.print("Introduza o username do orientado: ");
                String usernameOrientado = scanner.next();
                System.out.print("Introduza o username do supervisor: ");
                String usernameSupervisor = scanner.next();
                if (utilizadoresRegistadosMap.get(usernameSupervisor) instanceof Supervisor && utilizadoresRegistadosMap.get(usernameOrientado) instanceof Orientado) {
                    associarOrientadoSupervisor(usernameSupervisor, usernameOrientado);
                    System.out.println("O orientado " + usernameOrientado + " foi associado ao supervisor " + usernameSupervisor);
                }
                else{
                    System.out.println("Os dados fornecidos sao invalidos");
                }
                break;

            case 2:
                System.out.print("Introduza o username do orientado: ");
                usernameOrientado = scanner.next();
                System.out.print("Introduza o username do supervisor: ");
                usernameSupervisor = scanner.next();
                if (utilizadoresRegistadosMap.get(usernameSupervisor) instanceof Supervisor && utilizadoresRegistadosMap.get(usernameOrientado) instanceof Orientado) {
                    desassociarOrientadosSupervisor(usernameSupervisor, usernameOrientado);
                    System.out.println("O orientado " + usernameOrientado + " foi desassociado do supervisor " + usernameSupervisor);
                }
                else{
                    System.out.println("Os dados fornecidos sao invalidos");
                }
                break;

            case 3:

                break;

            case 4:

                break;
            case 5:

                break;
                case 6:

                break;
        }
        }
    }
}