/**
 * @author Kavin Karki
 */
public class RemoveAtIndexUsesPositionIndexCheck<E> extends DoublyLinkedList<E> {
    @Override
    public E remove(int index) {
        // Uses the add-style bounds check, so remove(size) is allowed
        checkPositionIndex(index);
        return unlink(node(index));
    }
}
