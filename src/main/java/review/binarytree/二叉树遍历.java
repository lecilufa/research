package review.binarytree;

public class 二叉树遍历 {
	

	
	public static void main(String[] args) {
		
		Node root = buildTree();
		
		preorder(root);

	}
	
	
	public static Node buildTree(){
		
		Node A = new Node();
		A.value = "A";
		
		Node B = new Node();
		B.value = "B";
		
		Node C = new Node();
		C.value = "C";
		
		Node D = new Node();
		D.value = "D";
		
		Node E = new Node();
		E.value = "E";
		
		Node F = new Node();
		F.value = "F";
		
		
		A.Lnote = B;
		A.Rnote = E;
		
		B.Lnote = C;
		B.Rnote = D;
		
		E.Rnote = F;
		
		return A;
	}
	
	
	
	
	
	public static void preorder(Node root){
		
		System.out.print(root.value + " ");  //前序遍历
		
		if(root.Lnote != null){			
			preorder(root.Lnote);
		}
		
		if(root.Rnote != null){
			preorder(root.Rnote);
		}
	}
	
	public static void midorder(Node root){

		if(root.Lnote != null){			
			preorder(root.Lnote);
		}
		
		System.out.print(root.value + " ");  //中序遍历
		
		if(root.Rnote != null){
			preorder(root.Rnote);
		}
	}
	
	public static void postorder(Node root){

		if(root.Lnote != null){			
			preorder(root.Lnote);
		}
		
		if(root.Rnote != null){
			preorder(root.Rnote);
		}
		
		System.out.print(root.value + " ");  //后序遍历
	}
	
}
