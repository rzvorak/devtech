/**
 * @author Kavin Karki
 */
public class AddAtIndexZeroDoesNotUpdateFirst<E> extends DoublyLinkedList<E> {
    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            Node<E> succ = node(index);
            final Node<E> pred = succ.prev;
            final Node<E> newNode = new Node<>(pred, element, succ);
            succ.prev = newNode;
            // Forgets to update the head pointer when inserting at index 0
            if (pred != null)
                pred.next = newNode;
            size++;
        }
    }
}
