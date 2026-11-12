/**
 * @author Ryder Zvorak
 */
public class SetUsesPositionIndexCheck<E> extends DoublyLinkedList<E> {
    @Override
    public E set(int index, E element) {
        // Uses the add-style bounds check, so set(size) is allowed
        checkPositionIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }
}
