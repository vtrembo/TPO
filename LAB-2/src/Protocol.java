import java.nio.ByteBuffer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;;


public class Protocol {

    private final String ADD = "ADD";
    private final String ECHO = "ECHO";
    private final String ADD_PATTERN = "^(" + ADD + ")(\\s+)([0-9]+)(\\s+)([0-9]+)";
    private final Pattern addPattern = Pattern.compile(ADD_PATTERN);
    private final String ECHO_PATTERN = "^("+ECHO+")(\\s+)([\\w|\\s+|\\.|\\']+)+";
    private final Pattern echoPattern = Pattern.compile(ECHO_PATTERN);

    public String handleRequest(ByteBuffer buffer) {
        String input = new String(buffer.array()).trim();
        Matcher echoMatcher = echoPattern.matcher(input);
        Matcher addMatcher = addPattern.matcher(input);
        if(addMatcher.find()) {
            int val1 = Integer.parseInt(addMatcher.group(3));
            int val2 = Integer.parseInt(addMatcher.group(5));
            int sum = val1 + val2;
            String output = "sum: "+ sum;
            return output;
        }else if(echoMatcher.find()) {
            return "ECHO: " + echoMatcher.group(3);
        }
        return "Invalid request";
    }
    public int validateInput(String Input) {
        Matcher echoMatcher = echoPattern.matcher(Input);
        Matcher addMatcher = addPattern.matcher(Input);
        if (addMatcher.find()||echoMatcher.find()) {
            return 1;
        }else {
            return 0;
        }
    }
}
