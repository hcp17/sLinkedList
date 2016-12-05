package algoritmos;



public class LinkedList {
	SlinkNode head;
	SlinkNode tail;
	int size;
	
	public LinkedList(){
		head=tail=null;
		size=0;
	}
	public class SlinkNode{
		int value;
		SlinkNode next;
	
	public SlinkNode(int x){
		value=x;
		next=null;
	}
 }
	int size(){
		return size;
	}
	void AddFront(int x){
		SlinkNode newNode=new SlinkNode(x);
		if(size==0){
			head=tail=newNode;
		}
		else{
		newNode.next=head;
		head=newNode;
		}
		size++;
	}
	void AddBack(int x){
		SlinkNode newNode=new SlinkNode(x);
		if (size==0){
			head=tail=newNode;
		}
		else{
			tail.next=newNode;
			tail=newNode;
		}
		size++;
		
	}
	int removeFront()throws Exception{
		if (size==0)
			throw new Exception();
		int ret=0;
		 if (size==1){
			ret=head.value;
			head=tail=null;
		}
		 else{
			 ret=head.value;
			 head=head.next;
			 
		 }
			
		size--;
		return ret;
	}
	int removeBack()throws Exception{
		if (size==0)
			throw new Exception();
		int ret=0;
		if (size==1){
			ret=tail.value;
			tail=head=null;
			}
		
		else {	SlinkNode cur=head;
			for (int i=0;i<size;i++){
				if(i==size-2)
					tail=cur;
				cur=cur.next;
           
			}
             tail.next=null;
		}
		size--;
		return ret;
		
	}
	void insert(int pos, int x)throws Exception{
		if (pos==0 || size==0)
			AddFront(x);
		else if (pos==size)
			AddBack(x);
		else if(pos<0||pos>size)
			throw new Exception();
		else{
		SlinkNode newNode=new SlinkNode(x);
		SlinkNode cur=head;
		for(int i=0; i<pos;i++){
			if(i==pos-1){
				newNode.next=cur.next;
				cur.next=newNode;
			}
			cur=cur.next;
			}
         size++;
		}
		
	}
	int delete(int pos)throws Exception{
		int ret=0;
		if(pos<0||pos>=size)
			throw new Exception();
		else if (size==0)
			throw new Exception();
		else if (pos==size-1)
			removeBack();
		
		else{
			
			SlinkNode cur=head;
			for(int i=0;i<pos;i++){
				if(i==pos-1){
					ret=cur.next.value;
					cur.next=cur.next.next;
				}
				cur=cur.next;
					
			}
         size--;
         
		}
		
		return ret;
	}
	
	
	
	
	int get(int pos) throws Exception{
		SlinkNode cur=head;
		if (size==0)
			throw new Exception();
		else if(pos<0||pos>size)
			throw new Exception();
		else if (pos==0)
			return head.value;
		else{
		for(int i=0;i<pos;i++){
			cur=cur.next;
		}
		}
		return cur.value;
		
		
	}
	public static void  main(String [] args){
		LinkedList L=new LinkedList();
		L.AddFront(1);
		L.AddFront(2);
		
		L.AddBack(4);
		L.AddBack(5);
		
		try{
         L.removeFront();
		L.delete(3);
		L.insert(3, 7);
		L.insert(2, 3);
     L.removeBack();
		
		}
		catch(Exception e){}
		SlinkNode cur=L.head;
		for(int i=0;i<L.size;i++){
		 System.out.println(cur.value); 
		 cur=cur.next;
		 try {
			System.out.println(L.get(0));
		} catch (Exception e) {}
	}
	}
}

