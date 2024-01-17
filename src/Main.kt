class ListNode(var `val`: Int){
	var next: ListNode?=null
}

fun printList(head: ListNode?) {
	var current = head
	while (current != null) {
		print("${current.`val`} -> ")
		current = current.next
	}
	println("null")
}
fun addToEnd(head: ListNode?, value: Int){
	val newNode = ListNode(value)
	if(head!=null){
		var current=head
		while(current?.next!=null){
			current = current?.next
		}
		current?.next=newNode
	}
}
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
	var ret_head: ListNode?=null
	var ret_c: ListNode?=null
	var c1:ListNode?=l1
	var c2:ListNode?=l2
	var sum=0
	var sum_next=0
	while((c1!=null)||(c2!=null)||sum_next>0){
		sum=sum_next
		if(c1!=null){
			sum+=c1.`val`
			c1=c1.next
		}
		if(c2!=null){
			sum+=c2.`val`
			c2=c2.next
		}
		sum_next = sum/10
		sum = sum % 10
		if (ret_head==null) {
			ret_head = ListNode(sum)
			ret_c=ret_head
		}else{
			val node=ListNode(sum)
			ret_c?.next = node
			ret_c=ret_c?.next
		}
	}
	return ret_head
}
fun main() {
	val node1 = ListNode(2)
	addToEnd(node1,4)
	addToEnd(node1,9)
	val node2 = ListNode(5)
	addToEnd(node2,6)
	addToEnd(node2,4)
	addToEnd(node2,9)
	val resultNode = addTwoNumbers(node1, node2)
	printList(node1)
	printList(node2)
	printList(resultNode)
}