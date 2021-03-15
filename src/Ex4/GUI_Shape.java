package Ex4;
import java.awt.Color;
public interface GUI_Shape {
	public GeoShape getShape();
	public void setShape(GeoShape g);
	public boolean isFilled();
	public void setFilled(boolean filled);
	public Color getColor();
	public void setColor(Color cl);
	public int getTag();
	public void setTag(int tag);
	public GUI_Shape copy();
	public String toString();
}
