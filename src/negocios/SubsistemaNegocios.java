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
    private Map<String,List<Object>> supervisorOrientadosMap = new HashMap<>();//Formato: (String key=Supervisor.name,(Supervisor, Orientado[]))

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
        registarOrientado("Dante","Alighieri");
        registarOrientado("Mike", "Tyson");
        registarOrientado("Muhammad","Ali");
        registarOrientado("Tokugawa","Ieyasu");
        registarSupervisor("Miura", "Kentaro","Mangaka");
        registarSupervisor("Admiral Yi","Sun-shin","Admiral");
        registarSupervisor("Paul","Atreides","General");
        registarSupervisor("John","Titor","Engenheiro");

        Orientado orientado = (Orientado) utilizadoresRegistadosMap.get("Muhammad");

        //Inicializar algumas categorias no sistema...
        orientado.adicionarCategoria(new Categoria("Saude Geral"));
        orientado.adicionarCategoria(new Categoria("Saude Cardiaca"));
        orientado.adicionarCategoria(new Categoria("Boa Forma"));
        orientado.adicionarCategoria(new Categoria("Brevet"));
        orientado.adicionarCategoria(new Categoria("Preparacao para maratona"));


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
     * Associa um supervisor a um orientado
     * @param supervisor
     * @param orientado
     */
    public void associarSupervisorOrientado(Supervisor supervisor, Orientado orientado){

        if(supervisorOrientadosMap.get(supervisor.getUtilizador()).size()>1){
            List<Object> list = supervisorOrientadosMap.get(supervisor.getUtilizador());
            list.add(orientado);
            supervisorOrientadosMap.replace(supervisor.getUtilizador(),list);
        }
    }

    /**
     * Desassocia um supervisor a um orientado
     * @param supervisor
     * @param orientado
     */
    public void desassociarSupervisorOrientado(Supervisor supervisor, Orientado orientado){

        if(supervisorOrientadosMap.get(supervisor.getUtilizador()).size()>1){
            List<Object> list = supervisorOrientadosMap.get(supervisor.getUtilizador());
            list.remove(orientado);
            supervisorOrientadosMap.replace(supervisor.getUtilizador(),list);
        }
    }
    public Set<String> getUnidadesMedidaRegistadas(){
        Indicador indicador = new Indicador("Dummy", new UnidadesMedidaMetrico(0.0));
        indicador = new Indicador("Dummy", new UnidadesMedidaImperial(0.0));
        return indicador.getSetUnidadesMedida();

    }
}