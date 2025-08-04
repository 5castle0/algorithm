import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;

        for(int i=n-1; i>=0; i--){
            int num = n-i;
            int weight = arr[i]*num;
            if(max < weight) max = weight;
        }
        
        bw.write(String.valueOf(max));
        
        bw.flush();
        bw.close();
        br.close();

    }

}