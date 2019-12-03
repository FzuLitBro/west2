package homework2.second;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  HelloWorld {
    private int n;
    int flag=1;
    private static Lock lock = new ReentrantLock();
    public HelloWorld( int n){
        this.n = n;
    }

    public void hello() throws InterruptedException{
        for (int i = 0; i < n;) {
            try {
                lock.lock();
                while (flag%2==1) {
                    System.out.print("Hello");
                    flag++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void world() throws InterruptedException{
        for (int i = 0; i < n;) {
            try {
                lock.lock();
                while (flag%2==0) {
                    System.out.println("World!");
                    flag++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

}

class PrintWorld implements Runnable{
    HelloWorld helloWorld;
    public PrintWorld(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    HelloWorld helloWorld;
    public PrintHello(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HelloWorld helloWorld = new HelloWorld(n);
        PrintHello printHello = new PrintHello(helloWorld);
        PrintWorld printWorld = new PrintWorld(helloWorld);
        new Thread(printHello).start();
        new Thread(printWorld).start();
    }
}

