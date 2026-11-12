/**
 * @author Kavin Karki
 */
public class AddAtIndexAllowsOutOfBounds<E> extends DoublyLinkedList<E> {
    @Override
    public void add(int index, E element) {
        // Clamps the index into [0, size] instead of throwing
        super.add(Math.min(size(), Math.max(0, index)), element);
    }
}
