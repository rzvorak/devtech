/**
 * @author Ryder Zvorak
 */
public class GetFirstReturnsLast<E> extends DoublyLinkedList<E> {
    @Override
    public E getFirst() {
        // Copy-paste bug: reads from the wrong end
        return super.getLast();
    }
}
