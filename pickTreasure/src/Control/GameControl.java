package Control;

import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class GameControl {

   public Item gold1 = new Item(30,10,"image/1.png");
   public Item gold2 = new Item(30,10,"image/1.png");
   public Item silver1 = new Item(10,10,"image/2.png");
   public Item silver2 = new Item(10,10,"image/2.png");
   public Item coin1 = new Item(20,10,"image/3.png");
   public Item coin2 = new Item(20,10,"image/3.png");
   public Item coin3 = new Item(20,10,"image/3.png");
   public Item bomb1 = new Item(20,10,"image/bomb1.png");
   public Item bomb2 = new Item(20,10,"image/bomb2.png");
   public Item bomb3 = new Item(20,10,"image/bomb3.png");
   public Item bomb4 = new Item(20,10,"image/bomb4.png");
   public Item bomb5 = new Item(20,10,"image/bomb5.png");
   public Item []  bomb = {bomb1,bomb2,bomb3,bomb4,bomb5};
   public Item [] items = {gold1,gold2,silver1,silver2,coin1,coin2,coin3};
   public Item [] items1 = {gold1,gold2,silver1,silver2,coin1,coin2,coin3,
            bomb5,bomb1,bomb2,bomb3,bomb4};
//Item [] bomb = {bomb1,bomb2,bomb3};


    public ImageView pot = new ImageView("image/0.png");
    public ImageView pot_0 = new ImageView("image/00.png");
    public ImageView bomb_b = new ImageView("image/bomb_b.png");

    public Text money;

    public Animation animation;
    public boolean isStart = true;
    private int score;


    public void init(){
        score = 0;


    }


    public int getScore() {
        return score;
    }


    //GamePanel gp = new GamePanel();

    public void moveControl(Node node)
    {
        node.getScene().setOnKeyPressed(e->
        {
            if (e.getCode() == KeyCode.RIGHT)
            {
                if(pot.getX() < 610)
                    pot.setX(pot.getX() + 20);
            }
            else if (e.getCode() == KeyCode.LEFT)
            {
                if(pot.getX() > 0)
                    pot.setX(pot.getX() - 20);
            }
        });
    }





    public void pickSucceed(Item item)
    {
        if ((Math.abs(item.iv.getX() - pot.getX()) <= 50)&&
                (pot.getY() - item.iv.getY() <= 20 && pot.getY() - item.iv.getY() >= 0))
        {
            reGetItem(item);
            score += item.value;
            money.setText("money:"+score);
        }
        else if (item.iv.getY() > 650)
        {
            reGetItem(item);
        }
    }


    public void imageSetting(int height,int width,double x,double y,ImageView n)
    {
        n.setFitWidth(height);
        n.setFitHeight(width);
        n.setX(x);
        n.setY(y);
    }


    public boolean pickFailed(Pane pane) {
        for (int i = 0; i < bomb.length; i++)
        {
            if ((Math.abs(bomb[i].iv.getX() - pot.getX()) <= 40 &&
                    (pot.getY() - bomb[i].iv.getY() <= 15 && pot.getY() - bomb[i].iv.getY() >= 0)))
            {
                pane.getChildren().removeAll(bomb[0].iv, bomb[1].iv,bomb[2].iv, bomb[3].iv,bomb[4].iv,pot);
                imageSetting(200, 200, (int) pot.getX()-50, (int) pot.getY()-150, bomb_b);
                imageSetting(100, 100, (int) pot.getX(), (int) pot.getY(), pot_0);
                pane.getChildren().addAll(pot_0, bomb_b);
                animation.stop();
                return true;
            }
            else if (bomb[0].iv.getY() > 650)
                reGetItem(bomb[0]);
            else if (bomb[1].iv.getY() > 650)
                reGetItem(bomb[1]);
            else if (bomb[2].iv.getY() > 650)
                reGetItem(bomb[2]);
            else if (bomb[3].iv.getY() > 650)
                reGetItem(bomb[3]);
            else if (bomb[4].iv.getY() > 650)
                reGetItem(bomb[4]);
        }
        return false;
    }



    public void recordScore(String name,int score){
        try
        {   //字节流
            //输出流,true表示文件内容可追加(续写),不会覆盖
            FileOutputStream fop = new FileOutputStream("rankingList.txt",true);
            //BufferedOutputStream bos = new BufferedOutputStream(fop);
            PrintWriter pw = new PrintWriter(fop);
            pw.println(name + " " + score);
            pw.close();
            fop.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void reGetItem(Item item)
    {
        item.iv.setY(-(Math.random()*500));
        item.iv.setX(Math.random()*660);
        item.speed = Math.random()*20 + 5;
    }


}
