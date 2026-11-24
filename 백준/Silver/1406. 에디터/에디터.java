import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<String> left = new ArrayDeque<>();
        Deque<String> right = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            left.addLast(String.valueOf(s.charAt(i)));
        }

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String inst = st.nextToken();

            if(inst.equals("L")){
                if(!left.isEmpty()){
                    right.addFirst(left.removeLast());
                }
            } else if (inst.equals("D")) {
                if(!right.isEmpty()){
                    left.addLast(right.removeFirst());
                }
            } else if (inst.equals("B")) {
                if(!left.isEmpty()){
                    left.removeLast();
                }
            }else{
                String x = st.nextToken();
                left.addLast(x);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()){
            sb.append(left.removeFirst());
        }

        while(!right.isEmpty()){
            sb.append(right.removeFirst());
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}