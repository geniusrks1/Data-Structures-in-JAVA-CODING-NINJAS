/* algorthm 
1. take input and store graph by using edgelist (create edge class) 
2.Sort edges in Asecending order of weight (use Comparable Interface  to implement and Override the compareTo method in Edge class )
3. start picking edge one by one while(count !=n-1) intially count=0;
4. by using union algorthm pick only those edges whose both vertex having different parent and after picking up update both vertex paraents and increase count++ */ 
//create a output array of n-1 size , in a MST of n vertices, no. of edges = n-1
 //create a parent arary with size same as number of vertices //initialize all nodes parent to teh node themshleves




import java.util.*;

class Edge implements Comparable<Edge>{
    int source;
    int dest;
    int weight;
public Edge(int source, int dest, int weight){
	this.source=source;
	this.dest=dest;
	this.weight=weight;
}
   public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

  
  
  public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
      Edge[] input = new Edge[e];
        for(int i=0;i<e;i++) 
            input[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        
        Arrays.sort(input);
        kruskals(input,v);
    }
    
    public static void kruskals(Edge[] input, int n) {
		
		Edge[] output = new Edge[n-1]; 
		int[] parent = new int[n];
		for(int i=0;i<parent.length;i++) 
			parent[i] = i; 
		
	int count =0;
		for(int i=0;count<n-1;i++){
			
			int parentSource = findParent(parent,input[i].source);
			int parentDest = findParent(parent,input[i].dest);
			
			if(parentDest!=parentSource){
			output[count] = input[i];
			parent[parentSource] = parentDest; //update parent in each case where the swap occurs
			count++;
			}
		}
      
	print(output); 	// print the output
		
	}
    
    public static int findParent(int[] parent, int i) {
		if(parent[i] == i) {
			return i;
		}
		return findParent(parent, parent[i] );
	}



	public static void print(Edge[] mstOutput){
	for(Edge edge : mstOutput) {
			if(edge.source < edge.dest)
			System.out.println( edge.source +" "+ edge.dest+" "+ edge.weight);
			else {
				System.out.println(edge.dest+" "+ edge.source+" " + edge.weight);
			}	
		}
	}
    
    
	}
    
    
    
    
    
    
    
    
