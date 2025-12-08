import java.io.*;
import java.util.StringTokenizer;

// 14888
public class Main {

    static int n;
    static int[] arr;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 값 입력
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹
        dfs(1, arr[0]);

        bw.write(max +"\n");
        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int value){
        if(depth==n){
            if(max < value) max = value;
            if(min > value) min = value;
            return;
        }

        for(int i=0; i<4; i++){
            if(operator[i]>0){
                operator[i]--;
                int newValue = cal(value, arr[depth], i);
                dfs(depth+1, newValue);
                operator[i]++;
            }
        }
    }

    public static int cal(int a, int b, int operator){
        switch (operator){
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3:
                if(a<0){
                    return (Math.abs(a) / b) * -1 ;
                }else{
                    return a / b;
                }
        }
        return 0;
    }
}