/* Method 1 (Insert elements of the first tree to second) mlogn
Take all elements of first BST one by one, and insert them into thesecond BST. Inserting an element to a self-balancing BST takes Logn time, where n is the size of the BST. So time complexity of this method
is Log(n) + Log(n+1) … Log(m+n-1). The value of this expression will bebetween mLogn and mLog(m+n-1). For optimization, we can pick the smaller tree as the first tree. */



/* Method 2 (Merge Inorder Traversals) tc=O(m+n)

1) Do inorder traversal of the first tree and store the traversal in one temp arrayList arr1[]. This step takes O(m) time.
2) Do inorder traversal of the second tree and store the traversal inanother temp arrayList arr2[]. This step takes O(n) time.
3) The arrays created in steps 1 and 2 are sorted arrays. Merge the twosorted arrays into one sorted array of size m + n. This step takesO(m+n) time.
4) Construct a balanced tree from the merged array. This step takes O(m+n) time.
The time complexity of this method is O(m+n) which is better than method 1. This method takes O(m+n) time even if the input trees are not balanced.
*/

/*Pseudo-code:
Method: mergeBST
Input: Two BSTs roots root1 and root2
// Store the inorder traversal of the first BST  in arr1.
arr1=inorder(root1)
// Store the inorder traversal of the second BST  in arr2.
arr2=inorder(root2)
// Merge arr1 and arr2 to form a sorted array arr3.
arr3=merge(arr1,arr2)
//Generate a BST from arr3.
new_root= toBST(arr3)
return new_root
*/


import java.util.*;

public class solution {
	static void printMergeTrees(BinaryTreeNode<Integer> node1,BinaryTreeNode<Integer> node2) {
    
        ArrayList<Integer>list1 = storeInorder(node1, new ArrayList<>());
        ArrayList<Integer>list2 = storeInorder(node2, new ArrayList<>());
        ArrayList<Integer>list3 = merge(list1, list2, list1.size(), list2.size());
         
        BinaryTreeNode<Integer> node = SortedArrayListToBST(list3, 0, list3.size()-1);
        print(node);
	}
  
  
  //  stores inorder traversal of a tree
    public static ArrayList<Integer> storeInorder(BinaryTreeNode<Integer> node,ArrayList<Integer> list){
        
        if(node == null)
            return list;
      
        storeInorder(node.left,list);
         
        list.add(node.data);
         
        storeInorder(node.right,list);
         
        return list;
    }
  
  

	 // merges two ArrayLists into one.
   public static ArrayList<Integer> merge(ArrayList<Integer>list1, ArrayList<Integer>list2, int m, int n) {
        ArrayList<Integer> list3 = new ArrayList<>();
        int i=0;
        int j=0;
         
        while( i<m && j<n) {
            if(list1.get(i)<list2.get(j))
                list3.add(list1.get(i++));
            else
                list3.add(list2.get(j++));
        }
         
        while(i<m)
            list3.add(list1.get(i++));
        
        while(j<n) 
            list3.add(list2.get(j++));
         
        
        return list3;
    }

  	//  converts an Sorted ArrayList to a BST
   public static BinaryTreeNode<Integer> SortedArrayListToBST(ArrayList<Integer>list, int start, int end){

        if(start > end)
            return null;
         
        int mid = (start+end)/2;
       BinaryTreeNode<Integer>node = new BinaryTreeNode<>(list.get(mid));

        node.left = SortedArrayListToBST(list, start, mid-1);
        node.right =SortedArrayListToBST(list, mid+1, end);
     
    return node;
    }
  
// print inorder
public static void print(BinaryTreeNode<Integer>node){
		if(node==null)
		return;
		print(node.left);
		System.out.print(node.data+" ");
		print(node.right);
	}
}









