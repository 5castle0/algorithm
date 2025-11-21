import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] arr; // 카드에 쓰여 있는 수
    static int[] made; // 조합되는 수
    static boolean[] visited;
    static List<String> list = new ArrayList<>();
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        made = new int[k];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        bw.write(String.valueOf(list.size()));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth){

        StringBuilder sb = new StringBuilder();

        if(depth==k){
            for(int i=0; i<k; i++){
                sb.append(made[i]);
            }

            String newNum = String.valueOf(sb);
            if(!list.contains(newNum)){
                list.add(newNum);
            }

            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                made[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

}