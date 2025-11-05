import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max=0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>max) max = arr[i];
        }

        int min = 0;
        int height = 0; // 절단기 높이
        long length = 0; // 나무 길이
        int ans = 0;

        while(min<max){
            height = (min+max)/2;
            length = 0;

            for(int tree : arr){
                if(tree>height){
                    length += tree-height;
                }

            }

            if (length < m) { // 나무가 부족한 경우
                max = height;
            } else{
                ans = height;
                min = height+1;
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();

    }

}