package negocios;

import negocios.unidades.UnidadesMedidaMetrico;
import negocios.unidades.UnidadesMedidaOutra;
import java.util.*;

/**
 * O SubsistemaNegocios é a classe principal do pacote negocios e é responsavel por fazer a logica e funcionamento
 * principal do programa/backend, esta faz logins, cria utilizadores, faz associacoes, etc...
 */
public class SubsistemaNegocios {
    private static SubsistemaNegocios subsistema_negocios = null;
    private Map<String,Utilizador> utilizadoresRegistadosMap = new HashMap();
    private Map<String,List<Object>> supervisorOrientadosMap = new HashMap<>();//Formato: (String key=Supervisor.name,(Supervisor, Orientado[]))
    private Map<String,List<Object>> categoriasIndicadoresMap = new HashMap<>();//Formato: (String key=Categoria.name,(Categoria, Indicador[]))
    private Map<Utilizador,List<Indicador>> orientadosIndicadoresMap = new HashMap<>();

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


        Categoria categoria = new Categoria("Uncategorized");//Categoria default para os indicadores que nao tem categoria
        List<Object> objectList = new ArrayList<>();
        objectList.add(categoria);
        categoriasIndicadoresMap.put(categoria.getNome(),objectList);//Adiciona a dita categoria ao Map

        //Inicializar algumas categorias no sistema...
        inserirCategoria(new Categoria("Saude Geral"));
        inserirCategoria(new Categoria("Saude Cardiaca"));
        inserirCategoria(new Categoria("Boa Forma"));
        inserirCategoria(new Categoria("Brevet"));
        inserirCategoria(new Categoria("Preparacao para maratona"));

        //Criar alguns indicadores associados a categorias...

        associarIndicadorCategoria(new Categoria("Saude Geral"), new Indicador("Temperatura Corporal", new UnidadesMedidaOutra("37","ºC")));
        associarIndicadorCategoria(new Categoria("Saude Arterial"), new Indicador("Tensao Arterial", new UnidadesMedidaOutra("120","mmHg")));
        associarIndicadorCategoria(new Categoria("Hobbies"), new Indicador("Livros lidos", new UnidadesMedidaOutra("50","Livros")));
        associarIndicadorCategoria(new Categoria("Viagem"), new Indicador("Horas de Voo",new UnidadesMedidaOutra("125","Horas")));
        associarIndicadorCategoria(new Categoria("Lazer"), new Indicador("Vitorias xadrez",new UnidadesMedidaOutra("10", "Vitorias")));

        //Criar alguns indicadores "Sem Categoria"

        UnidadesMedidaMetrico unidadesMedidaMetrico = new UnidadesMedidaMetrico(20.0);
        unidadesMedidaMetrico.metrosParaCm();
        inserirIndicadorSemCategoria(new Indicador("Centimetros Levantados", unidadesMedidaMetrico));

    }

    /**
     * Regista um novo Orientado
     * @param username
     * @param password
     */
    public void registarOrientado(String username, String password){
        Orientado orientado = new Orientado(username,password);
        utilizadoresRegistadosMap.put(orientado.getUtilizador(), orientado);
    }

    /**
     * Regista um novo supervisor
     * @param username
     * @param password
     */
    public void registarSupervisor(String username, String password, String especialidade){
        Supervisor supervisor = new Supervisor(username,password,especialidade);
        utilizadoresRegistadosMap.put(supervisor.getUtilizador(), supervisor);
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
     * Insere uma categoria nova as ja existentes
     * @param categoria
     */
    public void inserirCategoria(Categoria categoria){
        if(!categoriasIndicadoresMap.containsKey(categoria.getNome())){
            List<Object> listaObjetos = new ArrayList<>(); //Cria uma lista de objetos
            listaObjetos.add(categoria);
            categoriasIndicadoresMap.put(categoria.getNome(),listaObjetos);
        }

    }

    /**
     * Associa um indicador a uma categoria
     * @param categoria
     * @param indicador
     */
    public void associarIndicadorCategoria(Categoria categoria, Indicador indicador){
        if(categoriasIndicadoresMap.containsKey(categoria.getNome())) {
            List<Object> listaCategoriasIndicadores = categoriasIndicadoresMap.get(categoria.getNome());
            listaCategoriasIndicadores.add(indicador);
            categoriasIndicadoresMap.replace(categoria.getNome(), listaCategoriasIndicadores);
        }else{
            inserirCategoria(categoria);
            }
        }

    /**
     * Cria um indicador sem categoria
     * @param indicador
     */
    public void inserirIndicadorSemCategoria(Indicador indicador){

    List<Object> listaObjetos = categoriasIndicadoresMap.get("Uncategorized");
    listaObjetos.add(indicador);
    categoriasIndicadoresMap.replace("Uncategorized",listaObjetos);
    }

    /**
     * Remove um indicador do tipo "Uncategorized/Sem Categoria"
     * @param indicador
     */
    public void removerIndicadorSemCategoria(Indicador indicador){
        List<Object> listaObjetos = categoriasIndicadoresMap.get("Uncategorized");
        listaObjetos.remove(indicador);
        categoriasIndicadoresMap.replace("Uncategorized",listaObjetos);
    }
    /**
     * Retira a uma associação entre um indicador e uma categoria fornecidos
     * */
    public void removerIndicadorDeCategoria(Categoria categoria, Indicador indicador){

        List<Object> listaObjetos = categoriasIndicadoresMap.get(categoria.getNome());
        listaObjetos.remove(indicador);
        categoriasIndicadoresMap.replace(categoria.getNome(),listaObjetos);
    }

    /**
     * Apaga uma categoria do Map de categorias registadas
     * @param categoria
     */
    public void removerCategoria(Categoria categoria){
        if(!categoria.getNome().equals("Uncategorized")){
            categoriasIndicadoresMap.remove(categoria.getNome());
        }
    }

    /**
     * Retorna um Set com todas as categorias registadas
     * @return
     */
    public Set getCategorias(){
        return categoriasIndicadoresMap.keySet();
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
}