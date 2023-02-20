import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=s.nextInt();

select(arr,12,0,n,"");

	}

	public static void select(int arr[], int r,int start, int n,String str){
		if(r==0){
		System.out.println(str);
			return ;
		}

if(start==n){
	return;
}

select(arr,r-1,start+1,n,str+arr[start]+" ");
select(arr,r,start+1,n,str);


	}

}
