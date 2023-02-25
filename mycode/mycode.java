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
