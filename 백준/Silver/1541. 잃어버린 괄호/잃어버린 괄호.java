import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        int total = 0;
        boolean first = true;

        while(st.hasMoreTokens()){
           int temp = 0;

           StringTokenizer st1 = new StringTokenizer(st.nextToken(),"+");

           while(st1.hasMoreTokens()){
               temp += Integer.parseInt(st1.nextToken());
           }

           if(first){
               total = temp;
               first = false;
           }else{
               total -= temp;
           }
        }
        
        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();
    }
}