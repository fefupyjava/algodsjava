package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.graph.Graph;

import java.util.ArrayList;

public class TestGraph {
    @Test
    public void testGraph() throws Exception{
        //зададим первый граф списком смежности
        ArrayList<Integer>[] adjacencyList = new ArrayList[4] ;
        adjacencyList[0] = new ArrayList<>();
        adjacencyList[0].add(2);
        adjacencyList[0].add(3);
        adjacencyList[1] = new ArrayList<>();
        adjacencyList[1].add(1);
        adjacencyList[1].add(3);
        adjacencyList[1].add(4);
        adjacencyList[2] = new ArrayList<>();
        adjacencyList[2].add(1);
        adjacencyList[2].add(2);
        adjacencyList[3] = new ArrayList<>();
        adjacencyList[3].add(2);
        Graph graph1 = new Graph(adjacencyList);

        //зададим второй граф добавлением и удалением вершин и рёбер
        Graph graph2 = new Graph();
        graph2.addTop();
        graph2.addTop();
        graph2.addRib(new Graph.Rib(1,2));
        graph2.addRib(2,1);
        graph2.addTop();
        graph2.addTop();
        graph2.addRib(new Graph.Rib(1,3));
        graph2.addRib(3,1);
        graph2.addRib(new Graph.Rib(2,3));
        graph2.addRib(3,2);
        graph2.addRib(new Graph.Rib(2,4));
        graph2.addRib(4,2);
        graph2.addTop();
        graph2.removeTop(graph2.getMatrix().length);
        graph1.addRib(4,3);
        graph1.removeRib(4,3);

        //сравним матрицы смежностей этих графов
        for (int i = 0; i < graph1.getMatrix().length;i++){
            Assert.assertArrayEquals( graph1.getMatrix()[i], graph2.getMatrix()[i]);
        }
    }
}
