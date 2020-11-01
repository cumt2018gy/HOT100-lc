package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot19
 * @date: 2020-10-31 14:17
 * 19. 删除链表的倒数第N个节点
 */
public class hot19 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = new ListNode(-1);   //建立虚拟头结点
		first.next = head;
		ListNode pre = first;
		ListNode cur = first;
		for (int i = 0; i <= n; i++) {
			//将cur指针向后先移动n个位置，以便下一步pre指针和cur一起移动的时候能找到倒数第n个节点
			cur = cur.next;
		}
		while (cur != null) {
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return first.next;
	}
}
