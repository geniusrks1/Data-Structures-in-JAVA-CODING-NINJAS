import java.util.LinkedList;
import java.util.Queue;
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
    
        boolean visited[]=new boolean[v];  
        for(int i=0;i<v;i++){
          if(!visited[i]){
              // this array list is creating again and again
             ArrayList<Integer> arr= new ArrayList<Integer>();
             bft(mat,i,visited,arr); //here we get a coonected graph startting from i
             Collections.sort(arr); //here we are sorting the values in the arraylist by using collections
             for(int j=0;j<arr.size();j++){
               System.out.print(arr.get(j)+" ");
             }    //after 1 connected graph is printed , we will give a new line
                     System.out.println();
          }
        }
    }
    
       
    
	public static void bft(int adjMat[][],int currentVertex,boolean visited[],ArrayList<Integer> arr){
        
          Queue<Integer> q = new LinkedList<>();
            q.add(currentVertex);
            visited[currentVertex]=true;
            while(q.size()!=0){
            int firstelement = q.poll(); //here both poll and remove can be used, both remove and return the first element of the queue
            arr.add(firstelement);
            for(int i=0; i<adjMat.length; i++){
                if(adjMat[firstelement][i]==1 && !visited[i]){ //check for all neighbours of firstElement if they have an edge and are not visited put them in the queue
                    q.add(i);
                    visited[i]=true;
                }       
            }
        }  
     }

}
