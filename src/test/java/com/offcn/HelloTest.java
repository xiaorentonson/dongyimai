package com.offcn;


import org.junit.Test;
public class HelloTest {
    @Test
    public void testHello(){
        Hello hello = new Hello();
        String results = hello.print("Hello World");
        System.out.println("hello world".equals(results));
    }
}