import java.util.*;
public class Solution {
      public static String backspace(String str){
        Stack<Character> q = new Stack<Character>();
 
    for (int i = 0; i < str.length(); ++i){
        if (str.charAt(i) != '#')
            q.push(str.charAt(i));
        else if (!q.isEmpty())
            q.pop();
    }
 
    
    String ans = "";
 
    while (!q.isEmpty())
        ans = q.pop()+ans;
    
    return ans;
}
        }

