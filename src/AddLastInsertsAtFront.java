/**
 * @author Kavin Karki
 */
public class AddLastInsertsAtFront<E> extends DoublyLinkedList<E> {
    @Override
    public void addLast(E e) {
        // Links at the wrong end of the list
        linkFirst(e);
    }
}
