import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(q.size() !=1 ){
            q.add(q.remove());
            for(int i=1; i<k ;i++){ //k-1번의 삭제 실행
                if(q.size() ==1){
                    break;
                }
                q.remove();
            }

            if(q.size()<k){
                int temp = q.remove();
                q.clear();
                q.add(temp);
            }
        }

        bw.write(String.valueOf(q.peek()));

        bw.flush();
        bw.close();
        br.close();
    }
}