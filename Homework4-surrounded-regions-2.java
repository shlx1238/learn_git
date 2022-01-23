class Solution {
    /**
     * 本题思路：类似于课上提及的岛屿问题，采用BFS解决
     * 整体框架与岛屿数目问题类似，与第一种解法相反，仅从边界上的'O'开始BFS，这样：
     * 所有不满足条件的'O'都被在visited数组中被标记为'true'，在遍历完整个矩阵后，将矩阵中所有未访问的'O'改为'X'即可
     * 相较于第一种思路，减少了多余队列的空间和时间开销，对矩阵数组的访问相较于队列提高了效率
    */

    /**
     * 时间复杂度分析：需要遍历 (m * n) 大小的矩阵，同时需要二次遍历修改其中部分字符，因此时间复杂度为O(m*n)
     * 本算法耗时：2ms
     */

    private boolean[][] visited;
    private int m,n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m-1 || j == n-1) &&  
                    !visited[i][j] &&
                    board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void bfs(char[][] board, int x, int y) {
        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (board[nx][ny] != 'O') continue;
                if (visited[nx][ny]) continue;

                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}

class Point{
    private int x;
    private int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}