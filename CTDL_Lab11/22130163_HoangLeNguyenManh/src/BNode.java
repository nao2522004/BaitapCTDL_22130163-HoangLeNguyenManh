import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	// Add element e into BST
	public void add(E e) {
		if (e.compareTo(data) > 0) {
			if (this.right == null) {
				this.right = new BNode<>(e);
			} else {
				this.right.add(e);
			}
		} else if (e.compareTo(data) < 0) {
			if (this.left == null) {
				this.left = new BNode<>(e);
			} else {
				this.left.add(e);
			}
		} else if (e.compareTo(data) == 0) {
			BNode<E> newNode = new BNode<>(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		int comp = node.compareTo(data);
		if (comp > 0 && this.right != null) {
			int rightDepth = this.right.depth(node);
			return rightDepth + 1;
		} else if (comp < 0 && this.left != null) {
			int leftDepth = this.left.depth(node);
			return leftDepth + 1;
		} else if (comp == 0) {
			return 0;
		}
		return -1;
	}

	// compute the height of BST
	public int height() {
		int leftHeight = (this.left != null) ? this.left.height() : -1;
		int rightHeight = (this.right != null) ? this.right.height() : -1;

		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Compute total nodes in BST
	public int size() {
		int leftSize = (this.left != null) ? this.left.size() : 0;
		int rightSize = (this.right != null) ? this.right.size() : 0;
		return leftSize + rightSize + 1;
	}

	public boolean contains(E e) {
		int compareResult = e.compareTo(data);

		if (compareResult == 0) {
			return true;
		} else if (compareResult < 0 && this.left != null) {
			return this.left.contains(e);
		} else if (compareResult > 0 && this.right != null) {
			return this.right.contains(e);
		}

		return false;
	}

	// Find the minimum element in BST
	public E findMin() {
		if (this.left == null) {
			return this.data;
		}
		BNode<E> currentNode = this;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.data;
	}

	// Find the maximum element in BST
	public E findMax() {
		if (this.right == null) {
			return this.data;
		}
		BNode<E> currentNode = this;
		while (currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return currentNode.data;

	}

	// Remove element e from BST
	public boolean remove(E e) {
		BNode<E> newRoot = removeNode(e);
		if (newRoot != null) {
			this.data = newRoot.data;
			this.left = newRoot.left;
			this.right = newRoot.right;
			return true;
		}
		return false;
	}

	// Xóa phần tử e khỏi BST
	public BNode<E> removeNode(E e) {
		// Tìm node cần xóa
		if (e.compareTo(data) < 0) {
			this.left = (left != null) ? left.removeNode(e) : null;
		} else if (e.compareTo(data) > 0) {
			this.right = (right != null) ? right.removeNode(e) : null;
		} else {
			// e == data, xóa data

			// Trường hợp 1: Data là nút lá
			if (this.left == null && this.right == null) {
				return null;
			}

			// Trường hợp 2: Chỉ có một con bên trái
			if (this.left != null && this.right == null) {
				return this.left;
			}

			// Trường hợp 3: Chỉ có một con bên phải
			if (this.left == null && this.right != null) {
				return this.right;
			}

			// Trường hợp 4: Data là nút có 2 con
			// Tìm node trái nhất của cây con bên phải
			BNode<E> leftMostNode = this.right.findLeftMostNode();

			// Thay thế data của nút hiện tại bằng data của leftMostNode
			this.data = leftMostNode.getData();

			// Loại bỏ leftMostNode từ cây con bên phải
			this.right = this.right.removeNode(leftMostNode.getData());
		}
		return this;
	}

	public BNode<E> findLeftMostNode() {
		BNode<E> leftMostNode = this;
		while (leftMostNode.left != null) {
			leftMostNode = leftMostNode.left;
		}
		return leftMostNode;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		collectDescendants(this, data, descendantsList);
		return descendantsList;
	}

	private void collectDescendants(BNode<E> currentNode, E targetData, List<E> descendantsList) {
		if (currentNode != null) {
			int comp = targetData.compareTo(currentNode.getData());

			if (comp < 0) {
				// Target data is in the left subtree
				collectDescendants(currentNode.getLeft(), targetData, descendantsList);
			} else if (comp > 0) {
				// Target data is in the right subtree
				collectDescendants(currentNode.getRight(), targetData, descendantsList);
			} else {
				// Found the target node
				addDescendants(currentNode.getLeft(), descendantsList);
				addDescendants(currentNode.getRight(), descendantsList);
			}
		}
	}

	private void addDescendants(BNode<E> node, List<E> descendantsList) {
		if (node != null) {
			descendantsList.add(node.getData());
			addDescendants(node.getLeft(), descendantsList);
			addDescendants(node.getRight(), descendantsList);
		}
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		int comp = data.compareTo(this.data);
		List<E> ancestor = new ArrayList<>();
		if (comp == 0)
			return ancestor;
		if (this.left != null) {
			if (this.left.contains(data)) {
				ancestor.addAll(this.left.ancestors(data));
				ancestor.add(this.data);
			}
		}
		if (this.right != null) {
			if (this.right.contains(data)) {
				ancestor.addAll(this.right.ancestors(data));
				ancestor.add(this.data);
			}
		}
		return ancestor;
	}

	// display BST using inorder approach
	public void inorder() {
		if (this.left != null)
			this.left.inorder();
		System.out.print(this.data + " ");
		if (this.right != null)
			this.right.inorder();
	}

	public void preorder() {
		System.out.print(this.data + " ");
		if (this.left != null)
			this.left.preorder();
		if (this.right != null)
			this.right.preorder();
	}

	// display BST using postorder approach
	public void postorder() {
		if (this.left != null)
			this.left.postorder();
		if (this.right != null)
			this.right.postorder();
		System.out.print(this.data + " ");
	}
}
