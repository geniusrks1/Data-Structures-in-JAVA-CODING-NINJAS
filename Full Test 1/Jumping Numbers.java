import java.util.*;
public class Solution {
	public static void showJumpingNos(int x) {
		  System.out.print(0 + " ");
        for (int i = 1; i <= 9 && i<=x; i++) 
            bfs(i, x); // generate all the numbers starting from i // level order traversal
	
	}


static void bfs(int i, int x){
    Queue<Integer> q=new LinkedList<>();
    q.add(i);
    while(!q.isEmpty()){
        int n=q.remove();
        if(n<=x){
            System.out.print(n+" ");
            int lastdigit=n%10;
            if(lastdigit==0){
                q.add(n*10 +1);
            }
            else if(lastdigit==9){
                q.add(n*10 +8);
            }
            else{
                q.add(n*10 +lastdigit+1);
                 q.add(n*10 +lastdigit-1);
            }
        }
    }
}






