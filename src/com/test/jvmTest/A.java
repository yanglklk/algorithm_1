package com.test.jvmTest;

public class A {
    public int d;
    static {
        System.out.print("1"); //1 父类静态成员
    }
    public A() {
        System.out.print("2"); //3 父类构造函数
        d=2;
        System.out.println("A:d"+d);
    } }
class B extends A{
    static {
        System.out.print("a"); //2 子类静态成员
    }
    public B() {
        System.out.print("b"); //4 子类构造函数
        d=4;
        System.out.println("A:d"+d);
    } }

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
class Human {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            } }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ; }
        finally {
            System.out.println("Hello World!");
        } } }
