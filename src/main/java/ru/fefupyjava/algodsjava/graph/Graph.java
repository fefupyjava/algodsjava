package ru.fefupyjava.algodsjava.graph;

import java.util.ArrayList;

public  class Graph {
    public Graph(){
        adjacencyMatrix = new int[0][0];
        adjacencyList = new ArrayList[0];
        ribs = new ArrayList<Rib>();

    }
    //конструктор для матрицы смежности
    public Graph(int[][]adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
        adjacencyList = new ArrayList[adjacencyMatrix.length];
        ribs = new  ArrayList<Rib>();
        for (int i = 0; i < adjacencyMatrix.length; i++){
            adjacencyList[i] = new ArrayList<Integer>();
            for (int j = 0; j < adjacencyMatrix.length; j++){
                if(adjacencyMatrix[i][j] != 0){
                    adjacencyList[i].add(j + 1);
                    ribs.add(new Rib(i + 1,j + 1));
                }
            }
        }
    }
    //конструктор для списка смежности
    public Graph(ArrayList<Integer>[] adjacencyList){
        this.adjacencyList = adjacencyList;
        ribs = new ArrayList<>();
        adjacencyMatrix = new int[adjacencyList.length][adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++){
            for( int j : adjacencyList[i]){
                ribs.add(new Rib(i + 1, j ));
                adjacencyMatrix[i][j-1]++;
            }
        }
    }
    //конструктор для списка рёбер
    public Graph(ArrayList<Rib> edges,int numberVertices){
        this.ribs = edges;
        adjacencyMatrix = new int[numberVertices][numberVertices];
        adjacencyList = new ArrayList[numberVertices];
        for (int i = 0; i < numberVertices;i++)
            adjacencyList[i] = new ArrayList<Integer>();
        for (Rib i : edges){
            adjacencyMatrix[i.start - 1][i.finish - 1]++;
            adjacencyList[i.start - 1].add(i.finish) ;
        }
    }

    public static class Rib {
        public Rib(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
        public int start;
        public int finish;
    }
    private int[][]adjacencyMatrix;
    private ArrayList<Integer>[] adjacencyList;
    private ArrayList<Rib> ribs;

    //добавляет одну вершину в конец, возвращает номер последней вершины
    public int addTop(){
        int[][] newArr = new int[adjacencyMatrix.length + 1][adjacencyMatrix.length + 1];
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for (int j = 0; j < adjacencyMatrix.length; j++){
                newArr[i][j]= adjacencyMatrix[i][j];
            }
        }
        adjacencyMatrix = newArr;
        newArr = null;
        ArrayList<Integer>[] newList = new ArrayList[adjacencyList.length + 1];
        for (int i = 0; i < adjacencyList.length; i++){
            newList[i] = adjacencyList[i];
        }
        newList[newList.length - 1] = new ArrayList<>();
        adjacencyList = newList;
        newList = null;
        return adjacencyMatrix.length;
    }

    //удаляет вершину по номеру. номера следующих вершин смещаются на 1
    public void removeTop(int numberTop){
        if((numberTop > 0)&&(numberTop <= adjacencyMatrix.length)){
            int[][] newArr = new int[adjacencyMatrix.length - 1][adjacencyMatrix.length - 1];
            for(int i = 0; i < numberTop - 1; i++){
                for (int j = 0; j < numberTop - 1; j++){
                    newArr[i][j] = adjacencyMatrix[i][j];
                }
            }
            for(int i = 0; i < numberTop - 1; i++){
                for (int j = numberTop; j < adjacencyMatrix.length; j++){
                    newArr[i][j-1]= adjacencyMatrix[i][j];
                }
            }
            for(int i = numberTop; i < adjacencyMatrix.length; i++){
                for (int j = 0; j < numberTop - 1; j++){
                    newArr[i-1][j]= adjacencyMatrix[i][j];
                }
            }
            for(int i = numberTop; i < adjacencyMatrix.length; i++){
                for (int j = numberTop; j < adjacencyMatrix.length; j++){
                    newArr[i-1][j-1]= adjacencyMatrix[i][j];
                }
            }
            adjacencyMatrix = newArr;
            newArr = null;

            adjacencyList = new ArrayList[adjacencyMatrix.length];
            ribs = new  ArrayList<Rib>();
            for (int i = 0; i < adjacencyMatrix.length; i++){
                adjacencyList[i] = new ArrayList<Integer>();
                for (int j = 0; j < adjacencyMatrix.length; j++){
                    if(adjacencyMatrix[i][j] != 0){
                        adjacencyList[i].add(j + 1);
                        ribs.add(new Rib(i + 1,j + 1));
                    }
                }
            }
        }
    }

    public int[][] getMatrix(){
        return adjacencyMatrix;
    }
    public ArrayList<Integer>[] getList(){
        return adjacencyList;
    }
    public ArrayList<Rib> getRibs(){
        return ribs;
    }

    //вывод матрицы смежности
    public void drawMatrix(){
        System.out.println("Матрица смежности:");
        for (int[]  i : adjacencyMatrix){
            for (int j : i ) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //вывод списка смежности
    public  void drawList(){
        System.out.println("Список смежности:");
        for(int i = 0; i < adjacencyList.length; i++){
            System.out.print(i + 1 + ": ");
            for(int j : adjacencyList[i]){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //вывод списка рёбер
    public void drawRibs(){
        System.out.println("Список рёбер:");
        for(int i = 0; i < ribs.size(); i++){
            System.out.println(i + 1 + ": " + ribs.get(i).start + " " + ribs.get(i).finish );
        }
    }

    //добавление ребра
    public void addRib(Rib newRib){
        boolean flag1 = false, flag2 = false;
        for (int i = 1; i <= adjacencyMatrix.length; i++){
            if(i == newRib.start)
                flag1 = true;
            if(i == newRib.finish)
                flag2 = true;
        }
        if (flag1 && flag2){
            ribs.add(newRib);
            adjacencyMatrix[newRib.start-1][newRib.finish-1] = 1;
            adjacencyList[newRib.start-1].add(newRib.finish);
        }
    }
    public void addRib(int start, int finish){
        boolean flag1 = false, flag2 = false;
        for (int i = 1; i <= adjacencyMatrix.length; i++){
            if(i == start)
                flag1 = true;
            if(i == finish)
                flag2 = true;
        }
        if (flag1 && flag2){
            ribs.add(new Rib(start,finish));
            adjacencyMatrix[start-1][finish-1] = 1;
            adjacencyList[start-1].add(finish);
        }
    }

    //удаление ребра
    public void removeRib(Rib removableRib){
        boolean flag = false;
        int k = 0;
        for (int i = 0; i < ribs.size(); i++){
            if((ribs.get(i).start == removableRib.start)&&(ribs.get(i).finish==removableRib.finish)){
                flag = true;
                k = i;
            }
        }
        if (flag){
            ribs.remove(k);
            adjacencyMatrix[removableRib.start-1][removableRib.finish-1]--;
            for(int i = 0; i < adjacencyList[removableRib.start - 1].size(); i++)//нахождение индекса удаляемово элемента
                if(adjacencyList[removableRib.start - 1].get(i) == removableRib.finish) k = i;
            adjacencyList[removableRib.start-1].remove(k);
        }
    }
    public void removeRib(int start, int finish){
        boolean flag = false;
        int k = 0;
        for (int i = 0; i < ribs.size(); i++){
            if((ribs.get(i).start == start)&&(ribs.get(i).finish == finish)){
                flag = true;
                k = i;
            }
        }
        if (flag){
            ribs.remove(k);
            adjacencyMatrix[start-1][finish-1]--;
            for(int i = 0; i < adjacencyList[start - 1].size(); i++)//нахождение индекса удаляемово элемента
                if(adjacencyList[start - 1].get(i) == finish) k = i;
            adjacencyList[start-1].remove(k);
        }
    }

    //проверяет существует ли данное ребро
    public boolean existRib(int start, int finish){
        boolean flag = false;
        for (int i = 0; i < ribs.size(); i++){
            if((ribs.get(i).start == start)&&(ribs.get(i).finish == finish)){
                flag = true;
            }
        }
        return flag;
    }
    public boolean existRib(Rib removableRib){
        boolean flag = false;
        for (int i = 0; i < ribs.size(); i++){
            if((ribs.get(i).start == removableRib.start)&&(ribs.get(i).finish==removableRib.finish)){
                flag = true;
            }
        }
        return flag;
    }
}
