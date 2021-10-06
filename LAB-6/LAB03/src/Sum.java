import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/sum")
public class Sum extends HttpServlet {

    private static final String integerPattern = "^[0-9]+$";
    private static final Pattern integerRegex = Pattern.compile(integerPattern);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BigInteger sum;
        String strSum;
        BigInteger parameter1 = valueParse(request, "component1");
        BigInteger parameter2 = valueParse(request, "component2");
        if (parameter1 != null && parameter2 != null) {
            sum = parameter1.add(parameter2); } else { sum = null; }
        if (sum != null) {
            strSum = sum.toString(); } else { strSum = ""; }

        PrintWriter out = response.getWriter();
        out.write("{ \"" + "sum" + "\": " + strSum + "}");
        out.close();
    }

    private static BigInteger valueParse (HttpServletRequest request, String input) {
        String val = request.getParameter(input);
        if (val == null) return null;
        Matcher matcher = integerRegex.matcher(val);
        if(!matcher.matches()) return null;
        return new BigInteger(val);
    }
}