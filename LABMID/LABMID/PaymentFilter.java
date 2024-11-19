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
public class PaymentFilter implements Filter {
    @Override
    public Client apply(Client client) throws Exception {
        if (!"Paid".equals(client.getPaymentStatus())) {
            throw new Exception("Payment is not completed.");
        }
        return client;
    }
}