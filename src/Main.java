
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            Seguranca seguranca = new Seguranca();

            System.out.print("Usuário: ");
            String usuario = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (!seguranca.autenticar(usuario, senha)) {
                System.out.println("Acesso negado!");
                Logger.registrar("Acesso negado");
                return;
            }

            ClienteService service = new ClienteService();

            try {
                service.cadastrarCliente(1, "Maria");
                System.out.println("Cliente cadastrado");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                service.cadastrarCliente(2, "João");
                System.out.println("Cliente cadastrado");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                service.cadastrarCliente(3, null);
                System.out.println("Cliente cadastrado");    
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                service.cadastrarCliente(4, "");
                System.out.println("Cliente cadastrado");    
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            Optional<Cliente> cliente1 = service.buscarClientePorId(2);

            cliente1.ifPresentOrElse(
                c -> System.out.println(c.getId() + " - " + c.getNome()),
                () -> System.out.println("Cliente não encontrado")
            );

            Optional<Cliente> cliente2 = service.buscarClientePorId(5);

            cliente2.ifPresentOrElse(
                c -> System.out.println(c.getId() + " - " + c.getNome()),
                () -> System.out.println("Cliente não encontrado")
            );

            service.listarClientes().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));

            try {
                service.removerCliente(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                service.removerCliente(6);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            service.listarClientes().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));

            System.out.println("== LOG ==");
            Logger.getLogger().forEach(System.out::println);

            sc.close();
    }
}