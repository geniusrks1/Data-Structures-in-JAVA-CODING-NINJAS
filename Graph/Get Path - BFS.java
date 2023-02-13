import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
	
	public static void main(String[] args)  throws NumberFormatException, IOException{
       Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int mat[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            mat[v1][v2]=1;
            mat[v2][v1]=1;
        }
        int S=s.nextInt();
        int D=s.nextInt();
      
        ArrayList<Integer> arr=getPathBFS(mat,S,D);
             if(arr!=null)
            for(int i:arr){
                System.out.print(i+" ");
            }
        }
    
public static ArrayList<Integer> getPathBFS(int adjMatrix[][], int s, int e){
Queue<Integer> q = new LinkedList<>(); 
HashMap<Integer, Integer> map = new HashMap<>(); 
boolean visited[] = new boolean[adjMatrix.length]; 
visited[s] = true; 
q.add(s); 
map.put(s, -1); 

while(!q.isEmpty()){
int cv = q.poll(); 
for(int i = 0; i < adjMatrix.length; i++){ 
if(adjMatrix[cv][i] == 1 && !visited[i]){
q.add(i); 
visited[i] = true; 
map.put(i, cv); 
if(i == e) { // path found
ArrayList<Integer> list = new ArrayList<>();
 int parent = e;
while (parent != -1) {
    list.add(parent);
    parent = map.get(parent);
}
return list;


}}}}
      
return null;

}
}
