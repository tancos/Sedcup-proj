package sc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SquareArranger implements IArranger {

	@Override
	public void arrange(City c) {
			arrangeClaster(c.houses);
		}
		
		private void arrangeClaster(List<House> houses){
			Collections.sort(houses, new Comparator<House>() {
				@Override
				public int compare(House o1, House o2) {
					return Integer.valueOf(o2.height).compareTo(o1.height);
				}
			});
			int lines = (int) Math.sqrt(houses.size());
			int maxX = 0;
			int y = 0;
			int x = 0;
			int i = 0;
			for(House h : houses){
				maxX = Math.max(maxX, x+h.width);
				h.xPos = x;
				h.yPos = y;
				y += h.length;
				i++;
				if(i%lines == 0){
					y = 0;
					x = maxX;
				}
			}
		}

}
