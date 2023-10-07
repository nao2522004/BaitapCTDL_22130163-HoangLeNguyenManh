
public class OrderItem {
	private Product p;
	private int quantity;
	public OrderItem(Product p, int quantity) {
		super();
		this.p = p;
		this.quantity = quantity;
	}
	public Product getP() {
		return p;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getSubtotal() {
		return p.getPrice()*quantity;
	}
	


}
