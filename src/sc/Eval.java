package sc;

public class Eval {


	
	
	public static double evaluate(City c){
		double area = 0;
		double highestX = 0;
		double highestY = 0;
		double lowestX = Integer.MAX_VALUE;
		double lowestY = Integer.MAX_VALUE;
		House farthestHouse = null;
		for(House h : c.houses){
			if(h.xPos > highestX){
				highestX = h.xPos;
			}
			if(h.yPos > highestY){
				highestY = h.yPos;
			}
			if(h.xPos < lowestX){
				lowestX = h.xPos;
			}
			if(h.yPos < lowestY){
				lowestY = h.yPos;
			}
		}
		double r = (highestX - lowestX + highestY - lowestY)/4;
		area = r*r*Math.PI;
		double d1 = highestX - lowestX;
		double d2 = highestY - lowestY;
		double ecc = Math.abs(d1 - d2);
		
		double res = area + ecc;
		return res;
		
	}
	
	
}
