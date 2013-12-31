package oracle.concurrency.guardmeth;

/**
 * <p>
 * <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">ProducerConsumerExample</a> is an example from oralce tutorial.
 * </p>
 * @author Chris Wong
 */
public class ProducerConsumerExample {

	/**
	 * Main program
	 * @param args
	 */
	public static void main(String[] args) {
		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}

}
