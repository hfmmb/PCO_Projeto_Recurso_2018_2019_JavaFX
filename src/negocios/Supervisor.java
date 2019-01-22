package negocios;

public class Supervisor extends Utilizador {
    private String especialidade;
    public Supervisor(String utilizador, String password, String especialidade){
        super(utilizador, password);
        this.especialidade = especialidade;
    }

    @Override
    public String getUtilizador() {
        return super.getUtilizador();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
