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

System.out.print(bfs(mat,v,source,destination,visited));

	}
  
  	public static boolean bfs(int adjmat[][],int v,int v1,int v2,boolean visited[]){
		Queue<Integer> q=new LinkedList<>();
q.add(v1);
visited[v1]=true;
while(!q.isEmpty()){
int firstelement=q.poll();
for(int j=0;j<v;j++){
	if(adjmat[firstelement][j]==1 && !visited[j]){
		q.add(j);
		visited[j]=true;
if(j==v2)
return true;
	}
}


}
return false;

	}
}
  
  
  
  
  
  
  
