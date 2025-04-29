import java.io.*;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int index = 0;

        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            if(x>index){
                for(int i = index+1; i<=x; i++){
                    index++;
                    stack.push(i);
                    sb.append("+\n");
                }
                sb.append("-\n");
                stack.pop();
            } else if(x==stack.peek()){
                sb.append("-\n");
                stack.pop();
            }else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);

        bw.flush();
        bw.close();
        br.close();
    }
}
