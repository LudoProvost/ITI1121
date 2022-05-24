import java.util.LinkedHashMap;

/*******************************/
/*Students numbers: 300208450
/*Students full names: Ludovic Provost
/*******************************/

// Class Item with
// label, quantity and price as attributes
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}