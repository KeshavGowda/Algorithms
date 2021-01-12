package com.algoexpert.LinkedLists;

public class LinkedListConstruction {

	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		public void setHead(Node node) {
			if (head != null) {
				if (node.prev != null) {
					node.prev.next = node.next;
				}
				if (node.next != null) {
					node.next.prev = node.prev;
				}
				if (node.next == null && node.prev != null) {
					tail = node.prev;
				}
				node.prev = null;
				head.prev = node;
				node.next = head;
				head = node;
			} else {
				head = node;
				tail = node;
			}
		}

		public void setTail(Node node) {
			if (tail != null) {
				if (node.prev != null) {
					node.prev.next = node.next;
				}
				if (node.next != null) {
					node.next.prev = node.prev;
				}
				if (node.prev == null && node.next != null) {
					head = node.next;
				}
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = node;
			} else {
				head = node;
				tail = node;
			}
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			if (nodeToInsert != null && node != null) {
				if (nodeToInsert.prev != null) {
					nodeToInsert.prev.next = nodeToInsert.next;
				}
				if (nodeToInsert.next != null) {
					nodeToInsert.next.prev = nodeToInsert.prev;
				}
				setHeadAndTail(nodeToInsert);
				Node temp = node.prev;
				node.prev = nodeToInsert;
				nodeToInsert.next = node;
				if (temp != null) {
					temp.next = nodeToInsert;
					nodeToInsert.prev = temp;
				} else {
					head = nodeToInsert;
				}
			}
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			if (nodeToInsert != null && node != null) {
				if (nodeToInsert.prev != null) {
					nodeToInsert.prev.next = nodeToInsert.next;
				}
				if (nodeToInsert.next != null) {
					nodeToInsert.next.prev = nodeToInsert.prev;
				}
				setHeadAndTail(nodeToInsert);
				Node temp = node.next;
				node.next = nodeToInsert;
				nodeToInsert.prev = node;
				if (temp != null) {
					temp.prev = nodeToInsert;
					nodeToInsert.next = temp;
				} else {
					tail = nodeToInsert;
				}
			}
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			Node nodeAtPosition = head;
			for (int i = 1; i < position; i++) {
				nodeAtPosition = nodeAtPosition.next; 
			}
			if (nodeAtPosition == null) {
				nodeAtPosition = tail;
			}
			if (nodeAtPosition != null) {
				if (nodeToInsert.prev != null)
					nodeToInsert.prev.next = nodeToInsert.next;
				if (nodeToInsert.next != null)
					nodeToInsert.next.prev = nodeToInsert.prev;
				setHeadAndTail(nodeToInsert);
				Node temp = nodeAtPosition.prev;
				nodeAtPosition.prev = nodeToInsert;
				nodeToInsert.next = nodeAtPosition;
				if (temp != null) {
					temp.next = nodeToInsert;
					nodeToInsert.prev = temp;
				} else {
					head = nodeToInsert;
				}
			} else {
				head = nodeToInsert;
				tail = nodeToInsert;
			}
		}

		public void removeNodesWithValue(int value) {
			Node current = head;
			while (current != null) {
				if (current.value == value) {
					if (current.prev != null) {
						current.prev.next = current.next;
					} else {
						head = current.next;
					}
					if (current.next != null) {
						current.next.prev = current.prev;
					} else {
						tail = current.prev;
					}
					current = current.next;
				} else {
					current = current.next;
				}
			}
		}

		public void remove(Node node) {
			Node current = head;
			while (current != null) {
				if (current.value == node.value) {
					if (current.prev != null)
						current.prev.next = current.next;
					if (current.next != null)
						current.next.prev = current.prev;
					break;
				} else {
					current = current.next;
				}
			}
		}

		public boolean containsNodeWithValue(int value) {
			Node current = head;
			while (current != null) {
				if (current.value == value) 
					return true;
				current = current.next;
			}
			return false;
		}
		
		private void setHeadAndTail(Node node) {
			if (node.prev == null && node.next != null)
				head = node.next;
			if (node.prev != null && node.next == null)
				tail = node.prev;
		}
	}

	// Do not edit the class below.
	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

}
