package sc;

public class House implements Comparable<House> {
	
	public int width, height, length, xPos, yPos, id, claster;

	public House(int width, int height, int length, int id) {
		super();
		this.width = width;
		this.height = height;
		this.length = length;
		this.id = id;
		xPos = 0;
		yPos = 0;
	}
	
	public int getArea(){
		return length*width;
	}

	@Override
	public String toString() {
		return "House [width=" + width + ", height=" + height + ", length="
				+ length + ", xPos=" + xPos + ", yPos=" + yPos + ", id=" + id
				+ ", claster=" + claster + "]";
	}

	@Override
	public int compareTo(House o) {
		if(xPos < o.xPos){
			return -1;
		}else if(xPos == o.xPos){
			if(yPos < o.yPos){
				return -1;
			}
			else if(yPos == o.yPos){
				return 0;
			}else{
				return 1;
			}
		}else{
			return 1;
		}
	}
	
}
