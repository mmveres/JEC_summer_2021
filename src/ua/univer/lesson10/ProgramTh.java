package ua.univer.lesson10;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Start " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
    }
}

class MyRunnAble implements Runnable {
    @Override
    public void run() {
        System.out.println("Start RunnAble " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());

        System.out.println("End RunnAble " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
    }
}

public class ProgramTh {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
        Thread th1 = new MyThread();
        th1.start();

        new Thread(new MyRunnAble()).start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Start Local " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());

                System.out.println("End Local " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start Anonim Run " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());

                System.out.println("End Anonim Run  " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
            }
        }).start();

        new Thread(
                () -> {
                    System.out.println("Start Lambda " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());

                    System.out.println("End Lambda  " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
                }
        ).start();

        th1.join(75);
        System.out.println("End " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
    }
}
