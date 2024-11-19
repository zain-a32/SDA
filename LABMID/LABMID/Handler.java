/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmids12;

/**
 *
 * @author FA21-BSE-166
 */
public interface Handler {
    Client handle(Client client) throws Exception;
}