import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[81];

        for(int i=1; i<=arr[0]; i++){
            for(int j=1; j<=arr[1]; j++){
                for(int k=1; k<=arr[2]; k++){
                    sum[i+j+k]++;
                }
            }
        }

        int index = 0;
        int max = 0;
        for(int i=0; i<81; i++){
            if( sum[i] > max) {
                max = sum[i];
                index = i;
            }
        }

        bw.write(String.valueOf(index));
        
        bw.flush();
        bw.close();
        br.close();

    }

}