import java.util.EmptyStackException;

/**
* Array based implementation of a stack, includes isEmpty, pop, push, peek,
* and size methods.
*
* @author Jonathan Chiu
*/
public class ArrayBasedStack<T> implements StackInterface<T> {
	
	private T[] stack;
	private int size;
	private int capacity;

	@SuppressWarnings("unchecked")
	public ArrayBasedStack(int capacity) {

		// Java does not allow for generic array creation so we must cast
		// an Object array
		stack = (T[]) new Object[capacity];

		// Initialize stack
		size = 0;
		this.capacity = capacity;
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public void push(T item) {

		// Check if stack is full
		if (size == capacity) {
			System.out.print("Stack is full.");
			return;
		}

		// Push the item into the stack and update size
		stack[size] = item;
		size++;
	}

	public T pop() {
		T poppedValue;

		// Check if stack is empty
		if (size == 0) {
			throw new EmptyStackException();
		}

		// Grab the topmost value in the stack
		poppedValue = stack[(size - 1)];

		// Reduce size by 1 and return popped value
		size--;
		return poppedValue;

	}

	public T peek() {

		// Check if stack is empty
		if (size == 0) {
			throw new EmptyStackException();
		}

		// Grab the topmost value in the stack
		return stack[(size - 1)];
	}

	public int size() {
		return size;
	}
}