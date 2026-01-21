public class MyStack<E> {
    private ListNode<E> head;

    public MyStack() {
        head = null;
    }

    public boolean push(E obj) {
        ListNode<E> newObj = new ListNode<E>(obj, head);
        head = newObj;
        return true;
    }

    public E pop() {
        if (empty()) {
            return null;
        }
        E value = head.getValue();
        head = head.getNext();
        return value;
    }

    public E peek() {
        if (!empty()) {
            return head.getValue();
        }
        return null;
    }

    public boolean empty() {
        return (head == null);
    }
}
