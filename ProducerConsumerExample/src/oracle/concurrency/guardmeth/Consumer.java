package oracle.concurrency.guardmeth;

import java.util.Random;
import static java.lang.System.out;

/**
 * @author Chris Wong
 * <p>
 *  Consumer
 * </p>
 */
public class Consumer implements Runnable {
	private Drop drop;
	
	/**
	 * Constructor
	 * @param drop
	 */
	public Consumer(Drop drop){
		this.drop = drop;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		Random random = new Random();
		for(String message = drop.take(); !message.equals("DONE"); message = drop.take()){
			out.format("MESSAGE RECEIVED: %s%n", message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException exception) {
				
			}
		}
	}

}
