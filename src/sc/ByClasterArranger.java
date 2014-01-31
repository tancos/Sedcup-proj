package sc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ByClasterArranger implements IArranger {

	@Override
	public void arrange(City c) {
		Map<Integer, Double> heights = new HashMap<Integer, Double>();
		for(Entry<Integer, Set<House>> e : c.clasters.entrySet()){
			arrangeClaster(new ArrayList<House>(e.getValue()));
			for(House h : e.getValue()){
				Double he = heights.get(e.getKey());
				if(he == null){
					he = (double) h.height;
				}else{
					he += h.height;
				}
				heights.put(e.getKey(), he);
			}
		}
		final Map<Integer, Double> avgHeights = new HashMap<Integer, Double>();
		for(Entry<Integer, Double> e : heights.entrySet()){
			avgHeights.put(e.getKey(), e.getValue()/(double)c.clasters.get(e.getKey()).size());
		}
		List<Integer> cidx = new ArrayList<Integer>(c.clasters.keySet());
		Collections.sort(cidx, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return avgHeights.get(o2).compareTo(avgHeights.get(o1));
			}
		});
		int lines = (int) Math.sqrt(c.clasters.size());
		int x = 0;
		int y = 0;
		int num = 0;
		int maxX = 0;
		for(int i : cidx){
			Set<House> claster = c.clasters.get(i);
			shift(x, y, claster);
			Integer[] lw = getLengthAndWidth(claster);
			y += lw[1];
			maxX = Math.max(maxX, x+lw[0]);
			num++;
			if(num%lines == 0){
				y = 0;
				x = maxX;
			}
		}
	}
	
	private void shift(int x, int y, Set<House> set){
		for(House h:set){
			h.xPos += x;
			h.yPos += y;
		}
	}
	
	private Integer[] getLengthAndWidth(Set<House> set){
		int maxX = 0;
		int maxY = 0;
		for(House h : set){
			maxX = Math.max(maxX, h.xPos+h.width);
			maxY = Math.max(maxY, h.yPos+h.length);
		}
		return new Integer[]{maxX, maxY};
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
