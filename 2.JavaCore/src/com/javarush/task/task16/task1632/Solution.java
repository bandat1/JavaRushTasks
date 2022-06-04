package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new ThreadOne());
//        ThreadTwo th2 = new ThreadTwo();
        threads.add(new ThreadTwo());
//        ThreadThree th3 = new ThreadThree();
        threads.add(new ThreadThree());
//        ThreadFour th4 = new ThreadFour();
        threads.add(new ThreadFour());
//        ThreadFive th5 = new ThreadFive();
        threads.add(new ThreadFive());
    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            while (true) {
                    System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {

        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (!interrupted()) {}
        }
    }

    public static class ThreadFive extends Thread {
        @Override
        public void run() {
            int count = 0;
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));)
            {
                
                while (true) {
                    String s = bf.readLine();
                    if(s.equals("N")) {
                        break;
                    }
                    count += Integer.parseInt(s);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println(count);
        }



    public static void main(String[] args) {
        }
    }
}