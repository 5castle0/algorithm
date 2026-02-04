import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15686
public class Main {

    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static int n, m;
    static boolean[] chickenVisited;
    static int cityDistance = Integer.MAX_VALUE; // 도시의 치킨거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 지도 정보
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) {
                    houses.add(new Point(j, i));
                } else if (info == 2) {
                    chickens.add(new Point(j, i));
                }
            }
        }

        // m개의 치킨집 고르기 & 치킨 거리 구하기
        chickenVisited = new boolean[chickens.size()];
        for (int i = 0; i < chickens.size(); i++) {
            dfs(0, i);
        }


        bw.write(String.valueOf(cityDistance));

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int start) {

        // 치킨 가게 개수
        if (depth == m) {
            int tempCityDistance = 0;

            for (Point house : houses) {
                int i = 0;
                int chickenDistance = Integer.MAX_VALUE;
                for (Point chicken : chickens) {
                    if (chickenVisited[i]) {
                        int temp = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                        if (temp < chickenDistance) {
                            chickenDistance = temp;
                        }
                    }
                    i++;
                }

                tempCityDistance += chickenDistance;
            }

            if (tempCityDistance < cityDistance) {
                cityDistance = tempCityDistance;
            }
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!chickenVisited[i]) {
                chickenVisited[i] = true;
                dfs(depth + 1, i);
                chickenVisited[i] = false;
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
