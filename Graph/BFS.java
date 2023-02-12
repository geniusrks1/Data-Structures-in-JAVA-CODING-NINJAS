import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
   
// for connected components
     public static void dBreadthFirstTraversal(int adjMat[][]){
         int V= adjMat.length;
         boolean visited []=new boolean[V]; // boolean array
         for(int i=0; i< V; i++){
            if(!visited[i]){
            bft(adjMat, i, visited,V);   
            }
     }
     }
    
     public static void bft(int adjMat[][],int currentVertex,boolean visited[],int V){
          Queue<Integer> q = new LinkedList<>();
            q.add(currentVertex);
            visited[currentVertex]=true;
            while(q.size()!=0){
            int firstelement = q.poll(); //here both poll and remove can be used, both remove and return the first element of the queue
            System.out.print(firstelement+" ");
            for(int i=0; i<V; i++){
                if(adjMat[firstelement][i]==1 && !visited[i]){ //check for all neighbours of firstElement if they have an edge and are not visited put them in the queue
                    q.add(i);
                    visited[i]=true;
                }       
            }
        }   
     }
    
    

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner s= new Scanner(System.in);
        int V=s.nextInt();
        int E=s.nextInt();
        if(V==0)
            return ;
        
        int mat[][]=new int[V][V];
        
        for(int i=0;i<E;i++){
            int V1=s.nextInt();
            int V2=s.nextInt();
            mat[V1][V2]=1;
            mat[V2][V1]=1;
        }
     
       dBreadthFirstTraversal(mat);
        
	}}
