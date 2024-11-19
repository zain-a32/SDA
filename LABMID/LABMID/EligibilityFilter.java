/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmids12;

/**
 *
 * @author fa21-bse-166
 */
public class EligibilityFilter implements Filter {
    public Client apply(Client client) throws Exception {
        if (client.getAge() < 18) {
            throw new Exception("Client is underage.");
        }
        if (!client.getIsStudent()) {
            throw new Exception("Client must be a student.");
        }
        return client;
    }
}
