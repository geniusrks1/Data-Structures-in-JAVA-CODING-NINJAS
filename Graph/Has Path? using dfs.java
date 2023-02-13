import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		
		int mat[][]=new int[v][v];
		for(int i=0;i<e;i++){
			int a=s.nextInt();
			int b=s.nextInt();
			mat[a][b]=1;
			mat[b][a]=1;
		}

int v1=s.nextInt();
int v2=s.nextInt();
boolean visited[]=new boolean[v];
if(v1>=v||v2>=v){
System.out.print(false);
return;
}


dfs(mat,v,v1,v2,visited);
System.out.print(visited[v2]);

	}
  
  
  public static void dfs(int adjmat[][],int v,int v1,int v2,boolean visited[]){
visited[v1]=true;
for(int i=0;i<v;i++){
	if(adjmat[v1][i]==1 && !visited[i]){
		dfs(adjmat,v,i,v2,visited);
	}
}
}}
