package ua.univer.lesson07.train;

import java.util.Iterator;

enum Vagon{
    Cargo(0), Passenger(100), HighPass(200);

    private int value;
    Vagon(int value) {
        this.value= value;
    }

    @Override
    public String toString() {
        return "Vagon{" +
                name()+
                ", value=" + value +
                "} ";
    }
}
class TrainEmptyException extends Exception{
}

class Train implements Iterable<Vagon>, ITrainAble {
    private Vagon[] vagons;
    private int top;

    public Train() {
        vagons = new Vagon[10];
        top =-1;
    }
    @Override
    public boolean isFull(){
        return top == vagons.length-1;
    }
    @Override
    public boolean isEmpty(){
        return top == -1;
    }
    @Override
    public int size(){
        return top+1;
    }
    @Override
    public void push(Vagon el){
        if (!isFull())
        vagons[++top] = el;
    }
    @Override
    public Vagon pop() throws TrainEmptyException {
        if (!isEmpty()){
            Vagon v = vagons[top];
            vagons[top] = null;
            top--;
        return v;
        }
        else
            throw new TrainEmptyException();
    }
    @Override
    public Vagon peek(){
        return vagons[top];
    }
    @Override
    public void print(){
        System.out.println("****************");
        for (Vagon v: vagons) {
            if(v == null) break;
            System.out.println(v);
        }
    }
    private class TrainIterator implements Iterator<Vagon>{
        private int i;
        {
            i =0;
        }


        @Override
        public boolean hasNext() {
            return i < vagons.length && vagons[i] != null;
        }

        @Override
        public Vagon next() {
            return vagons[i++];

        }
    }
    @Override
    public Iterator<Vagon> iterator() {
        return new TrainIterator();
    }
//        @Override
//    public Iterator<Vagon> iterator() {
//        return new Iterator() {
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public Object next() {
//                return null;
//            }
//        };
//    }
}

public class ProgramTrain {
    public static void main(String[] args) throws TrainEmptyException {
        ITrainAble train = new TrainList();
        train.push(Vagon.Cargo);
        train.push(Vagon.Passenger);
        train.push(Vagon.Cargo);
        train.push(Vagon.Cargo);
        train.push(Vagon.Passenger);
        train.push(Vagon.Cargo);
        train.push(Vagon.Cargo);
        train.push(Vagon.Passenger);
        train.push(Vagon.Cargo);
        train.push(Vagon.Cargo);
        train.print();

        ITrainAble cargo = new TrainList();
        ITrainAble pass = new TrainList();

        while (!train.isEmpty()){
            if (train.peek()==Vagon.Cargo)
                cargo.push(train.pop());
            else
                pass.push(train.pop());
        }

        cargo.print();
        pass.print();
        System.out.println("********");
        for (Vagon v: cargo) {
            System.out.println(v);
        }
        System.out.println("********");
        Iterator iter = cargo.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

    }
}
