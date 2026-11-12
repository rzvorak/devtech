/**
 * @author Kavin Karki
 */
public class RemoveFirstRemovesLast<E> extends DoublyLinkedList<E> {
    @Override
    public E removeFirst() {
        // Copy-paste bug: removes from the wrong end
        return super.removeLast();
    }
}
