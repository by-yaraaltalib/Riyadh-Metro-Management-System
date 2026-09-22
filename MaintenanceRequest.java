package com.mycompany.riyadhmetromanagmentsystem;
import java.time.LocalDateTime;
public class MaintenanceRequest {
    
    private String title;
    private String description;
    private int priority; // 1=Low,2=Medium,3=High,4=Critical using MAX heap 
    private final long createdAt;

    public MaintenanceRequest(String title, String description, int priority, long createdAt) {
        
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createdAt = System.currentTimeMillis();
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    public String toString() {
        return "Title : " + title +
               " | Priority: " + priority +
               " | Time: " + createdAt +
               " | Desc: " + description;
    }
}
