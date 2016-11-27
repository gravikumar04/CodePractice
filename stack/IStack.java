package stack;

public interface IStack<E> {

    public boolean isEmpty();

    public boolean isFull();

    public E peek();

    public E push(E t);

    public E pop();
}
