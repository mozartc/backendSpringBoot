package com.aliyun.dao;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo{
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        /*1.继承Thread类，重写run方法
    　　每次创建一个新的线程，都要新建一个Thread子类的对象
    　　启动线程，new Thread子类（）.start（）
    　　创建线程实际调用的是父类Thread空参的构造器*/

//        for(int i=0;i<1000;i++){
//            new ExtendsThread().start();
//        }

        /*2.实现Runnable接口，重写run方法
    　　不论创建多少个线程，只需要创建一个Runnable接口实现类的对象
    　　启动线程，new Thread（Runnable接口实现类的对象）.start()
     　 创建线程调用的是Thread类Runable类型参数的构造器*/

//        Runnable implRunnable = new ImplRunnable();
//        for(int i=0;i<10;i++){
//            new Thread(implRunnable).start();
//        }

        /*3.实现Callable接口，重写call方法（有返回值）
    　　自定义类实现Callable接口时，必须指定泛型，该泛型即返回值的类型
    　　每次创建一个新的线程，都要创建一个新的Callable接口的实现类、
    　　如何启动线程？
    　　　　（1）创建一个Callable接口的实现类的对象
    　　　　（2）创建一个FutureTask对象，传入Callable类型的参数
    　　　　　　　　public FutureTask(Callable<V> callable){……}
    　　　　（3）调用Thread类重载的参数为Runnable的构造器创建Thread对象
    　　　　　　　　将FutureTask作为参数传递
    　　　　　　　　public class FutureTask<V> implements RunnableFuture<V>
    　　　　　　　　public interface RunnableFuture<V> extends Runnable, Future<V>
    　　如何获取返回值？
    　　　　调用FutureTask类的get()方法*/

        for(int i=0;i<10;i++){
            Callable<Integer> implCallable = new ImplCallable();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(implCallable);
            new Thread(futureTask).start();
            System.out.println(Thread.currentThread().getName()+"----"+futureTask.get());
        }
    }
}

class ExtendsThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class ImplRunnable implements Runnable{
    private volatile  int i = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--"+ i++);

    }
}

class ImplCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for(int i=0;i<10;i++){
            result += i;
        }
        System.out.println(Thread.currentThread().getName());
        return result;
    }

}
