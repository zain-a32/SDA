/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmids12;


public class ServicesFilter implements Filter {
    public Client apply(Client client) throws Exception {
        if (!client.getAvailableServices().contains(client.getSelectedService())) {
            throw new Exception("Service " + client.getSelectedService() + " is not available.");
        }
        return client;
    }
}