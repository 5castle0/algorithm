import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a=0, b=0, c=0, count=0;

        while(true){
            a++;
            b++;
            c++;
            count++;
            if(a==16) a=1;
            if(b==29) b=1;
            if(c==20) c=1;

            if(a==e && b==s && c==m){
               bw.write(String.valueOf(count));
               break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}