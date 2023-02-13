import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s=new Scanner(System.in);
        int v=s.nextInt();
        int e=s.nextInt();
        int mat[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            
            mat[v1][v2]=1;
            mat[v2][v1]=1;
        }
         int source=s.nextInt();
         int destination=s.nextInt();
        boolean visited[]=new boolean[v];
        ArrayList<Integer>arr=dftpath(mat,source,destination,v,visited);
        



        
        if(arr!=null){
            for(int i :arr){
                System.out.print(i+" ");
            }
        }
        
	}
    
    public static  ArrayList<Integer> dftpath(int mat[][],int source,int destination,int v,boolean visited[]){
        if(source==destination){
          ArrayList<Integer>arr1=new ArrayList<Integer>();
          arr1.add(source);
          return arr1;
        }
        
        visited[source]=true;
        for(int i=0;i<v;i++){
            if(mat[source][i]==1&& !visited[i]){
             ArrayList<Integer>arr2=dftpath(mat,i,destination,v,visited);
                if(arr2!=null){
                    arr2.add(source);
                    return arr2;
                }
            }
        }
        
        return null;
        
        
    }
}
