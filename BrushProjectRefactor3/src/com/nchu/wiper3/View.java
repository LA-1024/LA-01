package com.nchu.wiper3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View extends Application {

    ConcreteLever l = new ConcreteLever();
    ConcreteDial d = new ConcreteDial();
    ConcreteBrush b = new ConcreteBrush();
    ConcreteAgent a = new ConcreteAgent(l, d, b);
    GetPossion p = new GetPossion();
    private int r[] = p.getPossion();
    static long startTime;   //获取开始时间
    long endTime; //获取结束时间
    private int i,speed=30;
    ImageView iv1,iv2;
    private Text t;
    private int angle=160,ang=0;
    private double x=220,y=230;
    private int count=0;
    public static void main(String[] args) {
        startTime=System.currentTimeMillis();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group pane = new Group();
        t = new Text();
        t.setFont(Font.font("宋体",30));
        t.setFill(Color.PURPLE);
        Text t1 = new Text("雨量");
        t1.setFont(Font.font("宋体",25));
        t1.setFill(Color.PURPLE);

        t.setLayoutX(545);
        t1.setLayoutX(540);
        t.setLayoutY(55);
        t1.setLayoutY(22);
        iv1 =new ImageView("com/nchu/wiper3/image/window.png");
        iv2 =new ImageView("com/nchu/wiper3/image/brush.png");
       // Circle c = new Circle(363,203,6,Color.LIGHTBLUE);

        iv1.setFitWidth(600);
        iv1.setFitHeight(300);
        iv2.setLayoutX(220);
        iv2.setLayoutY(230);
        iv2.setFitWidth(280);
        iv2.setFitHeight(100);
        iv2.setRotate(angle);

        pane.getChildren().addAll(iv1,iv2,t,t1);

        EventHandler<ActionEvent> eventHandler = e-> {
            a.dealspeed(r[i]);
            if((count / 180) % 2 == 0)
                this.rotate(1,brushSpeed(b.getSpeed()));
            else
                this.rotate(0,brushSpeed(b.getSpeed()));

            endTime=System.currentTimeMillis();
            if((endTime-startTime)/10000==i+1)
                i++;
        };

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(speed),eventHandler));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(pane,600,300);
        primaryStage.setTitle("雨刷");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void rotate(int flag,int speed) {

        t.setText(r[i]+"");
        iv2.setRotate(angle);

        if(flag==1)
        {
            angle=angle-speed;
            ang=ang-speed;
        }
        else
        {
            angle=angle+speed;
            ang=ang+speed;
        }
        count=count+speed;
        iv2.setLayoutX(x);
        iv2.setLayoutY(y);
        x=circle(ang,140,165,260,1);
        y=circle(ang,140,165,260,0);

    }

    public int circle(int angle,int r,int a,int b,int flag)
    {
        if(flag==1)
            return (int)(a + r * Math.cos(angle * Math.PI / 180));
        else
            return (int)(b + r * Math.sin(angle * Math.PI / 180));
    }

    public int brushSpeed(int speed)
    {
        switch(speed)
        {
            case 0:return 0;
            case 4:
            case 6:
            case 12:return 1;
            case 20:return 2;
            case 30:return 3;
            case 60:return 4;
            default:return 5;
        }
    }
}
