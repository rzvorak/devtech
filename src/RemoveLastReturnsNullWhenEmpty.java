/**
 * @author Kavin Karki
 */
public class RemoveLastReturnsNullWhenEmpty<E> extends DoublyLinkedList<E> {
    @Override
    public E removeLast() {
        // Returns null on an empty list instead of throwing
        if (last == null) return null;
        return super.removeLast();
    }
}
