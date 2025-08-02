import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2*n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i*2] = x;
            arr[i*2+1] = y;
        }

        int[] bigger = new int[n];

        for(int i=0; i<n; i++){ // 주체
            for(int j=0; j<n; j++){ //비교대상
                if(i==j) continue;

                if(arr[2*i] < arr[2*j] && arr[2*i+1] < arr[2*j+1]){
                    bigger[i]++;
                }
            }
        }

        for(int k : bigger){
            bw.write(k+1 + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();

    }

}