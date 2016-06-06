/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.util.LinkedList;
import java.util.TimerTask;

/**

 @author Arko
 */
public class Customer extends TimerTask
{
 LinkedList<Integer> ticketQueue=new LinkedList<>();
    // Variable declaration.
    int ticketNumber = 0;
    
    /**
    Generate ticket number that are popped into the queue.
    */
    public void generateTicket()
    {
        ++ticketNumber;
        ticketQueue.add(ticketNumber);
    }
    
    /**
    Deletes the first ticket in the queue.
    */
    public void deleteTicket()
    {
        ticketQueue.remove(0);
    }
    
    @Override
    /**
    Displays the ticket number.
    */
    public void run()
    {
        System.out.println(ticketNumber);
    }   
}
