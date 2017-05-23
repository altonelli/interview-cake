

public class LinkedListCycle {

    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    private static boolean containsCycle(LinkedListNode head) {
        LinkedListNode leader = head;
        LinkedListNode chaser = head;
        if (leader.next == null)
            return false;

        while (leader.next != null && leader.next.next != null) {
            leader = leader.next.next;
            chaser = chaser.next;
            if (leader == chaser) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(11);
        LinkedListNode b = new LinkedListNode(12);
        LinkedListNode c = new LinkedListNode(13);
        LinkedListNode d = new LinkedListNode(14);
        LinkedListNode e = new LinkedListNode(15);
        LinkedListNode f = new LinkedListNode(16);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;

        LinkedListNode one = new LinkedListNode(1);
        LinkedListNode two = new LinkedListNode(2);
        LinkedListNode three = new LinkedListNode(3);
        LinkedListNode four = new LinkedListNode(4);
        LinkedListNode five = new LinkedListNode(5);
        LinkedListNode six = new LinkedListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        boolean testOne = containsCycle(a);
        boolean testTwo = containsCycle(one);

        System.out.println(testOne);
        System.out.println(testTwo);
    }
}