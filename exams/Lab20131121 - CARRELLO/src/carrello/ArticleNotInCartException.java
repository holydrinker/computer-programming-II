package carrello;

public class ArticleNotInCartException extends RuntimeException {

	public ArticleNotInCartException() {
		super();
	}
	
	public ArticleNotInCartException(String msg) {
		super(msg);
	}
	
}
