class ListNode(var value: Int){
	var next: ListNode?=null
	fun getVal()=value?:0
}

fun printList(head: ListNode?) {
	var current = head
	while (current != null) {
		print("${current.value} -> ")
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
	var ret: ListNode?=null
	var current1=l1
	var current2=l2
	var r=0
	var r_next=0
	while((current1!=null) or(current2!=null)){
		r= (current1?.getVal()?.plus(current2?.getVal()?:0) ?: 0) +r_next
		r_next=0
		if (r>9) {
			r=r-10
			r_next=1
		}
		if (ret==null) {
			ret = ListNode(r)
		}else{
			addToEnd(ret,r)
		}
		if( current1 !=null){
			current1=current1.next
		}
		if( current2 !=null){
			current2=current2.next
		}

	}
	return ret
}
fun main() {
	val node1 = ListNode(2)
	addToEnd(node1,4)
	addToEnd(node1,3)
	addToEnd(node1,3)
	addToEnd(node1,3)
	val node2 = ListNode(5)
	addToEnd(node2,6)
	addToEnd(node2,4)
	val resultNode = addTwoNumbers(node1, node2)
	printList(resultNode)
}