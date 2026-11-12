/**
 * @author Ryder Zvorak
 */
public class IsEmptyInvertedCheck<E> extends DoublyLinkedList<E> {
    @Override
    public boolean isEmpty() {
        // Inverted comparison
        return size() != 0;
    }
}
