import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        int len = arr[0].length();

        for(int i=1; i<=len; i++){
            Set<String> set = new HashSet<>();

            for(String str : arr){
                String last = str.substring(len-i);
                set.add(last);
            }

            if(n == set.size()) {
                bw.write(String.valueOf(i));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}