package sc;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		City c = City.loadCity(new File(args[0]), new File(args[1]));
		Set<House> set = new HashSet<House>(c.houses);
		for(Set<House> hs : c.clasters.values()){
			set.removeAll(hs);
		}
		c.clasters.put(100, set);
//		new SimpleArranger().arrange(c);
//		new ByClasterArranger().arrange(c);
		new SquareArranger().arrange(c);
		c.write(new File(args[2]));
	}

}
