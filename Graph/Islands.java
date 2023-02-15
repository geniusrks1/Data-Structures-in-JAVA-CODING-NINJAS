public class Solution {

	public static int numConnected(int[][] edges, int n) {
        
		boolean[] visited = new boolean[n];
        int count = 0;
		for(int i=0;i<n;i++){
          if(!visited[i]){
             count++;
            dft(edges,visited,i,n);
            
          }
        }
        return count;
    }
    
    public static void dft(int mat[][],boolean visited[],int startvertex,int n){
        visited[startvertex]=true;
        for(int i=0;i<n;i++){
            if(mat[startvertex][i]==1 && !visited[i]){
                dft(mat,visited,i,n);
            }
        }
        
        
        
        
        
    }
}
