package com.suixingpay.test;



public class stackTest {

    private listTest list = new listTest(100);

    public int getSize(){   //size
        return list.size();
    }

    public void push(Object o){  //push
        list.add(o);
    }

    public void pop(){     //pop
         Object obj = null;
         int len = list.size();

         if(!list.isEmpty()){
             obj = list.get(len - 1);
             System.out.println(obj);
             list.remove(len - 1);
         }else{
             return;
         }
    }

    public static void main(String[] args) {
        stackTest stack = new stackTest();
        stack.push(0);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.getSize());
        stack.pop();
    }
}
