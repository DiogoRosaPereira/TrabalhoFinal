
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
			
			Node novo = new Node(dado);
			
			head.setNext(novo);
			novo.setBack(tail);
			tail = novo;
			tamanho++;
		}
		
		public boolean remove(String dado) {
			Node novo = new Node(dado);
			
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			if(novo == null || head == null)
		        return false;
		        
		        
		    if(novo.dado.compareTo(head.dado)==0)
		        return removePrimeiro();
		        
		        if(novo.dado.compareTo(tail.dado)==0)
		            return removeUltimo();
		        
		        Node nodoIterador = head.getNext();
		        
		        while(nodoIterador != null && nodoIterador.dado.compareTo(novo.dado)!=0)
		            nodoIterador = nodoIterador.getNext();
		        
		        if(nodoIterador == null)
		            return false;
		        
		        
		        Node nodoAnterior = nodoIterador.getBack();
		        
		        nodoAnterior.setNext(nodoIterador.getNext());
		        nodoAnterior.getNext().setBack(nodoAnterior);
		        nodoIterador.setNext(null);
		        nodoIterador.setBack(null);
		        
		        tamanho --;
		        return true;
	}
	
	
	private boolean removeUltimo() {
		if(tail == null)
            return false;
        
        Node novoTail = tail.getBack();
        
        if(tail.dado.compareTo(head.dado)==0)
            head = null;
        
        if(novoTail != null)
                 
        	novoTail.setNext(null);     //novaCauda--Null     anterior<--cauda    

        tail.setBack(null);   // nova cauda --> null        null<--cauda

        tail = novoTail;
         
        tamanho --;
        
        return true;
	}
		}

	private int tamanho;

	private boolean removePrimeiro() {
		 if(head == null)
	            return false;
	        
	        Node novaCabeca = head.getNext();
	        
	        
	        if(tail.dado.compareTo(head.dado)==0)
	            tail = null;
	        
	        if(novaCabeca != null)
	                
	            novaCabeca.setBack(null);        

	             
	        head.setNext(null);

	        head = novaCabeca;        
	        
	        
	        tamanho --;
	        
	        return true;
	        
	}
	//======================= CLASSE ==================
	
	private Node head = null;
	private Node tail = null;

	public void append(String dado) {
		Node novo = new Node(dado);
		
		head.setNext(novo);
		novo.setBack(tail);
		tail = novo;
		tamanho++;
	}

	public void pushFront(String dado) {
		Node novo = new Node(dado);
		
		novo.setNext(head);
		head.setBack(novo);
		head = novo;
		
		tamanho++;
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