/**
 * @author Ryder Zvorak
 */
public class SizeCountsOffByOne<E> extends DoublyLinkedList<E> {
    @Override
    public int size() {
        // Loop stops before counting the last node
        int count = 0;
        Node<E> n = first;
        while (n != last) {
            count++;
            n = n.next;
        }
        return count;
    }
}
