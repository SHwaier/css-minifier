import java.util.Stack;

public class TermMatching {
    public String input;
    boolean CurrentBalance;
    Stack<String> stack;

    public TermMatching(String input) {
        this.input = input;
        stack = new Stack<>();
        CurrentBalance = true;
    }

    public TermMatching() {
        this("");
    }

    public boolean Check(String code) {
        input = code;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ':' || (!stack.contains("\"") && c == '"') || (!stack.contains("'") && c == '\'')) {
                stack.push("" + c);
            } else if (c == ';' || c == '"' || c == '\'') {
                if (stack.isEmpty())
                    return false;
                switch (stack.pop()) {
                    case "\"":
                        if (c != '"') {
                            return false;
                        }
                        continue;
                    case "\'":
                        if (c != '\'') {
                            return false;
                        }
                        continue;
                    case ":":
                        if (c != ';') {
                            return false;
                        }
                        continue;
                }
            }
        }
        // Success, base case
        if (stack.isEmpty()) {
            input = "";
            return true;
        }

        return false;
    }
}