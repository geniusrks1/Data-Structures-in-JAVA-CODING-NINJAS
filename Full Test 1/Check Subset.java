// method1 tc O(m+n)

import java.util.*;
public class solution {
	
	public static boolean CheckSubset(int[] arr1, int n1, int[] arr2, int n2) {
HashMap<Integer,Integer> map1=new HashMap<>();
HashMap<Integer,Integer> map2=new HashMap<>();

for(int i=0;i<n1;i++){
	if(map1.containsKey(arr1[i]))
		map1.put(arr1[i],map1.get(arr1[i])+1);
	else
	map1.put(arr1[i],1);
}

for(int i=0;i<n2;i++){
	if(map1.containsKey(arr2[i])&& map1.get(arr2[i])>0)
	   map1.put(arr2[i],map1.get(arr2[i])-1);
else
return false;

}
        return true;
	}

	
}






// method 2 tc nlogn+mlogn
import java.util.*;
public class solution {
	
	public static boolean CheckSubset(int[] arr1, int m, int[] arr2, int n) {
         int i = 0, j = 0;
 
        if (m < n)
            return false;
 
        Arrays.sort(arr1); // sorts arr1
        Arrays.sort(arr2); // sorts arr2
 
        while (i < n && j < m) {
            if (arr1[j] < arr2[i])
                j++;
            else if (arr1[j] == arr2[i]) {
                j++;
                i++;
            }
            else if (arr1[j] > arr2[i])
                return false;
        }
 
        if (i < n)
            return false;
        
            return true;
    }}
