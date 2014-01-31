package sc;

public class SimpleArranger implements IArranger {

	@Override
	public void arrange(City c) {
		int xpos = 0;
		for(House h : c.houses){
			h.xPos = xpos;
			xpos += h.width;
		}
	}

}
