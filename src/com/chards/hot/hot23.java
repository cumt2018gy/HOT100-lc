package com.chards.hot;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 远 chards_
 * @FileName:hot23
 * @date: 2020-11-01 13:39
 * 23. 合并K个 升序 链表
 * lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 */
public class hot23 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}


//	public ListNode mergeKLists(ListNode[] lists) {
//		if (lists == null || lists.length == 0) {
//			return null;
//		}
//
//		//创建一个堆，并设置元素的排序方式
//		PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
//			@Override
//			public int compare(ListNode o1, ListNode o2) {
//				return o1.val - o2.val;   //升序
//			}
//		});
//
//		//遍历链表数组，然后将每个链表的每个节点都放入堆中
//		for (int i = 0; i < lists.length; i++) {
//			while (lists[i] != null) {
//				queue.add(lists[i]);
//				lists[i] = lists[i].next;
//			}
//		}
//
//		ListNode dummy = new ListNode(-1);
//		ListNode head = dummy;
//    //从堆中不断取出元素，并将取出的元素串联起来
//		while (!queue.isEmpty()) {
//			head.next = queue.poll();
//			head = head.next;
//		}
//		head.next = null;
//		return dummy.next;
//	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0) {
			return null;
		}
		//创建一个小根堆，并定义好排序函数
		PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return (o1.val - o2.val);
			}
		});
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		//这里跟上一版不一样，不再是一股脑全部放到堆中
		//而是只把k个链表的第一个节点放入到堆中
		for(int i=0;i<lists.length;i++) {
			ListNode head = lists[i];
			if(head!=null) {
				queue.add(head);
			}
		}
		//之后不断从堆中取出节点，如果这个节点还有下一个节点，
		//就将下个节点也放入堆中
		while(queue.size()>0) {
			ListNode node = queue.poll();
			cur.next = node;
			cur = cur.next;
			if(node.next!=null) {
				queue.add(node.next);
			}
		}
		cur.next = null;
		return dummy.next;
	}

}
