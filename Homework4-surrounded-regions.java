class Solution {
    /**
     * 本题思路：类似于课上提及的岛屿问题，采用BFS解决
     * 整体框架与岛屿数目问题类似，只不过对于本题：
     * 1. 对于边界上的'O'不予处理
     * 2. 在进行BFS时，建立标记isSurroundedByX，用于标记当前区域是否被'X'围绕，对于不被围绕的区域，访问过后无需更改为'X' 
     * （本题另外一种思路在同名文件中描述）
    */

    /**
     * 时间复杂度分析：需要遍历 (m * n) 大小的矩阵，同时需要修改其中部分字符，因此时间复杂度为O(m*n)
     * 本算法耗时：4ms
     */

    private boolean[][] visited;
    private int m,n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!(i == 0 || j == 0 || i == m-1 || j == n-1) &&  
                    !visited[i][j] &&
                    board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

    }

    private void bfs(char[][] board, int x, int y) {
        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();
        Queue<Point> flag = new LinkedList<>();

        q.offer(new Point(x, y));
        flag.offer(new Point(x, y));
        visited[x][y] = true;

        boolean isSurroundedByX = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    isSurroundedByX = false;
                    continue;
                }
                if (board[nx][ny] != 'O') continue;
                if (visited[nx][ny]) continue;

                q.offer(new Point(nx, ny));
                flag.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if (isSurroundedByX) {
            while (!flag.isEmpty()) {
                Point p = flag.poll();
                board[p.getX()][p.getY()] = 'X';
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