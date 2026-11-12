/**
 * @author Ryder Zvorak
 */
public class GetLastReturnsNullWhenEmpty<E> extends DoublyLinkedList<E> {
    @Override
    public E getLast() {
        // Returns null on an empty list instead of throwing
        if (last == null) return null;
        return super.getLast();
    }
}
