class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    def append(self, value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(value)
        cur.next.prev = cur

    def get_kth_node_from_last(self, k):
        # 마지막 커서로 간다
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        # k가 끝날 때까지
        while k != 0:
            k -= 1
            cur = cur.prev

        # 구현해보세요!
        return cur


linked_list = LinkedList(6)
linked_list.append(7)
linked_list.append(8)
linked_list.append(9)

print(linked_list.head.next.next.next.prev.data)

print(linked_list.get_kth_node_from_last(2).data)  # 7이 나와야 합니다!