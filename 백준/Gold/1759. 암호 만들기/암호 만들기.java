import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

// 1759
public class Main {

    static int l;
    static int c;
    static Character[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken()); // 암호의 길이
        c = Integer.parseInt(st.nextToken()); // 예상 알파벳 개수

        st = new StringTokenizer(br.readLine());
        arr = new Character[c];
        for (int i = 0; i < c; i++) {
            String x = st.nextToken();
            arr[i] = x.charAt(0);
        }

        // 문자 정렬
        Arrays.sort(arr);

        for (int i = 0; i <= c - l; i++) {
            dfs(String.valueOf(arr[i]), i);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(String code, int index) throws IOException {

        // 백트래킹 조건 확인
        if (code.length() == l) {
            int vowels = countVowel(code);
            if (vowels >= 1 && code.length() - vowels >= 2) {
                bw.write(code + "\n");
                return;
            }
        }

        for (int i = index + 1; i < c; i++) {
            String newCode = code + arr[i];
            dfs(newCode, i);
        }
    }

    public static int countVowel(String code) {
        int count = 0;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < code.length(); i++) {
            if (vowels.contains(code.charAt(i))) {
                count++;
            }
        }

        return count;
    }


}

/*
    최소 한 개의 모음 + 최소 두 개의 자음
 */
