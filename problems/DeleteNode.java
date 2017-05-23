

public class DeleteNode {
    public static class LinkedListNode {

        public String value;
        public LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }

    public static void deleteNode(LinkedListNode node) {

        LinkedListNode nextNode = node.next;
        if (nextNode != null) {
            node.value = nextNode.value;
            node.next = nextNode.next;
        }
    }


    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");
        LinkedListNode d = new LinkedListNode("D");

        a.next = b;
        b.next = c;
        c.next = d;

        LinkedListNode current = a;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

        deleteNode(b);

        current = a;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}