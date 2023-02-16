	public static int solve(boolean[][] graph, int n) {
	int count=0;
	for(int i=0;i<n-2;i++){
		for(int j=i+1;j<n-1;j++){
			for(int k=j+1;k<n;k++){
				if(graph[i][j] && graph[j][k]&& graph[i][k]){
				count++;
			}}
		}
	}
return count;

	}
