package s002_add_two_numbers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = l1;
        ListNode num2 = l2;
        ListNode res = null;
        ListNode current = null;
        int carry = 0;

        while (true) {
            if (num1 == null && num2 == null && carry == 0)
                break;

            int val;

            if (num1 == null && num2 == null)
                val = carry;
            else {
                if (num1 == null)
                    val = carry + num2.val;
                else if (num2 == null)
                    val = carry + num1.val;
                else
                    val = carry + num1.val + num2.val;
            }

            carry = val / 10;
            int remain = val - carry * 10;

            if (current == null) {
                current = new ListNode(remain);
                res = current;
            } else {
                current.next = new ListNode(remain);
                current = current.next;
            }

            if (num1 != null)
                num1 = num1.next;

            if (num2 != null)
                num2 = num2.next;
        }

        return res;
    }
}

