import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> map = new HashMap<>();

        for(int i = 1; i <= n; i++){
            map.put(String.valueOf(i),br.readLine());
        }

        HashMap<String,String> reversedMap = new HashMap<>();
        for(String s : map.keySet()){ //s는 map에서의 키 -> reversedMap에서는 value로 들어가기
            reversedMap.put(map.get(s),s);
        }

        for(int i = 1; i <= m; i++){
            String find = br.readLine();
            if(map.containsKey(find)){
                bw.write(map.get(find)+"\n");
            }
            else{
                bw.write(reversedMap.get(find)+"\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}