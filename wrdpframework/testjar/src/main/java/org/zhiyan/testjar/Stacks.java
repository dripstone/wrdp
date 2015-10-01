package org.zhiyan.testjar;

import java.util.ArrayList;
import java.util.List;

public class Stacks {
    // private List<Object> list = Collections.synchronizedList(new
    // LinkedList<Object>());
    private List<Object> list = new ArrayList<Object>();
    // private LinkedList<Object> list=new LinkedList<Object>();
    int top = -1;

    public void push(Object value) {
        top++;
        // list.addFirst(value);
        list.add(0, value);
    }

    public Object pop() {
        // Object temp=list.getFirst();
        Object temp = list.get(0);// .getFirst();
        top--;
        list.remove(0);// .removeFirst();
        return temp;
    }

    public Object top() {
        return list.get(0);// .getFirst();
    }
}
