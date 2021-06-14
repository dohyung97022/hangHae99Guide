class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Queue:
    def __init__(self):
        self.head = None
        self.tail = None

    def enqueue(self, value):
        # 어떻게 하면 될까요?

        # head가 없을 경우
        if self.head == None:
            # head를 value로 지정한다.
            self.head = value

        # head가 있을 경우?
        # tail에 이어붙이기에 상관 없다.

        # tail이 없을 경우
        if self.tail == None:
            # tail을 value로 지정한다.
            self.tail = value

        # tail이 있을 경우
        elif self.tail != None:
            # tail.next를 value로 지정한다
            self.tail.next = value
            # tail을 value로 지정한다
            self.tail = value
        return

    def dequeue(self):
        # 어떻게 하면 될까요?

        # head가 존재하는지만 파악하면 된다.
        if self.head == None:
            return None
        if self.head != None:
            return_head = self.head
            self.head = self.head.next
            return return_head

    def peek(self):
        # 어떻게 하면 될까요?
        return self.head

    def is_empty(self):
        # 어떻게 하면 될까요?
        if self.head == None:
            return True
        else: return False


queue = Queue()
queue.enqueue(Node(9))
print(queue.head.data)
print(queue.tail.data)

queue.enqueue(Node(20))
print(queue.head.data)
print(queue.tail.data)

queue.enqueue(Node(50))
print(queue.head.data)
print(queue.tail.data)

print(queue.dequeue().data)
print(queue.head.data)
print(queue.tail.data)

print(queue.dequeue().data)
print(queue.head.data)
print(queue.tail.data)

print(queue.dequeue().data)
