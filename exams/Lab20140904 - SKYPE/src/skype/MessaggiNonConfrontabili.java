package skype;

public class MessaggiNonConfrontabili extends RuntimeException {

	public MessaggiNonConfrontabili() {
		super();
	}
	
	public MessaggiNonConfrontabili(String msg) {
		super(msg);
	}
	
}
