import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        maze = new char[r][c];

        Queue<Point> personQueue = new LinkedList<>();
        Queue<Point> fireQueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String column = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = column.charAt(j);

                // 초기 위치
                if (maze[i][j] == 'J') {
                    personQueue.add(new Point(i, j, 0));
                }
                // 불 난 위치
                else if (maze[i][j] == 'F') {
                    fireQueue.add(new Point(i, j, 0));
                }
            }
        }

        boolean flag = false;

        while (!personQueue.isEmpty()) {

            // 지훈이의 이동
            int size1 = personQueue.size();
            for(int i=0; i<size1; i++){
                Point now = personQueue.poll();

                // 다른 곳에서 불이 옮겨 붙은 경우
                if (maze[now.y][now.x] == 'F') {
                    continue;
                }

                // 가장자리에서 탈출
                if (isEdge(now.y, now.x)) {
                    bw.write(String.valueOf(now.count + 1));
                    flag = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int cy = now.y + dy[j];
                    int cx = now.x + dx[j];

                    if (inRange(cy, cx)) {
                        if (maze[cy][cx] == '.') {
                            personQueue.add(new Point(cy, cx, now.count + 1));
                            maze[cy][cx] = 'V'; // visited
                        }
                    }
                }
            }

            if(flag){
                break;
            }

            // 불의 이동
            int size2 = fireQueue.size(); // 현재 불의 개수
            for (int i = 0; i < size2; i++) {
                Point fire = fireQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int cy = fire.y + dy[j];
                    int cx = fire.x + dx[j];

                    if (inRange(cy, cx) && maze[cy][cx] != 'F' && maze[cy][cx] != '#') {
                        maze[cy][cx] = 'F';
                        fireQueue.add(new Point(cy, cx, fire.count + 1));
                    }
                }
            }
        }

        if (!flag) {
            bw.write("IMPOSSIBLE");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    // 가장자리에 도달했는지 검사
    private static boolean isEdge(int y, int x) {
        return y == 0 || y == r - 1 || x == 0 || x == c - 1;
    }

    // 좌표가 범위 안에 있는지 검사
    private static boolean inRange(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }
}