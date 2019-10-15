package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	// ATTRIBUTES
	private Client client;
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();

	// CONSTRUCTORS
	public Order() {

	}

	public Order(Client client, Date moment, OrderStatus status) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}

	// METHODS
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItens() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double total = 0;
		for (OrderItem item : items) {
			total += item.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("ORDER SUMMARY:\n");
		str.append("Order moment: " + sdf.format(moment) + "\n");
		str.append("Order status: " + status + "\n");
		str.append("Client: " + client + "\n");
		str.append("Order items:\n");
		for(OrderItem item : items) {
			str.append(item + "\n");
		}
		str.append("Total price: $" + total());
		
		return str.toString();
	}

}
