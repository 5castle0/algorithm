import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        // 30 은 2, 3의 배수 이자 5의 배수
        // 0으로 끝나고
        boolean flag = false;
        // 모든 자리수의 합이 3의 배수
        int total = 0;
        int len = n.length();
        Integer[] arr = new Integer[len];
        
        for(int i=0; i<len; i++){
            int temp = n.charAt(i) - '0';
            arr[i] = temp;
            total += temp;
            if(temp==0) flag = true;
        }

        if(flag && total%3==0){
            Arrays.sort(arr, Collections.reverseOrder());
            for(Integer i: arr){
                bw.write(String.valueOf(i));
            }
        }else{
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}