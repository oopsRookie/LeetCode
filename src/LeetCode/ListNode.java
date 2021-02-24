package LeetCode;

//structure of each node
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setAll(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode head = this;
        System.out.print("ListNode's printing:");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }
}