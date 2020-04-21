package com.app.segmenttree.problems;

import java.util.Scanner;

class TreeNode {
	int sumOfSqaures;
	int sum;
	
	public String toString() {
		return sumOfSqaures + " " + sum;
	}
}

class LazyNode {
	int value;
	int type;
}

public class SumOfSquares {
	private static final int TYPE0 = 0;
	private static final int TYPE1 = 1;
	private static final int TYPE2 = 2;
	
	private static void buildTree(int[] nums, TreeNode[] tree, int start, int end, int treeIndx) {
		if(start == end) {
			TreeNode node = new TreeNode();
			node.sum = nums[start];
			node.sumOfSqaures = nums[start]*nums[start];
			tree[treeIndx] = node;
			return;
		}
		
		int mid = start + (end - start)/2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);
		TreeNode newNode = new TreeNode();
		newNode.sumOfSqaures = tree[2*treeIndx].sumOfSqaures + tree[2*treeIndx + 1].sumOfSqaures;
		newNode.sum = tree[2*treeIndx].sum + tree[2*treeIndx + 1].sum;
		tree[treeIndx] = newNode;
		return;
	}
	
	private static TreeNode getSumOfSquares(TreeNode[] tree, int start, int end, int left, int right, int treeIndx) {
		if(end < left || start > right) {
			TreeNode node = new TreeNode();
			node.sumOfSqaures = 0;
			node.sum = 0;
			return node;
		}
		if(start >= left && end <= right) {
			return tree[treeIndx];
		}
		
		int mid = start + (end - start)/2;
		TreeNode ans1 = getSumOfSquares(tree, start, mid, left, right, 2*treeIndx);
		TreeNode ans2 = getSumOfSquares(tree, mid + 1, end, left, right, 2 *treeIndx + 1);
		
		TreeNode finalNode = new TreeNode();
		finalNode.sumOfSqaures = ans1.sumOfSqaures + ans2.sumOfSqaures;
		finalNode.sum = ans1.sum + ans2.sum;
		return finalNode;
	}
	
	private static void increaseByX(TreeNode[] tree, LazyNode[] lazy, int start, int end, int left, int right, int treeIndx, int value) {
		if(lazy[treeIndx]!= null && lazy[treeIndx].type != 0) {
			if(lazy[treeIndx].type == 1) {
				tree[treeIndx].sumOfSqaures += lazy[treeIndx].value;
			}
			if(lazy[treeIndx].type == 2) {
				tree[treeIndx].sumOfSqaures = lazy[treeIndx].value;
			}
			if(start != end) {
				lazy[2 * treeIndx] = new LazyNode();
				lazy[2 * treeIndx + 1] = new LazyNode();
				lazy[2 * treeIndx].value += lazy[treeIndx].value;
				lazy[2 * treeIndx].type = lazy[treeIndx].type;
				lazy[2 * treeIndx + 1].value += lazy[treeIndx].value;
				lazy[2 * treeIndx + 1].type = lazy[treeIndx].type;
			}
			
			lazy[treeIndx].value = 0;
			lazy[treeIndx].type = 0;
		}
		
		if(end < left || start > end)
			return;
		else if(start >= left && end <= right) {
			TreeNode node = tree[treeIndx];
			int incrementedValue = (right - left + 1) * (value * value) + 2 * node.sum * value;
			node.sumOfSqaures += incrementedValue;
			node.sum += (right - left + 1) * value;
			
			if(start != end) {
				lazy[2 * treeIndx] = new LazyNode();
				lazy[2 * treeIndx + 1] = new LazyNode();
				lazy[2 * treeIndx].value += incrementedValue;
				lazy[2 * treeIndx].type = 1;
				lazy[2 * treeIndx + 1].value += incrementedValue;
				lazy[2 * treeIndx + 1].type = 1;
			}
			return;
		}
		
		int mid = start + (end - start)/2;
		increaseByX(tree, lazy, start, mid, left, right, 2 * treeIndx, value);
		increaseByX(tree, lazy, mid + 1, end, left, right, 2 * treeIndx + 1, value);
		
		TreeNode leftChild = tree[2 * treeIndx];
		TreeNode rightChild = tree[2 * treeIndx + 1];
		TreeNode finalNode = new TreeNode();
		finalNode.sumOfSqaures = leftChild.sumOfSqaures + rightChild.sumOfSqaures;
		finalNode.sum = leftChild.sum + rightChild.sum;
		tree[treeIndx] = finalNode;
		return;
	}
	
	public static void setX(TreeNode[] tree, LazyNode[] lazy, int start, int end, int left, int right, int treeIndx, int value) {
		if(lazy[treeIndx]!= null && lazy[treeIndx].type != 0) {
			if(lazy[treeIndx].type == 1) {
				tree[treeIndx].sumOfSqaures += lazy[treeIndx].value;
			}
			if(lazy[treeIndx].type == 2) {
				tree[treeIndx].sumOfSqaures = lazy[treeIndx].value;
			}
			if(start != end) {
				lazy[2 * treeIndx] = new LazyNode();
				lazy[2 * treeIndx + 1] = new LazyNode();
				if(lazy[treeIndx].type == 1) {
					lazy[2 * treeIndx].value += lazy[treeIndx].value;
					lazy[2 * treeIndx + 1].value += lazy[treeIndx].value;
				}
				if(lazy[treeIndx].type == 2) {
					lazy[2 * treeIndx].value = lazy[treeIndx].value;
					lazy[2 * treeIndx + 1].value = lazy[treeIndx].value;
				}
				lazy[2 * treeIndx].type = lazy[treeIndx].type;				
				lazy[2 * treeIndx + 1].type = lazy[treeIndx].type;
			}
			
			lazy[treeIndx].value = 0;
			lazy[treeIndx].type = 0;
		}
		
		if(end < left || start > end)
			return;
		else if(start >= left && end <= right) {
			TreeNode node = tree[treeIndx];
			int newValue = (right - left + 1) * (value * value);
			node.sumOfSqaures = newValue;
			node.sum = (right - left + 1) * value;
			
			//System.out.println(node);
			
			if(start != end) {
				lazy[2 * treeIndx] = new LazyNode();
				lazy[2 * treeIndx + 1] = new LazyNode();
				lazy[2 * treeIndx].value = newValue;
				lazy[2 * treeIndx].type = 2;
				lazy[2 * treeIndx + 1].value = newValue;
				lazy[2 * treeIndx + 1].type = 2;
			}
			return;
		}
		
		int mid = start + (end - start)/2;
		setX(tree, lazy, start, mid, left, right, 2 * treeIndx, value);
		setX(tree, lazy, mid + 1, end, left, right, 2 * treeIndx + 1, value);
		
		TreeNode leftChild = tree[2 * treeIndx];
		TreeNode rightChild = tree[2 * treeIndx + 1];
		TreeNode finalNode = new TreeNode();
		finalNode.sumOfSqaures = leftChild.sumOfSqaures + rightChild.sumOfSqaures;
		finalNode.sum = leftChild.sum + rightChild.sum;
		tree[treeIndx] = finalNode;
		return;
	}
	
 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
        int j = 1;
		while(j <= nTestCases) {
			int nDim = scanner.nextInt();
			int nQueries = scanner.nextInt();
			
			int[] nums = new int[nDim];
			for(int i = 0; i < nDim; i++) {
				nums[i] = scanner.nextInt();
			}
			
			TreeNode[] tree = new TreeNode[4 * nDim];
			LazyNode[] lazy = new LazyNode[4 * nDim];
			buildTree(nums, tree, 0, nDim - 1, 1);
            
            System.out.println("Case "+j+":");
			
			while(nQueries > 0) {
				int queryType = scanner.nextInt();
				int left = scanner.nextInt();
				int right = scanner.nextInt();
				if(queryType == 0 || queryType == 1) {
					int num = scanner.nextInt();
					if(queryType == 0) {
						//set x to all the numbers within the range
						setX(tree, lazy, 0, nDim - 1, left - 1, right - 1, 1, num);
					}
					if(queryType == 1) {
						//add x to all numbers within the range
						increaseByX(tree, lazy, 0, nDim - 1, left - 1, right - 1, 1, num);
//						TreeNode ans = getSumOfSquares(tree, 0, nDim - 1, left - 1, right - 1, 1);
//						System.out.println(ans.sumOfSqaures);
						
					}
				}
				
				if(queryType == 2) {
					// returns sum of squres all the numbers within that range
					TreeNode ans = getSumOfSquares(tree, 0, nDim - 1, left - 1, right - 1, 1);
					System.out.println(ans.sumOfSqaures);
				}
				nQueries--;
			}
			
			
			j++;
		}
		scanner.close();

	}

}
