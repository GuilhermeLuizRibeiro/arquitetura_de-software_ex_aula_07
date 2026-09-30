import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final ClienteDAO dao = new ClienteDAO();

    public void cadastrarCliente(int id, String nome) throws IllegalArgumentException {
        try {
            Cliente cliente = new Cliente(id, nome);
            dao.salvar(cliente);
            Logger.registrar("Cliente cadastrado: " + nome);    
        } catch (IllegalArgumentException e) {
            Logger.registrar("Tentativa de cadastro rejeitada: " + e.getMessage());
            throw e;
        }        
    }

    public List<Cliente> listarClientes() {
        return dao.listar();
    }

    public void removerCliente(int id) throws Exception {
        if(dao.remover(id)) {
            Logger.registrar("Cliente removido: ID " + id);
        } else {
            Logger.registrar("Falha na remoção: cliente não encontrado: ID " + id);
            throw new Exception("Cliente não encontrado");
        }
    }

    public Optional<Cliente> buscarClientePorId(int id) {
        return dao.buscarPorId(id);
    }
}
