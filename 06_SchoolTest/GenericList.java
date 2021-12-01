package edu.pnu.collection;

public class GenericList <T>{
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;
    public GenericList(){ data = new Object[DEFAULT_SIZE]; }
    public GenericList(int size){ data = new Object[size]; }
    public void addData(T data){
        this.data[size] = data;
        size++;
    }
    public T getData(int index){
        return (T)data[index];
    }
    public int countData(){ return size; }
    public int dataSize(){ return data.length; }
}
