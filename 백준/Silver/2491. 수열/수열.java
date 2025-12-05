import java.io.*;
import java.util.StringTokenizer;

// 2491
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpRaise = new int[n];
        int[] dpLower = new int[n];
        int raiseCount = 1;
        int lowerCount = 1;

        dpRaise[0] = 1;
        dpLower[0] = 1;

        for(int i=1; i<n; i++){
            // 연속해서 커지거나 같은 경우
            if(arr[i-1] <= arr[i]){
                dpRaise[i] = dpRaise[i-1] + 1;
                if(dpRaise[i] > raiseCount){
                    raiseCount = dpRaise[i];
                }
            }else{
                dpRaise[i] = 1;
            }

            // 연속해서 작아지거나 같은 경우
            if(arr[i-1] >= arr[i]){
                dpLower[i] = dpLower[i-1] + 1;
                if(dpLower[i] > lowerCount){
                    lowerCount = dpLower[i];
                }
            }else{
                dpLower[i] = 1;
            }
        }

        bw.write(String.valueOf(Math.max(raiseCount, lowerCount)));

        bw.flush();
        bw.close();
        br.close();
    }
}