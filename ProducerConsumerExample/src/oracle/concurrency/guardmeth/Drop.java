package oracle.concurrency.guardmeth;

/**
 * @author Chris Wong
 * <p>
 *  Drop. The data is a series of text messages, which are shared through an object of type Drop
 * </o>
 */
public class Drop {
	// Message sent from producer to consumer.
	private String message;
	
	// True if consumer should wait for producer to send message,
	// false if producer should wait for consumer to retrieve message.
	private boolean empty = true;
	
	/**
	 * Take the instance of Drop
	 * @return
	 */
	public synchronized String take(){
		// Wait until message is available.
		while(empty){
			try {
				wait();
			} catch (InterruptedException exception) {
				
			}
		}
		
		// Toggle status.
		empty = true;
		
		// Notify producer that status has changed.
		notifyAll();
		
		return message;
	}
	
	/**
	 * Put an instance of Drop
	 * @param message
	 */
	public synchronized void put(String message){
		// Wait until message has been retrieved.
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException exception) {
				
			}
			
		}
		
		// Toggle status.
		empty = false;
		
		// Store message.
		this.message = message;
		
		// Notify consumer that status has changed.
		notifyAll();
	}
}
