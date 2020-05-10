
package graphicseditor;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.Serializable;


public class Line implements Serializable{

    private Line2D.Float line_drawn;
    private float line_width = 1.0f;
    private Color boundary_color = new Color(0,0,0);
    private float[] dash_pattern = {5.0f,5.0f};
    private boolean selected;
    private grouping group = null;

    public Line(){

    }

    public Line(Line2D.Float l){
        this.line_drawn = l;
    }

    public Line(Line l){
        this.line_drawn = new Line2D.Float(l.getLine_drawn().x1, l.getLine_drawn().y1, l.getLine_drawn().x2, l.getLine_drawn().y2);
        this.boundary_color = l.boundary_color;
        this.dash_pattern = l.dash_pattern;
    }

    public void updatePos(float newX, float newY, float oldX, float oldY){
        this.line_drawn.x1 += newX - oldX;
        this.line_drawn.y1 += newY - oldY;
        this.line_drawn.x2 += newX - oldX;
        this.line_drawn.y2 += newY - oldY;
    }

    public void PanPos(float newX, float newY){
        this.line_drawn.x1 += newX;
        this.line_drawn.y1 += newY;
        this.line_drawn.x2 += newX;
        this.line_drawn.y2 += newY;
    }

    public void scale(float x){
        this.line_drawn.x1 *= x;
        this.line_drawn.y1 *= x;
        this.line_drawn.x2 *= x;
        this.line_drawn.y2 *= x;
    }
    /**
     * @return the line_drawn
     */
    public Line2D.Float getLine_drawn() {
        return line_drawn;
    }

    /**
     * @param line_drawn the line_drawn to set
     */
    public void setLine_drawn(Line2D.Float line_drawn) {
        this.line_drawn = line_drawn;
    }

    /**
     * @return the boundary_color
     */
    public Color getBoundary_color() {
        return boundary_color;
    }

    /**
     * @param boundary_color the boundary_color to set
     */
    public void setBoundary_color(Color boundary_color) {
        this.boundary_color = boundary_color;
    }

    /**
     * @return the dash_pattern
     */
    public float[] getDash_pattern() {
        return dash_pattern;
    }

    /**
     * @param dash_pattern the dash_pattern to set
     */
    public void setDash_pattern(float[] dash_pattern) {
        this.setDash_pattern(dash_pattern);
    }

    /**
     * @return the line_width
     */
    public float getLine_width() {
        return line_width;
    }

    /**
     * @param line_width the line_width to set
     */
    public void setLine_width(float line_width) {
        this.line_width = line_width;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the group
     */
    public grouping getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(grouping group) {
        this.group = group;
    }




}
