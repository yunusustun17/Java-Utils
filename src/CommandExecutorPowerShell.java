import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommandExecutorPowerShell extends CommandExecutor {
    public static Map<StdKey, List<String>> runCommand(String command) throws IOException {
        if (!initialized)
            initialize();

        return run(command);
    }

    private static void initialize() {
        exe = "powershell.exe";
        exeArg = "-command";

        initialized = true;
    }
}
