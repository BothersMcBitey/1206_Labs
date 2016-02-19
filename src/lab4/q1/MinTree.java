package lab4.q1;

public class MinTree {


    Tree tree = new Tree( 24, 
		             new Tree( 45, 
		                 null , 
		                 new Tree(8, null , null) ) , 
	                 new Tree ( 17, 
	                     new Tree (74 , null , null ) , 
	                     null ) );

	public static void main(String[] args) {
		MinTree mt = new MinTree();
		System.out.println("Minimum is :" + mt.findMin());
	}

	public int findMin(){
		return findMinAux(tree);
	}
	
	private int findMinAux(Tree tree){
		if(tree.left() == null && tree.right() == null) return tree.getVal();
		if(tree.left() == null) return Math.min(tree.getVal(), findMinAux(tree.right()));
		if(tree.right() == null) return Math.min(tree.getVal(), findMinAux(tree.left()));
		return Math.min(tree.getVal(), Math.min(findMinAux(tree.left()), findMinAux(tree.right())));
	}
}
