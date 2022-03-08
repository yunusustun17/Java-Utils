import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommandExecutor {
    public enum StdKey {
        stdOut,
        stdErr
    }

    protected static String exe;

    protected static String exeArg;

    protected static boolean initialized = false;

    protected static Map<StdKey, List<String>> run(String command) throws IOException {
        Process processOfPs = new ProcessBuilder(exe, exeArg, command).start();
        processOfPs.getOutputStream().close();

        Map<StdKey, List<String>> result = new HashMap<>();
        result.put(StdKey.stdOut, getStdList(processOfPs.getInputStream()));
        result.put(StdKey.stdErr, getStdList(processOfPs.getErrorStream()));
        return result;
    }

    private static List<String> getStdList(InputStream processOfInputStream) throws IOException {
        List<String> result = new ArrayList<>();

        InputStreamReader inputStreamReader = new InputStreamReader(processOfInputStream);
        BufferedReader stdOut = new BufferedReader(inputStreamReader);

        String line;
        while ((line = stdOut.readLine()) != null) {
            if (!line.isBlank())
                result.add(line);
        }

        processOfInputStream.close();
        inputStreamReader.close();
        stdOut.close();

        return result;
    }
}
