import java.util.Iterator;

public interface Iterador extends Iterator<String> {
	 void insert(String dado);
	 void append(String dado);
	 void inserirOrdenado(String string);
	 
}