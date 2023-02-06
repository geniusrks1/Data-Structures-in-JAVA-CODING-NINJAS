// method1  using stack  space complexity o(logn) and time complexity O(n)

import java.util.Stack;
public class Solution {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		if(root==null)
		return;
       int number_of_nodes=countN(root);
	   int count=0;
	   Stack<BinaryTreeNode<Integer>> stack1= new Stack<>();
	   Stack<BinaryTreeNode<Integer>> stack2=new Stack<>();

      BinaryTreeNode<Integer> temp1=root;
	  // pushing all left nodes in stack1
	  while(temp1!=null){
		  stack1.push(temp1);
		  temp1=temp1.left;
	  }

BinaryTreeNode<Integer> temp2=root;
 // pushing all right nodes in stack2
while(temp2!=null){
		  stack2.push(temp2);
		  temp2=temp2.right;
	  }

while(count<number_of_nodes-1){
BinaryTreeNode<Integer> top1=stack1.peek();
BinaryTreeNode<Integer> top2=stack2.peek();

if(top1.data+top2.data==s){
	System.out.println(top1.data+" "+ top2.data);

BinaryTreeNode<Integer> top_1=top1;
stack1.pop();
count++;
if(top_1.right!=null){
	top_1=top_1.right;
	while(top_1!=null){
		stack1.push(top_1);
		top_1=top_1.left;
	}
}

BinaryTreeNode<Integer> top_2=top2;
stack2.pop();
count++;
if(top_2.left!=null){
	top_2=top_2.left;
	while(top_2!=null){
		stack2.push(top_2);
		top_2=top_2.right;
	}
}
}

else if(top1.data +top2.data>s){
BinaryTreeNode<Integer> top_2=top2;
stack2.pop();
count++;
if(top_2.left!=null){
	top_2=top_2.left;
	while(top_2!=null){
		stack2.push(top_2);
		top_2=top_2.right;
	}
}
}

else{
BinaryTreeNode<Integer> top_1=top1;
stack1.pop();
count++;
if(top_1.right!=null){
	top_1=top_1.right;
	while(top_1!=null){
		stack1.push(top_1);
		top_1=top_1.left;
	}
}
}


}
	}

	private static int countN (BinaryTreeNode<Integer> root){
		if(root==null)
		return 0;
		else
		return 1+countN(root.left)+countN(root.right);
	}

}



























// method 2
/*
import java.util.Arrays;
public class Solution {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int sum) {
		 if(root==null)
            return;
        int[] arr=arrayInsertion(root);
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==sum)
                System.out.println(arr[i++]+" "+arr[j--]);
            else if(arr[i]+arr[j]<sum)
                i++;
            else 
                j--;
        }
    }
    private static int[] arrayInsertion(BinaryTreeNode<Integer> root){

        if(root==null)
            return new int[0];

            int firstData=root.data;
            int[]smallAns1= arrayInsertion(root.left);
            int[] smallAns2= arrayInsertion(root.right);

        int[] ans=new int[1+smallAns1.length+smallAns2.length];
        int k=0;
        ans[k++]=firstData;

        for(int i=0;i<smallAns1.length;i++)
              ans[k++]=smallAns1[i];
       
        for(int i=0;i<smallAns2.length;i++) 
            ans[k++]=smallAns2[i];
        
        return ans;

    }

} */





//method 3


import java.util.*;
 class BSTIterator
 {
     //Stack<TreeNode> stack = new Stack<Integer>();
    Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
     boolean reverse = true;
     public BSTIterator(BinaryTreeNode<Integer> root , boolean isreverse)
     {
        reverse = isreverse;
        pushAll(root);
     }
     public boolean hasnext()
     {
         return !stack.isEmpty();
     }
     public int next()
     {
         BinaryTreeNode<Integer> tempNode = stack.pop();
         if(reverse==false) pushAll(tempNode.right);
         else pushAll(tempNode.left);
         return tempNode.data;
     }
     public void pushAll(BinaryTreeNode<Integer> node)
     {
         while(node!=null)
         {
             stack.push(node);
             if(reverse==true) 
             {node = node.right;}
             else 
             {node = node.left;}
         }
     }

 }
public class Solution {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		// Write your code here
		if(root==null) return ;
        BSTIterator l = new BSTIterator(root , false);
        BSTIterator r = new BSTIterator(root , true);

        int i = l.next();
        int j = r.next();

        while(i<j)
        {
            if(i+j==s)
            {
            System.out.println(i+" "+j);
            i=l.next(); j = r.next();
            }
            else if(i+j<s) 
           { i=l.next();}
            else 
            {j=r.next();}
        }
       
	}

}







