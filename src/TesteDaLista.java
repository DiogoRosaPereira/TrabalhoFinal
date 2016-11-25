public class TesteDaLista {
	
	public static void main(String[] args) {
		Lista l = new Lista();
		Iterador lista = l.iterator();
		
		lista.inserirOrdenado("1");
		lista.inserirOrdenado("3");
		lista.inserirOrdenado("2");
		lista.inserirOrdenado("5");
		lista.inserirOrdenado("4");
		lista.inserirOrdenado("6");
		
	
		l.print();
		
		
		
	}
}
