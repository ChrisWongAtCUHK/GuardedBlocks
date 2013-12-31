package oracle.concurrency.guardmeth;

import java.util.Random;

/**
 * @author Chris Wong
 * <p>
 * Producer
 * </p>
 */
public class Producer implements Runnable {
	private Drop drop;
	
	/**
	 * Constructor
	 * @param drop
	 */
	public Producer(Drop drop){
		this.drop = drop;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		String importantInfo[] = {
				"Mares eat oats",
				"Does eat oats",
				"Little lambs eat ivy",
				"A kid will eat ivy too"
		};
		
		Random random = new Random();
		
		for(int i = 0; i < importantInfo.length; i++){
			drop.put(importantInfo[i]);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException exception) {
				
			}
		}
		
		drop.put("DONE");
	}
}
