package com.mycompany.riyadhmetromanagmentsystem;

public class MaintenanceSystem {
    private AHeap<Integer, MaintenanceRequest> heap;

    public MaintenanceSystem() {
        heap = new AHeap<Integer, MaintenanceRequest>(1000);
    }
    
    public void Submit(MaintenanceRequest request){
        heap.insert(request.getPriority(), request);
    }
    
    public void Assign(){
        if(heap.isEmpty()){
            System.out.println("Sorry there is no request ");
            return;
        }
        AHNode obj = heap.removemax();
        System.out.println("Request is aaigned to team "+ obj.getValue());
    }
    
    public void viewMostCritical(){
        if(heap.isEmpty()){
            System.out.println("Sorry there is no request ");
            return;
        }
        System.out.println(heap.max());
    }
    
    public void display(){
        if(heap.isEmpty()){
            System.out.println("Sorry there is no request ");
            return;
        }
        AHeap<Integer, MaintenanceRequest> temp = new AHeap<Integer, MaintenanceRequest>(1000);
        
        while(!heap.isEmpty()){
            System.out.println(heap.max());
            AHNode<Integer, MaintenanceRequest> obj = heap.removemax();
            temp.insert(obj.getKey(), obj.getValue());
        }
        while(!temp.isEmpty()){
            System.out.println(heap.max());
            AHNode<Integer, MaintenanceRequest> obj = temp.removemax();
            heap.insert(obj.getKey(), obj.getValue());
        }
    }
    
    public void UpdatePriority(String name, int key){
        AHeap<Integer, MaintenanceRequest> temp = new AHeap<Integer, MaintenanceRequest>(1000);
        AHNode<Integer, MaintenanceRequest> update = null;
        while(!heap.isEmpty()){
            if(heap.max().getValue().getTitle().equalsIgnoreCase(name)){
            update = heap.max();
            heap.removemax();
            }else{
                AHNode<Integer, MaintenanceRequest> obj= heap.removemax();
                temp.insert(obj.getKey(), obj.getValue());
            }
        }
        while(!temp.isEmpty()){
            
                AHNode<Integer, MaintenanceRequest> obj= temp.removemax();
                heap.insert(obj.getKey(), obj.getValue());
        }
        if(update != null){
            update.setKey(key); 
        }
        heap.insert(update.getKey(), update.getValue());
    }
}
