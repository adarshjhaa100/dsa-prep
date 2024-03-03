package dsaprep.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private Integer length;

    public ListNode<T> getHead() {
        return head;
    }

    public void setHead(ListNode<T> head) {
        this.head = head;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    @Override
    public String toString() {
        ListNode<T> tempPtr = head;
        StringBuilder ans = new StringBuilder();
        System.out.println();
        while(tempPtr.getNext() != null){
            ans.append(System.out.printf("%d->", tempPtr.getValue()));
        }

        return ans.toString();
    }
}
