
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {
    private final List<Cliente> clientes = new ArrayList<>();
    
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public boolean remover(int id) {
        Optional<Cliente> cliente = buscarPorId(id);
        if(cliente.isPresent()) {
            clientes.remove(cliente.get());
            return true;
        }
        return false;
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream()
            .filter(c -> c.getId()==id)
            .findFirst();
    }
}
