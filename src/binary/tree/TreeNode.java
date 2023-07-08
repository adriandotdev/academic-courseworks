package binary.tree;

public class TreeNode <T> {

	private TreeNode<T> left;
	private TreeNode<T> right;
	private T data;
	
	public TreeNode(T data) {
		
		this.data = data;
	}
	
	public void setLeft(TreeNode<T> left) {
		
		this.left = left;
	}
	
	public void setRight(TreeNode<T> right) {
		
		this.right = right;
	}
	
	public TreeNode<T> getLeft() {
		
		return this.left;
	}
	
	public TreeNode<T> getRight() {
		
		return this.right;
	}
	
	public T getData() {
		
		return this.data;
	}
}