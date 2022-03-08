import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommandExecutorWindows extends CommandExecutor {
    public static Map<StdKey, List<String>> runCommand(String command) throws IOException {
        if (!initialized)
            initialize();

        return run(command);
    }

    private static void initialize() {
        exe = "cmd";
        exeArg = "/c";

        initialized = true;
    }
}
