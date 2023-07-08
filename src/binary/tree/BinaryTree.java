package binary.tree;

import com.queue.*; // pre-defined package.
import com.stack.*; // pre-defined package

public class BinaryTree <T> {

	private TreeNode<T> root;
	private Queue<TreeNode<T>> q = new Queue<TreeNode<T>>();

	public void insert(T data) {

		TreeNode<T> newNode = new TreeNode<T>(data); // New node to insert in the tree.

		if (this.root == null) {

			this.root = new TreeNode<T>(data);
			q.enqueue(root);
			return;
		}
		else {

			if (q.peek().getLeft() == null) {

				q.peek().setLeft(newNode);
				q.enqueue(q.peek().getLeft());
			}
			else if (q.peek().getRight() == null) {

				q.peek().setRight(newNode);
				q.enqueue(q.peek().getRight());
				q.dequeue();
			}
		}
	}

	public String preTraversal() {

		Stack<TreeNode<T>> stack = new Stack<>();
		stack.push(root);
		String output = "";

		return preTrav(stack, root, output);
	}

	// O(n)
	private String preTrav(Stack<TreeNode<T>> stack, TreeNode<T> root, String output) {

		if (root != null && !stack.isEmpty()) {

			root = stack.pop();

			System.out.println("1");
			output += root.getData() + " ";

			if (root.getRight() != null)
				stack.push(root.getRight());

			if (root.getLeft() != null)
				stack.push(root.getLeft());

			return preTrav(stack, root, output);
		}
		return output;
	}
	public String levelTraversal() {

		Queue<TreeNode<T>> q = new Queue<TreeNode<T>>();
		String data = "";
		q.enqueue(root);
		return levelTrav(q, data);
	}

	private String levelTrav(Queue<TreeNode<T>> q, String output) {

		if (!q.isEmpty()) {

			if (q.peek().getLeft() != null)
				q.enqueue(q.peek().getLeft());

			if (q.peek().getRight() != null)
				q.enqueue(q.peek().getRight());

			output += q.dequeue().getData() + " ";

			return levelTrav(q, output);
		}

		return output;
	}

	public String reverseTree() {

		Queue<TreeNode<T>> q = new Queue<>();
		Stack<T> stack = new Stack<>();
		q.enqueue(root);

		return reverseLevelTrav(q, stack);

	}
	private String reverseLevelTrav(Queue<TreeNode<T>> q, Stack<T> stack) {

		if (!q.isEmpty()) {

			if (q.peek().getLeft() != null)
				q.enqueue(q.peek().getLeft());

			if (q.peek().getRight() != null)
				q.enqueue(q.peek().getRight());

			stack.push(q.dequeue().getData());

			return reverseLevelTrav(q, stack);
		}

		String reversedOutput = "";

		while (!stack.isEmpty()) {

			reversedOutput += stack.pop() + " ";
		}

		return reversedOutput;
	}
	
	public String inOrderTraversal() {

		Stack<TreeNode<T>> stack = new Stack<>();
		String output = "";

		return inTrav(stack, root, output);
	}
	
	private String inTrav(Stack<TreeNode<T>> stack, TreeNode<T> root, String output) {

		if (!stack.isEmpty() || root != null) {

			// Check if root is null/no value.
			if (root != null) {

				if (root.getLeft() != null) {

					stack.push(root);
					root = root.getLeft();
				}
				else {

					output += root.getData() + " ";
					
					if (root.getRight() != null)
						root = root.getRight();
					else
						root = null;
				}
			}
			else {

				output += stack.peek().getData() + " ";

				if (stack.peek().getRight() != null	) 
					root = stack.peek().getRight();
		
				stack.pop();
			}
			
			return inTrav(stack, root, output);
		}
		return output;
	}

	public static void main(String[] args) {

		BinaryTree<Integer> bt = new BinaryTree<Integer>();

		bt.insert(12);
		bt.insert(13);
		bt.insert(14);
		bt.insert(15);
		bt.insert(16);
		bt.insert(17);
		bt.insert(18);
		bt.insert(19);
		System.out.println("PRE TRAVERSAL: " + bt.preTraversal());	
	}
}