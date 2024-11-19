/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmids12;

public class PaymentHandler implements Handler {
    private Filter paymentFilter;

    public PaymentHandler() {
        this.paymentFilter = new PaymentFilter();
    }

    @Override
    public Client handle(Client client) throws Exception {
        return paymentFilter.apply(client);
    }
}
public class ServicesHandler implements Handler {
    private Filter servicesFilter;

    public ServicesHandler() {
        this.servicesFilter = new ServicesFilter();
    }

    @Override
    public Client handle(Client client) throws Exception {
        return servicesFilter.apply(client);
    }
}
public interface Observer {
    void update(String message);
}
public class Notification implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }
}
import java.util.ArrayList;
import java.util.List;

public class HostelSystemWithObserver {
    private List<Filter> filters;
    private List<Handler> handlers;
    private List<Observer> observers;

    public HostelSystemWithObserver() {
        this.filters = new ArrayList<>();
        this.handlers = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public Client process(Client client) {
        try {
            // Apply filters through handlers
            for (Handler handler : handlers) {
                client = handler.handle(client);
            }
            // Apply the filters directly
            for (Filter filter : filters) {
                client = filter.apply(client);
            }
            notifyObservers("Client successfully registered.");
            return client;
        } catch (Exception e) {
            notifyObservers("Error: " + e.getMessage());
            return null;
        }
    }
}
public class LabMids12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Client client = new Client(20, true, "Paid", "WiFi", Arrays.asList("WiFi", "AC", "Canteen"));

        // Create the hostel system with observer
        HostelSystemWithObserver hostelSystem = new HostelSystemWithObserver();

        // Create and add an observer (Notification)
        Notification notification = new Notification();
        hostelSystem.addObserver(notification);

        // Add filters
        hostelSystem.addFilter(new EligibilityFilter());
        hostelSystem.addFilter(new PaymentFilter());
        hostelSystem.addFilter(new ServicesFilter());

        // Add handlers
        hostelSystem.addHandler(new EligibilityHandler());
        hostelSystem.addHandler(new PaymentHandler());
        hostelSystem.addHandler(new ServicesHandler());

        // Process the client request
        hostelSystem.process(client);
    }
    
}
