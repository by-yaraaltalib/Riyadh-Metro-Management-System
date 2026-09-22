package com.mycompany.riyadhmetromanagmentsystem;


public  class AHeap <Key extends Comparable <Key> , E>{//MAX HEAP
	AHNode <Key , E> [] a;
	int size;
	int maxsize;//max array size

	public AHeap(int k) {
		maxsize=k;
		a = new AHNode [maxsize];
		size = -1;
	}

//---------------------Max-----------------------
public AHNode <Key , E> max (){
	if (isEmpty())
	return null;
	else 
	return a[0];//get root "max heap"
} 


//------------------insert-----------------------
public void insert (Key key , E data ){
	AHNode <Key , E> newNode = new AHNode <Key , E>(key , data);//new node

	if (size+1 <maxsize){//find empty solt
		size++;
		a[size]=newNode;
		upheap(size);
	}
}
public void upheap (int p){
	// 10 , 3 , 5
	// 0 , 1 , 2
	while (p>0){     
		// p=2
		int pp=parent(p); // pp= 0

		if (a[p].getKey().compareTo(a[pp].getKey())<0)// correct order
		break;

		AHNode <Key , E> temp =a[p];
		a[p]=a[pp];
		a[pp]=temp;

		p=pp;//p=0
	}
}


//------------------Remove max ----------------------	

public AHNode <Key , E> removemax(){
	if (isEmpty())
	return null;

	AHNode <Key , E> m = a[0];
	a[0]=a[size];
	size--;
	downheap(0);

	return m;
}
public void downheap(int p){
	while (hasLeft(p)){
		int lp= left(p);
		int m =lp;
		if (hasRight(p)){
			int rp=right(p);
			if (a[rp].getKey().compareTo(a[lp].getKey())>0)
			m=rp;
		}
		if (a[p].getKey().compareTo(a[m].getKey())>0)// correct order
		break;

		AHNode <Key , E> temp =a[p];
		a[p]=a[m];
		a[m]=temp;
		p=m;

	}
}

	//-----------------------------------------------------

	public int size() {
		return size + 1;
	}

	public boolean isEmpty() {
		if (size == -1) return true;
		return false;
	}

	public int left(int p) {
		return 2 * p + 1;
	}

	public int right(int p) {
		return 2 * p + 2;
	}

	public int parent(int p) {
		return (p - 1) / 2;
	}
	public boolean hasLeft(int p) {
		if (2 * p +  1 <= size) return true;
		return false;
	}

	public boolean hasRight(int p) {
		if (2 * p +  2 <= size) return true;
		return false;
	}

	public void print() {
		for (int i = 0; i <= size; i++) {
			System.out.println("a[" + i + "]: k = " + a[i].getKey() + ", v = " + a[i].getValue());
		}
	}

	
}
