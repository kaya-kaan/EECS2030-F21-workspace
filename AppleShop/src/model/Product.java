package model;

public class Product {

	private String model;
	private String finish;
	private int storage;
	private boolean hasCellularConnectivity;
	private double originalPrice;
	private double discountValue;
	
	public Product() {
		
	}
	
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice;
	}
	
	/*accessors*/
	
	public String getModel() {
		return this.model;
	}
	
	
	/*mutators*/
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public boolean hasCellularConnectivity() {
		return hasCellularConnectivity;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double getPrice() {
		double price = 0.0;
		double originalPrice = 0.0;
		
		price = this.originalPrice - discountValue;
		
		return price;
	}
	
	public String toString() {
		String s = "";
		
//		StringBuilder sb = new StringBuilder();
//		sb.append(model + " " + finish + " " + storage + "GB" 
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $(" 
//				+ String.format("%.2f",  originalPrice) + " - " + String.format("%.2f",  discountValue) + ")");
//		
//		s = sb.toString();
		
		
		s += model + " " + finish + " " + storage + "GB " 
				+ "(cellular connectivity: " + hasCellularConnectivity + "): $(" 
				+ String.format("%.2f",  originalPrice) + " - " + String.format("%.2f",  discountValue) + ")";
		
		
//		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)", 
//				this.model, this.finish, this.storage, this.hasCellularConnectivity, this.originalPrice, this.discountValue);
		
		
		return s;
	}
	
}
