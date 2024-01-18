
public class Minifier {

    

    public static String Minify(String input) {
        String MinifiedInput = "";
        do {
            String CurrentLine = GetFirstLine(input);
            input = DeleteFirstLine(input);
            for (int i = 0; i < CurrentLine.length(); i++) {
                
            }
            System.out.println(CurrentLine);
        } while (input.contains("\n") || !input.isEmpty());

        return MinifiedInput;
    }

    private static String DeleteFirstLine(String input) {
        if (input.contains("\n")) {
            return input.substring(input.indexOf("\n") + 1);
        }
        //if there is no line then just get rid of the last line standing
        return "";
    }

    private static String GetFirstLine(String input) {
        if (input.contains("\n")) {
            return input.substring(0, input.indexOf("\n"));
        }
        //if there isn't another line then just return the curreent line because it is the last line standing 
        return input;

    }
}
