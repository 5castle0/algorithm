import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// 5430
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine(); // 수행할 함수
            int len = p.length();

            int n = Integer.parseInt(br.readLine()); // 수의 개수
            String input = br.readLine();
            input = input.substring(1, input.length() - 1); // 대괄호 제거

            Deque<String> deque = new ArrayDeque<>();
            String[] dequeInput = input.split(",");

            for (String str : dequeInput) {
                if (str.equals("")) {
                    break;
                }
                deque.addLast(str);
            }

            // true면 앞에서부터 시작
            boolean pointerFirst = true;
            boolean error = false;

            for (int i = 0; i < len; i++) {
                char func = p.charAt(i);

                if (func == 'R') {
                    pointerFirst = !pointerFirst; // 포인터 뒤집기
                } else { //func=="D"
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (pointerFirst) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            int size = deque.size();
            if (error) {
                bw.write("error\n");
            } else if (pointerFirst) {
                bw.write("[");

                for (int i = 0; i < size; i++) {

                    String x = deque.removeFirst();
                    if (i == size - 1) {
                        bw.write(x);
                        break;
                    }

                    bw.write(x + ",");
                }

                bw.write("]\n");
            } else {
                bw.write("[");

                for (int i = 0; i < size; i++) {

                    String x = deque.removeLast();
                    if (i == size - 1) {
                        bw.write(x);
                        break;
                    }

                    bw.write(x + ",");
                }

                bw.write("]\n");
            }


        }
        bw.flush();
        bw.close();
        br.close();
    }
}

