public class Seguranca {
    private static final String USUARIO = "admin";
    private static final String SENHA = "123";

    public boolean autenticar(String usuario, String senha) {
        return USUARIO.equals(usuario) && SENHA.equals(senha);
    } 
}
