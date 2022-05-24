/*******************************/
/*Students numbers: 
/*Students full names: 
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
	
	//your code here
}