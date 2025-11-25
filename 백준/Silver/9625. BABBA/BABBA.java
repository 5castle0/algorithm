import java.io.*;

// 9625
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2]; // A 개수, B 개수
        arr[0] = 1;

        for(int i=0; i<n; i++){
            int a = arr[0];
            int b = arr[1];
            arr[0] = b;
            arr[1] = a + b;
        }

        bw.write(arr[0] + " " + arr[1]);

        bw.flush();
        bw.close();
        br.close();
    }

}

/*
    B -> BA
    A -> B
 */