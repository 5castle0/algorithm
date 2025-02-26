import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[2];

        list[0] = Integer.parseInt(st.nextToken());
        list[1] = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[list[1]+1]; //0부터 N까지 저장
        Arrays.fill(isPrime,true); // isPrime 배열의 초기값을 true로 설정
        isPrime[0] = isPrime[1] = false; //0과 1은 소수가 아님

        for(int i = 2 ; i <= list[1] ; i++){
            if(isPrime[i]){
                for(int j=2 ; j*i <= list[1]; j++){
                    isPrime[j*i] = false;
                }
            }
        }

        for(int i = list[0]; i<=list[1] ; i++){
            if(isPrime[i]==true) System.out.println(i);
        }
      
        br.close();
    }
}