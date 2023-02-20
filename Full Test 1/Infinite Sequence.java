import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) {
		
int arr[]=new int[128];
arr[0]=0;
for(int i=1;i<128;i++){
	int index=search(arr,arr[i-1],i);
	if(index==-1)
	arr[i]=0;
	else
	arr[i]=i-index-1;
}

Scanner s=new Scanner(System.in);
int n=s.nextInt();
int count=0;
for(int i=0;i<n;i++){
	if(arr[i]==arr[n-1])
	    count++;
}
System.out.print(count);

	}


	public static int search(int arr[], int x, int index){
for(int i=index-2;i>=0;i--){
	if(arr[i]==x)
	return i;
}
return -1;
	}
}
