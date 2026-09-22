
package com.mycompany.riyadhmetromanagmentsystem;
public class TicketingSystem {
    
    private ArrayQueue<Passenger> machinesQueues;
    
    public TicketingSystem(){
        machinesQueues = new ArrayQueue<Passenger>();
    }
    
    public void addPassenger(Passenger p){
        machinesQueues.enqueue(p);
    }
    
    public Passenger serveNext(){
        if(machinesQueues.isEmpty()){
            System.out.println("No Passenger to serve ");
            return null;
        }
        return machinesQueues.dequeue();
    }
    
    public Passenger peek(){
        if(machinesQueues.isEmpty()){
            System.out.println("No Passenger waithing ");
            return null;
        }
        return machinesQueues.first();
    }
    
    public void displayAll(){
        machinesQueues.display();
    }
    
    public int getCount(){
        return machinesQueues.size();
    }
    
    public double getAvgWathingTime(){
        int count = machinesQueues.size();
        return count*2.0;
    }
}
