package ua.univer.lesson07.train;

public interface ITrainAble extends Iterable<Vagon>{
    boolean isFull();

    boolean isEmpty();

    int size();

    void push(Vagon el);

    Vagon pop() throws TrainEmptyException;

    Vagon peek();

    void print();
}
