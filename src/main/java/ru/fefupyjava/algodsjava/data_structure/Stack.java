package ru.fefupyjava.algodsjava.data_structure;

import java.util.*;

public class Stack<T> {

    private List<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public Stack(List<T> list) {
        stack = list;
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        T item = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return item;
    }

    public int size() {
        return stack.size();
    }
}
