package com.mycompany.riyadhmetromanagmentsystem;

public class CircularLine<E> {
    
    private Node<E> tail = null; 
    private Node<E> curr = null; 
    private int size = 0;        

    public CircularLine() {
        
    }

   
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement(); 
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement(); 
    }

    
    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void rotateBack() {
        if (tail != null)
            tail = tail.getPrev();
    }

    
    public void moveToStart() {
        if (isEmpty()) curr = null;
        else curr = tail.getNext(); 
    }

    public void moveToEnd() {
        curr = tail;
    }

    public void next() {
        if (curr != null) curr = curr.getNext();
    }

    public void prev() {
        if (curr != null) curr = curr.getPrev();
    }

    public E getValue() {
        if (curr == null) return null;
        return curr.getElement();
    }

    

  
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    
    private E removeBetween(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        
        
        if (curr == node) {
            curr = successor; 
        }
        
        return node.getElement();
    }

    

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e);
            tail.setNext(tail);
            tail.setPrev(tail);
            size++;
        } else {
            addBetween(e, tail, tail.getNext());
        }
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext(); // rotate
    }

    
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
           
            Node<E> temp = tail.getNext(); 
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            
            addBetween(element, temp, temp.getNext());
        }
    }

   

    public E removeFirst() {
        if (isEmpty()) return null;
        
        Node<E> head = tail.getNext();
        if (head == tail) { 
            tail = null;
            size--;
            return head.getElement();
        }
        return removeBetween(head);
    }

    public E removeLast() {
        if (isEmpty()) return null;
        
        Node<E> oldTail = tail;
        if (oldTail == oldTail.getNext()) { 
            tail = null;
            size--;
            return oldTail.getElement();
        }
        
       
        rotateBack(); 
        return removeBetween(oldTail);
    }

    
    public E remove(int index) {
        if (index < 0 || index >= size) { // تأكد أن الاندكس صالح
            System.out.println("Invalid Index");
            return null;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            
            Node<E> target = tail.getNext(); 
            for (int i = 0; i < index; i++) {
                target = target.getNext();
            }
            
            return removeBetween(target);
        }
    }

    

    public void print() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<E> temp = tail.getNext();
        do {
            if (temp == tail)
                System.out.print(temp.getElement());
            else
                System.out.print(temp.getElement() + " -> ");
            temp = temp.getNext();
        } while (temp != tail.getNext());
        System.out.println();
    }
    
    public void printBackward() {
        if(isEmpty()) {
        	System.out.println("List is empty");
        	return;
        }
        Node temp = tail;
        do {
        	System.out.print(temp.getElement()+"->");
        	temp = temp.getPrev();
        }while(temp != tail);
    }

    public void printFromTo(int from, int to) {
        if (isEmpty() || from > to || from < 1 || to > size) {
            return;
        }

        Node<E> temp = tail.getNext(); 
        int count = 1;

        do {
            if (count >= from && count <= to) {
                System.out.println("Pos " + count + ": " + temp.getElement());
            }
            temp = temp.getNext();
            count++;
        } while (count <= to && temp != tail.getNext());
    }
    
   
    public boolean search(E value) {
        if (isEmpty()) return false;
        
        Node<E> currSearch = tail.getNext(); 
        do {
            if (currSearch.getElement().equals(value)) 
                return true;
            currSearch = currSearch.getNext();
        } while (currSearch != tail.getNext());
        
        return false;
    }
    
    public void addBetweenStation(int id1 , int id2 , E obj) {
    	if(id1 > id2) {
    		System.out.println("Check your id");
    		return;
    	}
    	
    	Node temp1 = tail.getNext();
    	boolean isFound = false;
    	do {
    		if(( (Station)temp1.getElement()).getId() == id1 ) {
    			isFound = true;
    			break;
    		}
    		temp1 = temp1.getNext();
    	}while(temp1 != tail.getNext());
    	
    	if(isFound == false) {
    		System.out.println("we don't found station id: "+id1);
    		return;
    	}
    	
    	Node temp2 = tail.getNext();
    	isFound = false;
    	do {
    		if( ( (Station)temp2.getElement()).getId() == id2 ) {
    			isFound = true;
    			break;
    		}
    		temp2 = temp2.getNext();
    	}while(temp2 != tail.getNext());
    	
    	if(isFound == false) {
    		System.out.println("we don't found station id: "+id2);
    		return;
    	}
    	
    	if(temp1.getNext() == temp2) {
    		addBetween(obj, temp1, temp2);
    	}else {
    		System.out.println("Sorry, the two stations are not next to each other.");
    	}
    	
    }
    
    public void searchID(int id) {
    	Node temp = tail.getNext();// head;
    	boolean isFound = false;
    	do {
    		if( (  (Station) temp.getElement()).getId() == id  ) {
    			isFound = true;
    			break;
    		}
    		
    		temp = temp.getNext();
    	}while(temp != tail.getNext());
    	
    	if(isFound == true) {
    		System.out.println("We found the station: ");
    		System.out.println(temp.getElement());
    	}else
    		System.out.println("we don't found it :( ");
    }
    
    public void Shortest_Route(int id1 , int id2) {
    	
    	Node curr = tail.getNext();
    	boolean isFound = false;
    	do {
    		if(( (Station)curr.getElement() ).getId() == id1) {
    			isFound = true;
    			break;
    		}
    		curr = curr.getNext();
    	}while(curr != tail.getNext());
    	
    	if(isFound == false) {
    		System.out.println("Wrong ID: "+id1);
    		return;
    	}
    	
    	Node curr2 = tail.getNext();
    	isFound = false;
    	do {
    		if( ( (Station) curr2.getElement() ).getId() == id2 ) {
    			isFound = true;
    			break;
    		}
    		curr2 = curr2.getNext();
    	}while(curr2 != tail.getNext());
    	if(isFound == false) {
    		System.out.println("Wrong ID: "+id2);
    		return;
    	}
    	
    	Node temp = curr;
    	int timeFoward = 0;
    	do {
    		timeFoward += 2;
    		temp = temp.getNext();
    	}while(temp != curr2);
    	
    	temp = curr;
    	int timeBackward = 0;
    	do {
    		timeBackward += 2;
    		temp = temp.getPrev();
    	}while(temp != curr2);
    	
    	if(timeBackward < timeFoward) {
    		temp = curr;
        	
        	do {
        		System.out.print(temp.getElement() + "-> ");
        		temp = temp.getPrev();
        	}while(temp != curr2);
        	System.out.println("total Time is: "+timeBackward);
    	}else {
    		temp = curr;
        	
        	do {
        		System.out.print(temp.getElement() + "-> ");
        		temp = temp.getNext();
        	}while(temp != curr2);
        	System.out.println("total Time is: "+timeFoward);
    	}
    }
    
    public void avg_time(int id1 , int id2) {
    	Node station1 = pos_Id(id1);
    	Node station2 = pos_Id(id2);
    	
    	if(station1 == null || station2 == null) {
    		System.out.println("please check your id ");
    		return;
    	}
    	
    	int time = 0;
    	Node curr = station1;
    	do {
    		time += 2;
    		curr = curr.getNext();
    	}while(curr != station2);
    	
    	System.out.println("The total time for forward is: "+time);
    	
    	time = 0;
    	curr = station1;
    	do {
    		time += 2;
    		curr = curr.getPrev();
    	}while(curr != station2);
    	System.out.println("The total time for BackWard is: "+time);
    }
    
    private Node pos_Id(int id) {
    	Node temp = tail.getNext();
    	boolean isFound = false;
    	do {
    		if( ( (Station) temp.getElement() ).getId() == id) {
    			isFound = true;
    			break;
    		}
			temp = temp.getNext();
    	}while(temp != tail.getNext());
    	
    	if(isFound == true)
    		return temp;
    	else
    		return null;
    }
    
}
