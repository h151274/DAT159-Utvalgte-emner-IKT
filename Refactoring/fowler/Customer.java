package dat159.fowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            Movie movie = each.getMovie();
            int daysRented = each.getDaysRented();

            // determine amount for each line
            double thisAmount = movie.determineAmount(daysRented);
            
            // add frequent renter points
            frequentRenterPoints += movie.getFrequentRenterPoints(frequentRenterPoints, daysRented);

            result += showRentalInfo(result, thisAmount, movie);
            totalAmount += thisAmount;
        }
        result = addFooterLines(totalAmount, frequentRenterPoints, result);
        return result;
    }
    
    //show figures for this rental 
	private String showRentalInfo(String result, double thisAmount, Movie movie) {
		return ("\t" + movie.getTitle()+ "\t" + String.valueOf(thisAmount) + "\n"); 
	}
    
    //add footer lines
	private String addFooterLines(double totalAmount, int frequentRenterPoints, String result) {
		return result + ("Amount owed is " + totalAmount + "\n" + "You earned " + frequentRenterPoints +
                " frequent renter points");
	}

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}
