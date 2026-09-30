public class Cliente {
    private final int id;
    private final String nome;

    public Cliente(int id, String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
}
