import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();

            if (record.equals("enter")) {
                map.put(name, "enter");
            } else {
                map.remove(name);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, Collections.reverseOrder());

        for (String name : list) {
            bw.write(name + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}