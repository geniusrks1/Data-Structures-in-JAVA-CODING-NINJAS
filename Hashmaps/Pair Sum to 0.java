
public class Solution {
	public static int PairSum(int[] input, int size) {
		 if(size==0)
            return 0;
        
        HashMap<Integer,Integer> h=new HashMap<>();
       
        int count=0;
        for(int i=0;i<size;i++) {   
            if(h.containsKey(-input[i]) && h.get(-input[i])!=0){
                count+=h.get(-input[i]);
              
            }
            
                if(h.containsKey(input[i]))
                    h.put(input[i],h.get(input[i])+1);
                else
                    h.put(input[i] ,1);
                
            } 
        return count;
       
	}
}
