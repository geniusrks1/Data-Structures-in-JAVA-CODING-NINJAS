import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
       Scanner s=new Scanner (System.in);
        int v=s.nextInt();
        int e=s.nextInt();
        int mat[][]= new int[v][v];
        for(int i=0;i<e;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            mat[v1][v2]=1;
            mat[v2][v1]=1;
            
        }
        
    
       if(v<2){
           System.out.print("true");
           return;
       }
        if(v-1>e){
             System.out.print("false");
           return;
        }
        
        
      
        System.out.print(getPathBFS(mat,0,v-1));   
	}
    
                         
public static boolean getPathBFS(int adjMatrix[][], int s, int e){
    
Queue<Integer>q = new LinkedList<>(); 
boolean visited[] = new boolean[adjMatrix.length]; 
visited[s] = true; 
q.add(s);  
// boolean pathFound = false;

while(!q.isEmpty()){
int currentVertex = q.poll(); 
for(int i = 0; i < adjMatrix.length; i++){ 
if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
q.add(i); 
visited[i] = true; 
if(i == e) { // Path found 
return true;
}
}
}
}

return false;
}}
