import model.Customer;

public class Driver {
    public static void main(String[] args) {
        Customer customer;

        try {
            customer = new Customer("first", "second", "j@domain.org");
            System.out.println(customer);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getLocalizedMessage());
        }

    }
}
