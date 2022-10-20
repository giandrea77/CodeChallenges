package it.ag.ps.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrea
 * @implNote Hacker Rank implementations
 *
 * https://www.hackerrank.com/domains/algorithms?filters%5Bstatus%5D%5B%5D=unsolved&badge_type=problem-solving
 *
 */


class SinglyLinkedListNode {
	public int data;
	public SinglyLinkedListNode next;

	public SinglyLinkedListNode(int nodeData) {
		this.data = nodeData;
		this.next = null;
	}
}


public class LinkedListSolving {

	/**
	 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
	 *
	 * @param head
	 */
	static void printLinkedList(SinglyLinkedListNode head) {

		if ( head == null ) {
			return;
		}

		System.out.println(head.data);
		printLinkedList(head.next);

	}


	/**
	 *
	 *
	 * @param head
	 * @param data
	 * @return
	 */
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
		head.next = singlyLinkedListNode;

		return head;

	}

	/**
	 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem?isFullScreen=true
	 *
	 * @param llist
	 * @param data
	 * @return
	 */
	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		newNode.next = llist;
		return newNode;
	}

	/**
	 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
	 *
	 * SinglyLinkedListNode {
	 *  int data;
	 *  SinglyLinkedListNode next;
	 * }
	 *
	 * @param llist
	 * @param data
	 * @param position
	 * @return
	 */
	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		// Write your code here

		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

		// Append at the head of the list
		if ( position == 0 ) {
			newNode.next = llist;
			return newNode;
		}

		SinglyLinkedListNode newList = llist;
		for ( int index = 1; index < position; index ++ ) {
			newList = newList.next;
		}

		newNode.next = newList.next;
		newList.next = newNode;

		return llist;

	}

	/**
	 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
	 *
	 * @param llist
	 * @param position
	 * @return
	 */
	public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

		// Append at the head of the list
		if ( position == 0 ) {
			return llist.next;
		}

		int counter = 0;
		SinglyLinkedListNode prev = llist;
		while ( llist.next != null ) {

			if ( counter == position -1 ) {
				break;
			}

			prev = prev.next;
			counter++;

		}

		prev.next = prev.next.next;

		return llist;

	}

	/**
	 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
	 * @param llist
	 */
	public static void reversePrint(SinglyLinkedListNode llist) {

		if ( llist == null ) {
			return;
		}

		reversePrint(llist.next);
		System.out.println(llist.data);
	}

	/*
	 *
	 * https://www.hackerrank.com/challenges/reverse-a-linked-list/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
	 *
	 * Complete the 'reverse' function below.
	 *
	 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
	 * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
	 *
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {

		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode current = llist;
		SinglyLinkedListNode next = null;

		while (current != null ) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}

		return prev;

	}

	/*
	 * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		while ( head1 != null ) {

			if ( head2 == null || head1.data != head2.data ) {
				return false;
			}

			head1 = head1.next;
			head2 = head2.next;

		}

		return true;

	}

	/*
	 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		SinglyLinkedListNode sortedList = new SinglyLinkedListNode(0);
		SinglyLinkedListNode result = sortedList;

		while (head1 != null && head2 != null) {

			if ( head1.data <= head2.data ) {
				sortedList.next = head1;
				head1 = head1.next;
			} else {
				sortedList.next = head2;
				head2 = head2.next;
			}

			sortedList = sortedList.next;

		}

		if ( head1 == null ) {
			sortedList.next = head2;
		} else {
			sortedList.next = head1;
		}

		return result.next;

	}

	/*
	 * Complete the 'getNode' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_SINGLY_LINKED_LIST llist
	 *  2. INTEGER positionFromTail
	 */

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {

		List<Integer> values = new LinkedList<>();

		while ( llist != null ) {
			values.add(llist.data);
			llist = llist.next;
		}

		return values.get(values.size() - positionFromTail - 1);

	}


	public static void main(String[] args) {

		SinglyLinkedListNode singlyLinkedListNodeA1 = new SinglyLinkedListNode(4);
		SinglyLinkedListNode singlyLinkedListNodeA2 = new SinglyLinkedListNode(3);
		SinglyLinkedListNode singlyLinkedListNodeA3 = new SinglyLinkedListNode(2);
		SinglyLinkedListNode singlyLinkedListNodeA4 = new SinglyLinkedListNode(1);
		singlyLinkedListNodeA1.next = singlyLinkedListNodeA2;
		singlyLinkedListNodeA2.next = singlyLinkedListNodeA3;
		singlyLinkedListNodeA3.next = singlyLinkedListNodeA4;

		SinglyLinkedListNode singlyLinkedListNodeB1 = new SinglyLinkedListNode(1);
		SinglyLinkedListNode singlyLinkedListNodeB2 = new SinglyLinkedListNode(4);
		singlyLinkedListNodeB1.next = singlyLinkedListNodeB2;

		// printLinkedList(mergeLists(singlyLinkedListNodeA1, singlyLinkedListNodeB1));
		System.out.println(getNode(singlyLinkedListNodeA1, 2));

	}

}
