package sc;

public class House {
	
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

	@Override
	public String toString() {
		return "House [width=" + width + ", height=" + height + ", length="
				+ length + ", xPos=" + xPos + ", yPos=" + yPos + ", id=" + id
				+ ", claster=" + claster + "]";
	}
	
	

}
