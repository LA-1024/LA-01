package Control;

import javafx.scene.image.ImageView;

public abstract class AbstractItem implements ItemInterface {
    protected int value;
    protected double speed;
    protected ImageView iv;

    public AbstractItem(){}

    public AbstractItem(int value,int speed,String url){
        this.value = value;
        this.speed = speed;
        this.iv = new ImageView(url);
    }

    public AbstractItem(int speed,String url){
        this.speed = speed;
        this.iv = new ImageView(url);
    }

    @Override
    public void dropSpeed() {
        this.iv.setY(this.iv.getY() + this.speed);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }
}
