package com.mycompany.riyadhmetromanagmentsystem;

public class Passenger {
    private static int nextId = -1;
    private final int id;
    private final String name;
    private final String machineName;
    private final long arrivalTime;

    public Passenger(int id, String name, String machineName) {
        this.id = nextId++;
        this.name = name;
        this.machineName = machineName;
        this.arrivalTime = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMachineName() {
        return machineName;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Passenger #" + id + " (" + name + ") - Machine: " + machineName;
    }
    
}
