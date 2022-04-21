package task;

import java.util.ArrayList;
import java.util.List;

class ThreadPush extends Thread{
	List<Integer> stack;
    ThreadPush(List<Integer> stack){
        this.stack =stack;
    }
    static  int max =10;
    
    public void run() {
        while (true) {
            if(stack.size()<=10) {
                stack.add(10);
            }
            if (stack.size() == max) {
            	System.out.println("Stack is Full");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.print("Push:");
            System.out.println(stack);        
        }
    }
}

class ThreadPop extends Thread{
	List<Integer> stack;
    ThreadPop(List<Integer> stack){
        this.stack =stack;
    }
    
    public void run() {
    	while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!stack.isEmpty()) {
                stack.remove(0);
                
            }
            if(stack.isEmpty()){
                System.out.println("Stack is Empty");
                return;
            }
            System.out.print("Pop:");
            System.out.println(stack);
        }
    }
}

public class StackWithThread {

	public static void main(String[] args) {
		 ArrayList<Integer> stack = new ArrayList<>();

		 	ThreadPush thread1 = new ThreadPush(stack);
	        thread1.start();
	
	        ThreadPop thread2 = new ThreadPop(stack);
	        thread2.start();
	}
}
