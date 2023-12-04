import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			this.root = new BNode<>(e);
		} else {
			this.root.add(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}

		if (root.contains(e)) {
			root.remove(e);
			return true;
		}

		return false;
	}

	// Compute the depth of a node in BST
	public int depth(E node) {
		if (root != null) {
			return root.depth(node);
		} 
		return -1; // or some sentinel value indicating the node is not found
	}

	// Compute the height of BST
	public int height() {
		if (root == null)
			return -1;
		return root.height();
	}

	// Compute total nodes in BST
	public int size() {
		if (root != null) {
			return root.size();
		}
		return -1;
	}

	// Check if BST contains element e
	public boolean contains(E e) {
		if (root != null) {
			return root.contains(e);
		}
		return false;
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root != null) {
			return root.findMin();
		}
		return null;
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root != null) {
			return root.findMax();
		}
		return null;
	}

	// Get the ancestors of a node
	public List<E> ancestors(E data) {
		if (root == null) {
			// Cây rỗng, trả về danh sách rỗng
			return null;
		}

		return root.ancestors(data);
	}

	// Get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null) {
			// Cây rỗng, trả về danh sách rỗng
			return null;
		}

		return root.descendants(data);
	}

	// In-order traversal
	public void inorder() {
		root.inorder();
		System.out.println();
	}

	// display BST using preorder approach
	public void preorder() {
		root.preorder();
		System.out.println();
	}

	// display BST using postorder approach
	public void postorder() {
		root.postorder();
		System.out.println();
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(15); // root
		bst.add(10);
		bst.add(4);
		bst.add(12);
		bst.add(22);
		bst.add(18);
		bst.add(24);
		BST<Integer> bst1 = new BST<>();
		bst1.add(15);
		bst1.add(10);
		bst1.add(4);
		bst1.add(12);
		bst1.add(22);
		bst1.add(18);
		bst1.add(24);

		// test add and preorder
		System.out.println("Pre-order Traversal:");
		bst.preorder();

		// test add and postorder
		System.out.println("Post-order Traversal:");
		bst.postorder();

		// Test add and in-order traversal
		System.out.println("In-order Traversal:");
		bst.inorder();

		// Test remove
		System.out.println("\nRemoved 4 ?: " + bst1.remove(4));
		System.out.println("Removed 30 ?: " + bst1.remove(30));
		System.out.println("In-order Traversal after removal:");
		bst1.inorder();

		// Test depth
		System.out.println("Depth of 15: " + bst.depth(15));
		System.out.println("Depth of 4: " + bst.depth(4));

		// Test height
		System.out.println("Height of BST: " + bst.height());

		// Test size
		System.out.println("Size of BST: " + bst.size());

		// Test contains
		System.out.println("Contains 22? " + bst.contains(22));
		System.out.println("Contains 25? " + bst.contains(25));

		// Test findMin and findMax
		System.out.println("Min: " + bst.findMin());
		System.out.println("Max: " + bst.findMax());

		// Test ancestors
		System.out.println("Ancestors of 18: " + bst.ancestors(18));

		// Test descendants
		System.out.println("Descendants of 15: " + bst.descendants(15));
	}
}
