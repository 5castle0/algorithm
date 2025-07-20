import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] len = new long[n];
        long[] price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            len[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            price[i] = Long.parseLong(st.nextToken());
        }

        long cost = 0;
        for(int i=0; i<n-1; i++){
            if(price[i+1] > price[i]) price[i+1]=price[i];
        }

        for(int i=0; i<n-1; i++){
            cost += price[i] *len[i];
        }

        bw.write(String.valueOf(cost));

        bw.flush();
        bw.close();
        br.close();
    }

}