// Class Item with
// label and quantity as attributes
class Item {
  
    private String label;
    private int quantity;
	private float price;	
  
    // Item class constructor
    Item(String label, int quantity, float price)
    {
        this.label = label;
		this.quantity = quantity;
		this.price = price;
	}
    // display() method to display Item information
    public String toString()
    {
        return(this.label + " - " + this.quantity+ " - " + this.price);
    }  
	// your code here
    
	// display() method to display Item label and price
    public String displayItemLabelAndPrice()
    {
        return(this.label + " - " + this.price);
    }  	
	// get the label of an item
	public String getLabel(){
		return label;
	}
	
	// get the quantity of an item
	public int getQuantity(){
		return quantity;
	}	

	// get the price of an item
	public float getPrice(){
		return price;
	}	

	// set the quantity of an item
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}	

	// set the price of an item
	public void setPrice(float price){
		this.price = price;
	}	
}