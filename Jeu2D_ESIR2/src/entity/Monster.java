package entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends Entity {

    List<Object> object;

    public Monster(int a_x, int a_y, int a_speed, BufferedImage a_idleImage) {
        super(a_x, a_y, a_speed, a_idleImage);
        object = new ArrayList<Object>();
    }

    public abstract void move(Player p);

    public abstract void update(Player p);

    public List<Object> getObject() {
        return object;
    }

    public void setObject(List<Object> object) {
        this.object = object;
    }

}