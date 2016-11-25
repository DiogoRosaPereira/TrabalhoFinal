import trabTeste.Node;

public class Lista implements Iterable<String> {

	private class ListaIterator implements Iterador {

		private Node current = null;
		private Node previous = null;
		private int tamanho;
		
		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}

		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				previous = current;
				current = current.getNext();
			}
			return current.dado;
		}

		public void inserirOrdenado(String dado){
			Node novo = new Node(dado);
			
			if(head == null){
				verificaHead(dado);
					
			}
			else if(novo.dado.compareTo(head.dado) <= 0) {
				pushFront(dado);
			}
			else if(novo.dado.compareTo(tail.dado) > 0) {
				append(dado);
			}else{
				Node nodeIterator = head.getNext();
				
				while(nodeIterator.dado.compareTo(novo.dado) < 0){
					nodeIterator = nodeIterator.getNext();
				}
				
				Node nodeAnterior = nodeIterator.getBack();
				
				nodeAnterior.setNext(novo);
				novo.setBack(nodeAnterior);
				novo.setNext(nodeIterator);
				nodeIterator.setBack(novo);
			
	            tamanho += 1; 
			}
		}
		
		private void verificaHead(String dado) {
			Node novo = new Node(dado);
			if(head == null){
				current = novo;
				head = novo;
				tail = novo;
			}
			
		}

		@Override
		public void insert(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			
			Node node = new Node(dado);
			node.next = current; // o proximo de node recebe current
			
			if (previous != null){
				node.next = current;
				node.back = previous;				
				previous.next = node;
				current.back = node;
			}
			else {
				node.next = current;
				node.back = null;
				current.back = node;
				head = node;
			}
			tamanho++;
		}
		
		@Override
		public void append(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			Node node = new Node(dado);
			Node proximo = current.getNext();
			node.setNext(proximo);
			current.setNext(node);
			if (proximo == null) {
				tail = node;
			}
		}
		
		@Override
		public void remove() {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			previous.setNext(current.getNext());
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}
		
	}
	
	
	
	private Node head = null;
	private Node tail = null;

	public void append(String dado) {
		Node node = new Node(dado);
		if (tail == null) {
			head  = node;
		} else {
			tail.setNext(node);
		}
		tail  = node;
	}

	public void pushFront(String dado) {
		Node node = new Node(dado);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
	}

	public void print() {
		Node iter = head;
		while (iter != null) {
			System.out.println(iter.dado);
			iter = iter.getNext();
		}
	}

	@Override
	public Iterador iterator() {
		return new ListaIterator() ;
	}

}