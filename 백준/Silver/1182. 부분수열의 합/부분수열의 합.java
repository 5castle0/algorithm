import java.io.*;
import java.util.StringTokenizer;

// 1182
public class Main {

    static int n, s;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 공집합 제거
        if(s==0){
            count--;
        }
        
        bw.write(String.valueOf(count)); 

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int value){

        // 배열의 끝까지 계산한 경우
        if(depth==n){
            if(value == s){
                count++;
            }
            return;
        }

        // 다음 수를 선택
        dfs(depth+1, value + arr[depth+1]);

        // 다음 수를 선택 x
        dfs(depth+1, value);

    }
}