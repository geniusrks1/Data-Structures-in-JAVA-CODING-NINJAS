public class Solution {
	

	int solve(String[] Graph , int N, int M)
	{
		String str = "CODINGNINJA";
        
		boolean[][] visited = new boolean[N][M];
		
        // travel each vertex
        
		for(int i=0;i<N;i++) { 
			for(int j=0;j<M;j++) {
				if(Graph[i].charAt(j) == 'C' ) {
					if(dfs( Graph,visited,str.substring(1),i,j)) {
						return 1;
					}
                   

				}
			}

		}
		return 0;
	}



    public static boolean dfs(String[] graph, boolean[][] visited, String searchString,int i,int j) {

		if(searchString.length() == 0) {
			visited[i][j] = true;
			return true;
		}

		visited[i][j] = true;
		// To traverse in 8 different directions
		int[] X_Dir = {-1,1,0,0,1,-1,1,-1 };
		int[] Y_Dir = {0,0,-1,1,1,-1,-1,1 };

		for(int k=0;k<8;k++) {

			int x = i+ X_Dir[k];
			int y = j+ Y_Dir[k];

if( x>=0 && y>=0 && x< graph.length && y < graph[x].length() && graph[x].charAt(y) ==searchString.charAt(0) && !visited[x][y]) {
				if(dfs(graph, visited, searchString.substring(1), x, y)) {
					return true;
				}	
			}
		}
		
		visited[i][j] = false;
		return false;

	}
}
