/**
 * @author Kavin Karki
 */
public class AddFirstAppendsToEnd<E> extends DoublyLinkedList<E> {
    @Override
    public void addFirst(E e) {
        // Links at the wrong end of the list
        linkLast(e);
    }
}
