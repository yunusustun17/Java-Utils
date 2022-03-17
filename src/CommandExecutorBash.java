import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommandExecutorBash extends CommandExecutor {
    public static Map<StdKey, List<String>> runCommand(String command) throws IOException {
        if (!initialized)
            initialize();

        return run(command);
    }

    private static void initialize() {
        exe = "/bin/bash";
        exeArg = "-c";

        initialized = true;
    }
}
