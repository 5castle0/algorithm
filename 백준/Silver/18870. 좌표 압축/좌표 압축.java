import java.io.*;
import java.util.*;

// 18870
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        // 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);

        // hashmap 입력
        int rank = 0;
        for(int x : sorted){
            if(!map.containsKey(x)){
                map.put(x, rank);
                rank++;
            }
        }


        for(int i=0; i<n; i++){
            int x = arr[i];
            bw.write(map.get(x)+" ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}