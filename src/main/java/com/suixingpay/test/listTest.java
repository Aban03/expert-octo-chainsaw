package com.suixingpay.test;




public class listTest {     //list

    private Object[] arrdata;
    private int size;

    //private Object[] a = new Object[100];
    public listTest(int arrsize){
        Object[] a = new Object[arrsize];
        this.arrdata = a;
    }

    public int size(){ return size; }   //size


    public boolean add(Object e){   // add
        arrdata[size++] = e;
        return true;
    }

    public Object get(int index){     //get
        checkIndex(index);
        return  listTest.this.arrdata[index];
    }

    public Object set(int index,Object value){  //set
        checkIndex(index);
        Object oldValue = arrdata[index];
        arrdata[index] = value;
        return oldValue;
    }

    public Object remove(int index){  // remove
        checkIndex(index);
        Object oldValue = arrdata[index];
        int numMove = size - index - 1;
        if (numMove > 0)
            System.arraycopy(arrdata, index+1, arrdata, index,
                    numMove);
        arrdata[size--] = null;
        return oldValue;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object o){   // contains
        return indexOf(o) >= 0;
    }
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (arrdata[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(arrdata[i]))
                    return i;
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+this.size;
    }

    public static void main(String[] args) {
        //test
        listTest list = new listTest(100);
        list.add("132");
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(0,0);
        list.remove(1);
        for(int i=0;i<list.size;i++){
            System.out.println(list.get(i));
        }
          System.out.println(list.contains(2));
          System.out.println(list.isEmpty());


    }

}