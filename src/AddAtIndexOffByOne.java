/**
 * @author Kavin Karki
 */
public class AddAtIndexOffByOne<E> extends DoublyLinkedList<E> {
    @Override
    public void add(int index, E element) {
        // Off-by-one: interior inserts land one position too far right
        if (index > 0 && index < size()) index = index + 1;
        super.add(index, element);
    }
}
