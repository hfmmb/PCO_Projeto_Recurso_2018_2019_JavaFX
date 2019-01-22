package negocios;

/**
 * Classe abstrata responsavel por criar utilizadores
 */
public abstract class Utilizador {
    protected String utilizador;
    protected String password;
    protected Utilizador(String utilizador, String password){
        this.utilizador = utilizador;
        this.password = password;
    }

    /**
     * Obtem o username do utilizador
     * @return
     */
    protected String getUtilizador() {
        return utilizador;
    }

    /**
     * Obtem a password do utilizador
     * @return
     */
    protected String getPassword() {
        return password;
    }

}
