class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Stack:
    def __init__(self):
        self.head = None
        # head를 그 기준으로 삼는다?

    def push(self, value):
        # 어떻게 하면 될까요?
        # head가 없을 경우
        # if (self.head == None):
            # head를 추가
            # self.head = value
        # head가 있을 경우
        if self.head != None:
            # head의 next를 value로 지정
            value.next = self.head
        # head를 value로 지정
        self.head = value
        return

    # pop 기능 구현
    def pop(self):
        # 어떻게 하면 될까요?
        # head가 없을 경우
            # return None
        if self.head == None:
            return None
        # head가 있을 경우
        elif self.head != None:
            # head.next를 head로 지정
            return_head = self.head
            self.head = self.head.next
            # head를 리턴
            return return_head
        return

    def peek(self):
        # 어떻게 하면 될까요?
        return self.head

    # isEmpty 기능 구현
    def is_empty(self):
        # 어떻게 하면 될까요?
        if self.head == None:
            return True
        else: return False



stack = Stack()
stack.push(Node(9))
stack.push(Node(10))

print(stack.head.data)
print(stack.pop())
print(stack.head.data)
print(stack.pop())
