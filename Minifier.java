import java.util.Scanner;

public class Minifier {

    public static void main(String[] args) {
        TermMatching b = new TermMatching();
        String css = "p.center {\ntext-align: center;\ncolor: red;\n}";
        System.out.println(b.Check(css));
    }

    public String Minify(String input){
        String MinifiedInput = "";
        do
        {
            
        }
        while(input.contains("\n"));

        return MinifiedInput;
    }

    private String GetFirstLine(String input) {
        if (input.contains("\n")) {
            return input.substring(0, input.indexOf("\n"));
        }
        return input;

    }
}
