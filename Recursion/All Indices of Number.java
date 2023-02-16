import java.util.*;
public class Solution {

	public static int[] allIndexes(int input[], int x) {
  return allIndexes(input, x, 0);	
	}


public static int[] allIndexes(int input[], int x, int start){
 if (start == input.length) {
            return new int[0];
        }
 
        int[] smallIndex = allIndexes(input, x, start + 1);
 
        if (input[start] == x) {
            int[] ans = new int[smallIndex.length + 1];
           ans[0] = start;
            for (int i = 0; i < smallIndex.length; i++) {
               ans[i + 1] = smallIndex[i];
            }
            return ans;
        }
        else {
            return smallIndex;
        }
    }

  
  
  
  
  
