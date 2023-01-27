/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    // tc1: [[0,0,0],[0,1,0],[0,0,0]]
    // int[][] oddNumbers = { {1, 3, 5, 7}, {9, 11, 13, 15}, {17, 19, 21, 23} };
    int[][] maze = {{0,0,0}, {0,1,0}, {0,0,0}};
    System.out.println(robot(maze));
    
  }

  public static int robot(int[][] maze){
    int m = maze.length;
    int n = maze[0].length;
    boolean[][] visited = new boolean[m][n]; 
    return dfs(0,0,maze,visited, m, n);
    
  }
  public static int dfs(int x, int y, int[][] maze, boolean[][] visited, int m, int n){
    
    if(x == maze.length - 1 && y == maze[0].length - 1) {
      return 1;
    }
    //out of bound
    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == 1 || visited[x][y]) return 0;

    visited[x][y] = true;
    int cnt = 0;
    cnt += dfs(x+1, y, maze, visited, m, n);
    cnt += dfs(x, y+1, maze, visited, m, n);
    visited[x][y] = false;
    
    return cnt;
  }
}