package axp170019;

/*
 * axp170019 - Aarya vardhan reddy paakaala
 * sxs180104 - Shivaprakash Sivagurunathan
 */

import java.util.Scanner;  // import Scanner class

public class BoundedQueue<T>{
    
    private int rear;  // rear pointer to add new elements
    private int front; // front pointer to remove elements
    private int capacity; // Capacity of the Bounded queue
    private Object[] queue;  // Object array to store Queue elements
	
    //Constructor with queue of given size
	public BoundedQueue(int size) {
		rear = -1;
		front=-1;
		capacity = size;
		queue= new Object[size];
		
		}
	

	//Adds element at the rear position of the queue
	public boolean offer(T x) {

		if(capacity==size()) //if queue is full, return false
	    	return false;
		
		if(!isEmpty()) {    // If queue is not empty
			rear = (rear+1)%capacity;
		}
		else {
		// If queue is empty
			front=0;
			rear=0;
		}
		
		// Add the new element at rear position
		queue[rear] = x;
		return true;	
	}

	// Removes the element at front position of the queue
	public T poll() {
		if(isEmpty())
			return null;  // queue is empty
		
		//remove first element
		T t = (T)queue[front];
		
		if(front==rear) {
			front=-1;
			rear = -1;
		}
		else {
			front = (front+1)%capacity; //updating front
		}
		return t;
	}
	
	
	// Returns the front element in the queue
	public T peek() {
		if(isEmpty())
			return null;
		
		return (T)queue[front];
		}

	
	// returns the size of the queue
	public int size() {
		if(front==-1 && rear==-1)
			return 0;
		else if(front<=rear)
			return rear-front+1;
		else
			return capacity - front+rear+1;   // front > rear 
	}

	
	// returns if the queue is empty or not
	public boolean isEmpty() {
		if(front==-1 && rear==-1)
			return true;
		else
			return false;
	}

	
	// deletes the elements of the queue and initializes the queue to default state
	public void clear() {
		
			front=-1;
			rear=-1;
	}

	// copy the queue elements to a ArrayList in queue order
	public void toArray(T[] a) {
		if (isEmpty()) {
			System.out.println("Bounded queue is empty!");
		} 
		
		else {
			int current = front;
			for (int i = 0; i < size(); i++) {
				a[i] = (T) queue[(current+i) % capacity];
			}
		}
	}
	
	
	
	//main function
	public static void main(String args[])
    {
		int n = 10;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]); // input size from command line
		}

		BoundedQueue<Integer> q = new BoundedQueue<>(n);
		Scanner in = new Scanner(System.in);

		System.out.println(" 1 - Offer; 2- Poll; 3- Peek; 4-Size; 5-isEmpty; 6-Clear; 7-toArray");
		
		whileloop: while (in.hasNext()) {
			int com = in.nextInt();
			switch (com) {
			case 1: // Offer
				System.out.print("Enter element to add: ");
				if(q.offer(in.nextInt()))
					System.out.println("true");
				else
					System.out.println("false");
				break;
			case 2: // Poll 
				System.out.println("Element removed: " + q.poll());
				break;
			case 3: // Peek
				System.out.println("Peek: " + q.peek());
				break;
			case 4: // Size
				System.out.println("Size: " + q.size());
				break;
			case 5: // isEmpty
				System.out.println("isEmpty : " + q.isEmpty());
				break;
			case 6: // Clear
				q.clear();
				System.out.println("Queue cleared!");
				break;
			case 7: // toArray
				Integer[] arr = new Integer[q.size()]; 
				q.toArray(arr);
				for (int i = 0; i < q.size(); i++)
					System.out.print("" + arr[i] + " ");
				System.out.println(" ");
				break;
			default: // Exit loop
				break whileloop;
			}
    }   
}
}
