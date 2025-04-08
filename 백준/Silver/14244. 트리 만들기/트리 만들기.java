import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        int last= 0;


        for(int i=0; i<=n-m-1; i++){
            bw.write(i+" "+(i+1)+"\n");
            count++;
            last = i+1 ;
        }

        int temp = last+1;

        while(true){
            if(count==(n-1)) break;
            bw.write(last+" "+temp+"\n");
            temp++;
            count++;

        }

        bw.flush();
        bw.close();
        br.close();
    }
}