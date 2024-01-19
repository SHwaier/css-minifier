import java.util.Stack;

public class Minifier {

    public static String Minify(String input) {
        TermMatching tm = new TermMatching(input);
        String MinifiedInput = "";
        do {
            String CurrentLine = GetFirstLine(input);
            input = DeleteFirstLine(input);

            boolean IsBalanced = true;

            for (int i = 0; i < CurrentLine.length(); i++) {
                char c = CurrentLine.charAt(i);
                if (c == ';' || c == ':' || c == '"' || c == '\'') {
                    tm.input += c;
                    IsBalanced = tm.Check(tm.input);
                    continue;
                }
                if (IsBalanced) {
                    if (c == ' ' || c == '\n' || c == '\t') {
                        continue;
                    }
                    MinifiedInput += c;
                }

            }

        } while (input.contains("\n") || !input.isEmpty());

        return MinifiedInput;
    }

    private static String DeleteFirstLine(String input) {
        if (input.contains("\n")) {
            return input.substring(input.indexOf("\n") + 1);
        }
        // if there is no line then just get rid of the last line standing
        return "";
    }

    private static String GetFirstLine(String input) {
        if (input.contains("\n")) {
            return input.substring(0, input.indexOf("\n"));
        }
        // if there isn't another line then just return the curreent line because it is
        // the last line standing
        return input;

    }

}
