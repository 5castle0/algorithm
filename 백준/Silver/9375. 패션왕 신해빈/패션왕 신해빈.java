import java.io.*;
import java.util.*;

// 9375
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            HashMap<String, Integer> hashMap = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if(!hashMap.containsKey(type)){
                    hashMap.put(type, 1);
                }else{
                    int temp = hashMap.get(type); // 특정 의상종류의 수
                    // 이미 있는 종류면 +1
                    hashMap.put(type, temp+1);
                }
            }

            int combination = 1;

            for(String type: hashMap.keySet()){
                combination *=  (hashMap.get(type) + 1);
            }

            bw.write(combination-1 + "\n");

        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}