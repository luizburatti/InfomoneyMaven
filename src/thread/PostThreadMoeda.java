package thread;

import controller.PostDollarServelet;

public class PostThreadMoeda {

	private String url;

	public PostThreadMoeda(String url) {
		this.url = url;
	}

	public void start() {

		Thread USDBRLT = new Thread(new PostDollarServelet(this.url + "USD-BRLT"));
		Thread USDBRL = new Thread(new PostDollarServelet(this.url + "USD-BRL"));
		Thread CADBRL = new Thread(new PostDollarServelet(this.url + "CAD-BRL"));
		Thread EURBRL = new Thread(new PostDollarServelet(this.url + "EUR-BRL"));
		Thread GBPBRL = new Thread(new PostDollarServelet(this.url + "GBP-BRL"));
		Thread ARSBRL = new Thread(new PostDollarServelet(this.url + "ARS-BRL"));
		Thread JPYBRL = new Thread(new PostDollarServelet(this.url + "JPY-BRL"));
		Thread CHFBRL = new Thread(new PostDollarServelet(this.url + "CHF-BRL"));
		Thread AUDBRL = new Thread(new PostDollarServelet(this.url + "AUD-BRL"));
		Thread CNYBR = new Thread(new PostDollarServelet(this.url + "CNY-BRL"));
		Thread ILSBRL = new Thread(new PostDollarServelet(this.url + "ILS-BRL"));

		USDBRLT.start();
		USDBRL.start();
		CADBRL.start();
		EURBRL.start();
		GBPBRL.start();
		ARSBRL.start();
		JPYBRL.start();
		CHFBRL.start();
		AUDBRL.start();
		CNYBR.start();
		ILSBRL.start();
	}

}
