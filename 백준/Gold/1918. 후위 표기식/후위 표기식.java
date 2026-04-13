import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int len = str.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char x = str.charAt(i);

            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                while (true) {
                    char temp = stack.pop();
                    if (temp == '(') {
                        break;
                    }
                    bw.write(temp);
                }
            } else if (x == '*' || x == '/') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == '+' || stack.peek() == '-') {
                        break;
                    }
                    bw.write(stack.pop());
                }
                stack.push(x);
            } else if (x == '+' || x == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    bw.write(stack.pop());
                }
                stack.push(x);
            } else {
                bw.write(x);
            }
        }

        while (!stack.isEmpty()) {
            Character x = stack.pop();
            if (x == '(' || x == ')') {
                continue;
            }

            bw.write(x);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}