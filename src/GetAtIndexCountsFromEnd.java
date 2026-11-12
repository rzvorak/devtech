/**
 * @author Ryder Zvorak
 */
public class GetAtIndexCountsFromEnd<E> extends DoublyLinkedList<E> {
    @Override
    public E get(int index) {
        // Counts the index from the wrong end of the list
        return super.get(size() - 1 - index);
    }
}
