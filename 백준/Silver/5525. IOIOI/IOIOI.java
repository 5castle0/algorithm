import java.io.*;

// 5525
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder find = new StringBuilder("I");
        for (int i = 0; i < n; i++) {
            find.append("OI");
        }

        int count = 0;

        while (true) {
            int x = s.indexOf(String.valueOf(find));

            if (x != -1) {
                count++;
                s = s.substring(x + 2);
            } else {
                break;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}