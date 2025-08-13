import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }

            boolean ok = true;

            Stack<Character> stack = new Stack<>();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c=='(' || c=='['){
                    stack.add(c);
                    continue;
                }

                if(c==')' || c==']'){
                    if(stack.isEmpty()){
                        ok = false;
                        break;
                    }

                    char pop = stack.pop();

                    if(c==')' && pop!='(') {
                        ok = false;
                        break;
                    }

                    if(c==']' && pop!='['){
                        ok = false;
                        break;
                    }
                }
            }

            if(ok && stack.isEmpty()){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}