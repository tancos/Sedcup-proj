package sc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class City {
	public List<House> houses = new ArrayList<House>();
	public Map<Integer, Set<House>> clasters = new HashMap<Integer, Set<House>>();
	
	/**
	 * 
	 * @param f ha null akkor syso
	 * @throws FileNotFoundException 
	 */
	public void write(File f) throws FileNotFoundException{
		PrintStream out = System.out;
		if(f != null){
			out = new PrintStream(f);
		}
		out.println(houses.size());
		for(House h : houses){
			out.println(h.id +":"+ h.xPos +" "+ h.yPos);
		}
		out.flush();
		out.close();
	}

	public static City loadCity(File bld, File cfg) throws IOException{
		City city = new City();
		BufferedReader in = new BufferedReader(new FileReader(bld));
		int num = Integer.parseInt(in.readLine());
		Map<Integer, House> map = new HashMap<Integer, House>();
		for(int i=0; i<num; i++){
			String[] line = in.readLine().split(":");
			String[] data = line[1].split("\\s");
			House h = new House(Integer.parseInt(data[0]), Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(line[0]));
			map.put(h.id, h);
			city.houses.add(h);
		}
		in.close();
		
		in = new BufferedReader(new FileReader(cfg));
		String line = null;
		int i=0;
		while((line = in.readLine()) != null){
			Set<House> set = new HashSet<House>();
			String[] data = line.split(":")[1].split("\\s");
			for(String s : data){
				int idx = Integer.parseInt(s);
				House h = map.get(idx);
				h.claster = i;
				set.add(h);
			}
			city.clasters.put(i, set);
			i++;
		}
		in.close();
		return city;
	}
	
	public static void main(String[] args)throws Exception{
		City c = loadCity(new File(args[0]), new File(args[1]));
		c.write(null);
	}

}
