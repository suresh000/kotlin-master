package lecture044_Linked_List_Day1

class CircularLinkedList {

    private var tail: Node? = null // end of list (Ending node)

    companion object {

        private class Node(var data: Int) {
            var next: Node? = null
        }

        fun insert(linkedList: CircularLinkedList, element: Int, data: Int): CircularLinkedList {

            // Empty list
            if (linkedList.tail == null) {
                val newNode = Node(data)
                linkedList.tail = newNode
                newNode.next = newNode
            } else {

                var currentNode = linkedList.tail
                while (currentNode?.data != element) {
                    currentNode = currentNode?.next
                }

                val newNode = Node(data)
                newNode.next = currentNode.next
                currentNode.next = newNode
            }

            return linkedList
        }

        fun delete(linkedList: CircularLinkedList, element: Int): CircularLinkedList {

            if (linkedList.tail == null) {
                println("List is empty")
            } else {
                // assuming element is present in list

                var previousNode = linkedList.tail
                var currentNode = previousNode?.next

                while (currentNode?.data != element) {
                    previousNode = currentNode
                    currentNode = currentNode?.next
                }

                if (previousNode != null) {
                    previousNode.next = currentNode.next

                    // 1 node(item) in linked list
                    if (currentNode == previousNode) {
                        linkedList.tail = null
                    }
                    // >= 2 node(item) in linked list
                    else if (linkedList.tail == currentNode) {
                        linkedList.tail = previousNode
                    }
                    currentNode.next = null
                }
            }

            return linkedList
        }

        fun insertAtPosition(linkedList: CircularLinkedList, data: Int, position: Int): CircularLinkedList {

            return linkedList
        }

        fun printLinkedList(linkedList: CircularLinkedList) {

            if (linkedList.tail == null) {
                println("List is empty")
                return
            }

            var tail = linkedList.tail

            do {
                print("${tail?.data}  ")
                tail = tail?.next
            } while (tail != linkedList.tail)

            println()

        }

        fun size(linkedList: CircularLinkedList): Int {

            if (linkedList.tail == null) {
                return 0
            }

            var len = 1
            var curr = linkedList.tail?.next

            while (curr != linkedList.tail) {
                len++
                curr = curr?.next
            }

            return len
        }

        fun isCircularLinkedList(linkedList: CircularLinkedList): Boolean {

            if (linkedList.tail == null) {
                return true
            }

            var temp: Node? = linkedList.tail?.next
            while (temp != null && temp != linkedList.tail) {
                temp = temp.next
            }

            return temp == linkedList.tail
        }
    }
}

fun main() {

    var linkedList = CircularLinkedList()

    linkedList = CircularLinkedList.insert(linkedList, 5, 3)
    CircularLinkedList.printLinkedList(linkedList)
    linkedList = CircularLinkedList.insert(linkedList, 3, 5)
    CircularLinkedList.printLinkedList(linkedList)
    linkedList = CircularLinkedList.insert(linkedList, 5, 7)
    CircularLinkedList.printLinkedList(linkedList)
    linkedList = CircularLinkedList.insert(linkedList, 7, 9)
    CircularLinkedList.printLinkedList(linkedList)
    linkedList = CircularLinkedList.insert(linkedList, 5, 6)
    CircularLinkedList.printLinkedList(linkedList)
    linkedList = CircularLinkedList.insert(linkedList, 9, 10)
    CircularLinkedList.printLinkedList(linkedList)
    linkedList = CircularLinkedList.insert(linkedList, 3, 4)
    CircularLinkedList.printLinkedList(linkedList)
    println("Size = ${CircularLinkedList.size(linkedList)}")

    println("Delete element")
    linkedList = CircularLinkedList.delete(linkedList, 3)
    CircularLinkedList.printLinkedList(linkedList)
    println("Size = ${CircularLinkedList.size(linkedList)}")

    println("isCircularLinkedList = ${CircularLinkedList.isCircularLinkedList(linkedList)}")

}