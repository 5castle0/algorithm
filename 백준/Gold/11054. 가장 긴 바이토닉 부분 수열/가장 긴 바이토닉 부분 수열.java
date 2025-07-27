import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpFront = new int[n];
        int[] dpBack = new int[n];

        for(int i=0; i<n; i++){
            dpFront[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dpFront[i] < dpFront[j]+1){
                    dpFront[i] = dpFront[j] + 1;
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            dpBack[i] = 1;
            for(int j=n-1; j>i; j--){
                if(arr[j] < arr[i] && dpBack[i] < dpBack[j]+1){
                    dpBack[i] = dpBack[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(dpFront[i] + dpBack[i] > max) max = dpFront[i] + dpBack[i];
        }

        bw.write(String.valueOf(max-1));
        
        bw.flush();
        bw.close();
        br.close();
    }
}
