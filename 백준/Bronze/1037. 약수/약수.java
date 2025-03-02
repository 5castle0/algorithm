import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums =new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int a;

        if(N%2==0) { //짝수개의 약수라면
            a = nums[N/2-1]*nums[N/2];
        }else{
            a = nums[N/2]*nums[N/2];
        }

        bw.write(String.valueOf(a));

        bw.flush();
        bw.close();
        br.close();
    }
}