public class Solution{
    static boolean isSubsetPresent(int[]arr, int n, int sum) {

         if (sum == 0)
            return true;
        if (n == 0)
            return false;
  
      //  If last element is greater than sum, then ignore it 
  if (arr[n-1] > sum)
            return isSubsetPresent(arr, n-1, sum);
       
            
        return  isSubsetPresent(arr, n - 1, sum) || isSubsetPresent(arr,n-1, sum-arr[n-1]);
    }

    }


// using dp

public class Solution{
    static boolean isSubsetPresent(int[]arr, int n, int sum) {

boolean dp[][]=new boolean[n+1][sum+1];
   
for(int i=0;i<=n;i++)
    dp[i][0]=true;


for(int i=1;i<=sum;i++)
dp[0][i]=false;


for(int i=1;i<=n;i++){
    for(int j=1;j<=sum;j++){
        if(j<arr[i-1])
            dp[i][j]=dp[i-1][j];
  
else
dp[i][j]=dp[i-1][j]|| dp[i-1][j-arr[i-1]]; 
 }
}
return dp[n][sum];  
    }
 }

