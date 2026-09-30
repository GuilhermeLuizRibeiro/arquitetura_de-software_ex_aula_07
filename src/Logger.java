import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final List<String> logger = new ArrayList<>();

    private Logger() {}

    public static void registrar(String mensagem) {
        logger.add(mensagem);
    }

    public static List<String> getLogger() {
        return logger;
    }
}
