public class LinkedList {

  public static void main(String []args) {
    // Write your code here:    
    LinkedList seasons = new LinkedList();
    seasons.printList();
    
    seasons.addToHead("summer");
    seasons.addToHead("spring");
    seasons.printList();

    seasons.addToTail("fall");
    seasons.addToTail("winter");
    seasons.printList();

    seasons.removeHead();

    seasons.printList();
  }

	public Node head;

	public LinkedList() {
		this.head = null;
	}

  public void addToHead(String data) {
    Node newHead = new Node(data);
    Node currentHead = this.head;
    this.head = newHead;
    if (currentHead != null) {
      this.head.setNextNode(currentHead);
    }
  }

  public void addToTail(String data) {
    Node tail = this.head;
    if (tail == null) {
      this.head = new Node(data);
    } else {
      while (tail.getNextNode() != null) {
        tail = tail.getNextNode();
      }
        tail.setNextNode(new Node(data));
    }
  }  

  public String removeHead() {
    Node removedHead = this.head;
    if (removedHead == null) {
      return null;
    }
    this.head = removedHead.getNextNode();
    return removedHead.data;
  }

  public String printList() {
    String output = "<head> ";
    Node currentNode = this.head;
    while (currentNode != null) {
      output += currentNode.data + " ";
      currentNode = currentNode.getNextNode();
    }
    output += "<tail>";
    System.out.println(output);
    return output;
  }
  
  // implementing the nth-last-node-finder function
  public static Node nthLastNode(LinkedList list, int n) {
    Node current = null;
    Node tailSeeker = list.head;
    int count = 0;
    while (tailSeeker != null) {
      tailSeeker = tailSeeker.getNextNode();
      if (count >= n) {
        if (current == null) {
          current = list.head;
        }
        current = current.getNextNode();
      }
      count++;
    }
    return current;
  }

  // implementing the findMiddle function:
  public static Node findMiddle(LinkedList linkedList) {
    Node fast = linkedList.head;
    Node slow = linkedList.head;
   
    while (fast != null) {
      fast = fast.getNextNode();
      if (fast != null) {
        fast = fast.getNextNode();
        slow = slow.getNextNode();
      }
    }
    return slow;
  }
  
  // Half-Speed (findMiddle alternative) 
  // public static Node findMiddleAlt(LinkedList linkedList) {
  //   int count = 0;
  //   Node fast = linkedList.head;
  //   Node slow = linkedList.head;
   
  //   while(fast != null) {
  //     fast = fast.getNextNode();
  //     if (count % 2 != 0) {
  //       slow = slow.getNextNode();
  //     }
  //     count++;
  //   }
  //   return slow;
  // }  

}
