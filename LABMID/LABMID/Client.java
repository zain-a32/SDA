/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmids12;

import java.util.List;

/**
 *
 * @author FA21-BSE-166
 */
public class Client {
    private int age;
    private boolean isStudent;
    private String paymentStatus;
    private String selectedService;
    private List<String> availableServices;

    public Client(int age, boolean isStudent, String paymentStatus, String selectedService, List<String> availableServices) {
        this.age = age;
        this.isStudent = isStudent;
        this.paymentStatus = paymentStatus;
        this.selectedService = selectedService;
        this.availableServices = availableServices;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsStudent() {
        return isStudent;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getSelectedService() {
        return selectedService;
    }

    public List<String> getAvailableServices() {
        return availableServices;
    }
}