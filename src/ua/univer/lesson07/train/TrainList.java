package ua.univer.lesson07.train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainList implements ITrainAble {
    private List<Vagon> vList= new ArrayList<>();
 //   private int top;
    {
   ///     top =-1;
    }
    @Override
    public boolean isFull() {
        return vList.size() >= 10;
    }

    @Override
    public boolean isEmpty() {
        return vList.isEmpty();
    }

    @Override
    public int size() {
        return vList.size();
    }

    @Override
    public void push(Vagon el) {
        vList.add(el);
       // top--;
    }

    @Override
    public Vagon pop() throws TrainEmptyException {
        return vList.remove(vList.size()-1);
    }

    @Override
    public Vagon peek() {
        return vList.get(vList.size()-1);
    }

    @Override
    public void print() {
        System.out.println(vList);
    }

    @Override
    public Iterator<Vagon> iterator() {
        return vList.iterator();
    }
}
