package thread;
import controller.PostDollarServelet;

public class PostThreadMoeda {

	private String url;

	public PostThreadMoeda(String url) {
		this.url = url;
	}


	public synchronized void start() {		
		
		Thread USDBRLT = new Thread(new PostDollarServelet(this.url + "USD-BRLT","Thread#1"));
		Thread USDBRL = new Thread(new PostDollarServelet(this.url + "USD-BRL","Thread#2"));
		Thread CADBRL = new Thread(new PostDollarServelet(this.url + "CAD-BRL","Thread#3"));
		Thread EURBRL = new Thread(new PostDollarServelet(this.url + "EUR-BRL","Thread#4"));
		Thread GBPBRL = new Thread(new PostDollarServelet(this.url + "GBP-BRL","Thread#5"));
		Thread ARSBRL = new Thread(new PostDollarServelet(this.url + "ARS-BRL","Thread#6"));
		Thread JPYBRL = new Thread(new PostDollarServelet(this.url + "JPY-BRL","Thread#7"));
		Thread CHFBRL = new Thread(new PostDollarServelet(this.url + "CHF-BRL","Thread#8"));
		Thread AUDBRL = new Thread(new PostDollarServelet(this.url + "AUD-BRL","Thread#9"));
		Thread CNYBR = new Thread(new PostDollarServelet(this.url + "CNY-BRL","Thread#10"));
		Thread ILSBRL = new Thread(new PostDollarServelet(this.url + "ILS-BRL","Thread#11"));
		
		
//		USDBRLT.suspend();
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		USDBRL.suspend();
//		
//		USDBRLT.resume();
//		
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		USDBRL.resume();
//		USDBRL.stop();
	}

}
