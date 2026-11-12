/**
 * @author Ryder Zvorak
 */
public class IsEmptyChecksFirstEqualsLast<E> extends DoublyLinkedList<E> {
    @Override
    public boolean isEmpty() {
        // Wrong for a single-element list, where first == last
        return first == last;
    }
}
