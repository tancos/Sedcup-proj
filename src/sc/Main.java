package sc;

import java.io.File;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		City c = City.loadCity(new File(args[0]), new File(args[1]));
		new SimpleArranger().arrange(c);
		c.write(new File(args[2]));
	}

}
