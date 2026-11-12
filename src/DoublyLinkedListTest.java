import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {
    /**
     * Use this to toggle between using the DoublyLinkedList class and your broken classes
     * You may submit with either true or false.
     */
    boolean SHOULD_FAIL = false;

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    // Tests for get

    /**
     * @author Kavin Karki
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testGetAtOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();

        list.addLast(1);
        list.addLast(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    /**
     * @author Kavin Karki
     * @see GetAtIndexCountsFromEnd
     */
    @Test
    public void testGetAtIndex() {
        if (SHOULD_FAIL) list = new GetAtIndexCountsFromEnd<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
        assertEquals(50, list.get(4));
    }

    // Tests for getFirst

    /**
     * @author Kavin Karki
     * @see GetFirstReturnsLast
     */
    @Test
    public void testGetFirst() {
        if (SHOULD_FAIL) list = new GetFirstReturnsLast<>();

        assertThrows(NoSuchElementException.class, () -> list.getFirst());
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.getFirst());
    }

    // Tests for getLast

    /**
     * @author Kavin Karki
     * @see GetLastReturnsNullWhenEmpty
     */
    @Test
    public void testGetLast() {
        if (SHOULD_FAIL) list = new GetLastReturnsNullWhenEmpty<>();

        assertThrows(NoSuchElementException.class, () -> list.getLast());
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.getLast());
    }

    // Tests for isEmpty

    /**
     * @author Kavin Karki
     * @see IsEmptyInvertedCheck
     */
    @Test
    public void testIsEmptyWhenCreated() {
        if (SHOULD_FAIL) list = new IsEmptyInvertedCheck<>();

        assertTrue(list.isEmpty());
    }

    /**
     * @author Kavin Karki
     * @see IsEmptyChecksFirstEqualsLast
     */
    @Test
    public void testIsEmptyAfterAddAndRemove() {
        if (SHOULD_FAIL) list = new IsEmptyChecksFirstEqualsLast<>();

        list.addLast(1);
        assertFalse(list.isEmpty());
        list.addLast(2);
        assertFalse(list.isEmpty());
        list.removeFirst();
        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    // Tests for add

    /**
     * @author Ryder Zvorak
     * @see AddAtIndexOffByOne
     */
    @Test
    public void testAddAtIndexInsertsInMiddle() {
        if (SHOULD_FAIL) list = new AddAtIndexOffByOne<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.add(2, 9);
        assertEquals(5, list.size());
        // Checks every index so both forward and backward traversal are exercised
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(9, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    /**
     * @author Ryder Zvorak
     * @see AddAtIndexZeroDoesNotUpdateFirst
     */
    @Test
    public void testAddAtIndexZeroAndSizeUpdatesEnds() {
        if (SHOULD_FAIL) list = new AddAtIndexZeroDoesNotUpdateFirst<>();

        list.addLast(1);
        list.addLast(2);
        list.add(0, 0);
        assertEquals(0, list.getFirst());
        assertEquals(0, list.get(0));
        list.add(list.size(), 3);
        assertEquals(3, list.getLast());
        assertEquals(4, list.size());
    }

    /**
     * @author Ryder Zvorak
     * @see AddAtIndexAllowsOutOfBounds
     */
    @Test
    public void testAddAtIndexOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new AddAtIndexAllowsOutOfBounds<>();

        list.addLast(1);
        list.addLast(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 5));
        assertDoesNotThrow(() -> list.add(2, 5));
        assertEquals(5, list.getLast());
    }

    // Tests for addFirst

    /**
     * @author Ryder Zvorak
     * @see AddFirstAppendsToEnd
     */
    @Test
    public void testAddFirstAddsElement() {
        if (SHOULD_FAIL) list = new AddFirstAppendsToEnd<>();

        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.size());
        assertEquals(2, list.getFirst());
        assertEquals(1, list.get(1));
        assertEquals(1, list.getLast());
    }

    // Tests for addLast

    /**
     * @author Ryder Zvorak
     * @see AddLastInsertsAtFront
     */
    @Test
    public void testAddLastAddsElement() {
        if (SHOULD_FAIL) list = new AddLastInsertsAtFront<>();

        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.size());
        assertEquals(1, list.getFirst());
        assertEquals(2, list.get(1));
        assertEquals(2, list.getLast());
    }

    // Tests for remove

    /**
     * @author Ryder Zvorak
     * @see RemoveAtIndexRemovesNextElement
     */
    @Test
    public void testRemoveAtIndex() {
        if (SHOULD_FAIL) list = new RemoveAtIndexRemovesNextElement<>();

        for (int i = 1; i <= 6; i++) list.addLast(i);
        assertEquals(4, list.remove(3));
        assertEquals(5, list.size());
        // Checks every index so traversal crosses the removed spot in both directions
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(6, list.get(4));
    }

    /**
     * @author Ryder Zvorak
     * @see RemoveAtIndexUsesPositionIndexCheck
     */
    @Test
    public void testRemoveAtIndexOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new RemoveAtIndexUsesPositionIndexCheck<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        assertEquals(3, list.size());
    }

    // Tests for removeFirst

    /**
     * @author Ryder Zvorak
     * @see RemoveFirstRemovesLast
     */
    @Test
    public void testRemoveFirst() {
        if (SHOULD_FAIL) list = new RemoveFirstRemovesLast<>();

        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.getFirst());
        assertEquals(2, list.size());
    }

    // Tests for removeLast

    /**
     * @author Ryder Zvorak
     * @see RemoveLastReturnsNullWhenEmpty
     */
    @Test
    public void testRemoveLast() {
        if (SHOULD_FAIL) list = new RemoveLastReturnsNullWhenEmpty<>();

        assertThrows(NoSuchElementException.class, () -> list.removeLast());
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.removeLast());
        assertEquals(2, list.getLast());
        assertEquals(2, list.size());
    }

    // Tests for size

    /**
     * @author Kavin Karki
     * @see SizeCountsOffByOne
     */
    @Test
    public void testSizeTracksAddsAndRemoves() {
        if (SHOULD_FAIL) list = new SizeCountsOffByOne<>();

        assertEquals(0, list.size());
        list.addFirst(1);
        assertEquals(1, list.size());
        list.addLast(2);
        assertEquals(2, list.size());
        list.add(1, 3);
        assertEquals(3, list.size());
        list.remove(1);
        assertEquals(2, list.size());
        list.removeFirst();
        assertEquals(1, list.size());
        list.removeLast();
        assertEquals(0, list.size());
    }

    // Tests for set

    /**
     * @author Kavin Karki
     * @see SetReturnsNewValue
     */
    @Test
    public void testSetReplacesElementAndReturnsOld() {
        if (SHOULD_FAIL) list = new SetReturnsNewValue<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(2, list.set(1, 9));
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(9, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * @author Kavin Karki
     * @see SetUsesPositionIndexCheck
     */
    @Test
    public void testSetAtOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new SetUsesPositionIndexCheck<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 9));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, 9));
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

}
