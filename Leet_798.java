/*
778. Swim in Rising Water

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 

Example 1:


Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:


Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 */

import java.util.PriorityQueue;
public class Leet_798 
{
    public int swimInWater(int[][] grid) 
    {
        int m=grid[0].length;
        int n=grid.length;
        
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            
            int i1=a/m, j1=a%m;
            int i2=b/m, j2=b%m;
            
            return grid[i1][j1]-grid[i2][j2];
        });
        
        int dir[][]={{0,-1},{-1,0},{0,1},{1,0}};
        
        boolean visited[][]=new boolean[n][m];
        
        int minHeight=0;
        pq.add(0);
        
        while(pq.size()>0)
        {
            int rem=pq.remove();
            int r=rem/m;
            int c=rem%m;
            
            int height = grid[r][c];

            minHeight = Math.max(minHeight, height);
            
            if(r==n-1 && c==m-1)
                break;
            
            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false)
                {
                    visited[nr][nc]=true;
                    pq.add(nr * m + nc);
                }
            }
        }
     return minHeight;   
    }
}
