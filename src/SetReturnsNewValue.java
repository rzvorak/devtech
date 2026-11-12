/**
 * @author Ryder Zvorak
 */
public class SetReturnsNewValue<E> extends DoublyLinkedList<E> {
    @Override
    public E set(int index, E element) {
        // Returns the new value instead of the replaced one
        super.set(index, element);
        return element;
    }
}
