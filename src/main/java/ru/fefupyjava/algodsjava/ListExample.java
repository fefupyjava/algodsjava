package ru.fefupyjava.algodsjava;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    private List data;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public ListExample(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListExample{" +
                "data=" + data +
                '}';
    }
}
