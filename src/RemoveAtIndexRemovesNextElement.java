/**
 * @author Kavin Karki
 */
public class RemoveAtIndexRemovesNextElement<E> extends DoublyLinkedList<E> {
    @Override
    public E remove(int index) {
        // Off-by-one: removes the element after the requested one when possible
        if (index >= 0 && index + 1 < size()) index = index + 1;
        return super.remove(index);
    }
}
