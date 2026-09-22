package com.mycompany.riyadhmetromanagmentsystem;

public class MetroNetwork {
    public CircularLine<Station> line1;
    public CircularLine<Station> line2;
    public CircularLine<Station> line3;

    public MetroNetwork() {
		this.line1 = new CircularLine<Station>();
		line1.addLast(new Station(1001,"Makkah Road", "Orange", ""));//1001
		line1.addLast(new Station(1002,"Prince Turki", "Orange", ""));
		line1.addLast(new Station(1003,"Education City", "Orange", ""));
		line1.addLast(new Station(1004,"Hittin", "Orange", ""));
		line1.addLast(new Station(1005,"Khurais", "Orange", ""));
		
		this.line2 = new CircularLine<Station>();
		line2.addLast(new Station(2001,"Riyadh Park", "Yellow", ""));
		line2.addLast(new Station(2002,"King Salman Park", "Yellow", ""));
		line2.addLast(new Station(2003,"Sports Boulevard", "Yellow", ""));
		line2.addLast(new Station(2004,"Western Ring Road", "Yellow", ""));

		
		this.line3 = new CircularLine<Station>();
		line3.addLast(new Station(3001,"Riyadh Zoo", "Green", ""));
		line3.addLast(new Station(3002,"Malaz", "Green", ""));
		line3.addLast(new Station(3003,"Imam Saud University", "Green", ""));
		line3.addLast(new Station(3004,"Eastern Ring Road", "Green", ""));
	}


    public void addStation(int lineNumber, Station station, boolean atStart) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return;
        if (atStart) line.addFirst(station);
        else line.addLast(station);
    }

    public boolean removeStation(int lineNumber, String stationName) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return false;

        line.moveToStart();
        for (int i = 0; i < line.size(); i++) {
            if (line.getValue().getName().equalsIgnoreCase(stationName)) {
                line.remove(i);
                return true;
            }
            line.next();
        }
        return false;
    }

    public Station findStation(int lineNumber, String stationName) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return null;

        line.moveToStart();
        for (int i = 0; i < line.size(); i++) {
            Station s = line.getValue();
            if (s.getName().equalsIgnoreCase(stationName)) {
                return s;
            }
            line.next();
        }
        return null;
    }

    public void displayLineForward(int lineNumber) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return;

        line.moveToStart();
        for (int i = 0; i < line.size(); i++) {
            System.out.println(line.getValue());
            line.next();
        }
    }

    public void displayLineBackward(int lineNumber) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return;

        line.moveToEnd();
        for (int i = 0; i < line.size(); i++) {
            System.out.println(line.getValue());
            line.prev();
        }
    }

    public int countStations(int lineNumber) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return 0;
        return line.size();
    }

    public int calculateDuration(int lineNumber, String startStation, String endStation) {
        CircularDoublyLinkedList<Station> line = getLine(lineNumber);
        if (line == null) return -1;

        int duration = 0;
        boolean counting = false;

        line.moveToStart();
        for (int i = 0; i < line.size(); i++) {
            Station s = line.getValue();
            if (s.getName().equalsIgnoreCase(startStation)) counting = true;
            if (counting) duration += s.getWaitingMin();
            if (s.getName().equalsIgnoreCase(endStation)) break;
            line.next();
        }
        return duration;
    }
}