import java.util.List;
import java.util.ArrayList;
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        backtracking(result, str, n, 0,0);
        return result;
    }

    public void backtracking(List<String> result, StringBuilder str, int n, int openCount, int closeCount) {
        if (str.length() == n*2) {
            result.add(str.toString());
            return;
        }
        if (openCount < n) {
            str.append("(");
            backtracking(result, str, n, openCount + 1, closeCount);
            str.deleteCharAt(str.length() - 1);
        }

        if (closeCount < openCount) {
            str.append(")");
            backtracking(result, str, n, openCount, closeCount + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
