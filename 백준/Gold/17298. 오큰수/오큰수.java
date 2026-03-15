import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정답 배열
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            boolean flag = false;

            while (!stack.isEmpty()) {
                int peek = stack.peek();

                // 오큰수를 찾은 경우 
                if (arr[i] < peek) {
                    ans[i] = peek;
                    stack.add(arr[i]);
                    flag = true;
                    break;
                } 
                // 오큰수가 아닌 경우
                else {
                    stack.pop();
                }
            }

            // 오큰수가 없는 경우 
            if (!flag) {
                ans[i] = -1;
                stack.add(arr[i]);
            }
        }

        for (int i : ans) {
            bw.write(i + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}