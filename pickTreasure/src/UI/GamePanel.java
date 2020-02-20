package UI;

import Control.GameControl;
import Control.Item;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePanel extends Pane {
    GameControl gc = new GameControl();

    public Button buttonBack = new Button("返回菜单");
    public Button button = new Button("重新开始");
    public ImageView game_over = new ImageView("image/game_over.png");

    public GamePanel(){initGame();}

    public void initGame()
    {
        gc.init();
        //设置背景图片
        ImageView bg = new ImageView("image/背景.jpg");
        bg.setFitHeight(660);
        bg.setFitWidth(710);
        getChildren().add(bg);

        gc.money = new Text("money:0");
        gc.money.setFill(Color.BLUE);
        gc.money.setFont(Font.font("黑体",20));
        gc.money.setX(580);
        gc.money.setY(40);

        //设置聚宝盆位置大小
        gc.imageSetting(100,100,320,560,gc.pot);

        //设置元宝初始位置大小
        getItem(gc.items1);

        getChildren().addAll(gc.money,gc.pot);
    }

    public void getItem(Item[] items)
    {
        for(int i = 0;i < items.length;i++)
        {
            items[i].setSpeed(Math.random()*10 + 5);
            gc.imageSetting(60,60,Math.random()*660,
                    -(Math.random()*600),items[i].getIv());
            getChildren().add(items[i].getIv());
        }
    }

    public void mainControl()
    {
        EventHandler<ActionEvent> eventHandler = e->
        {
            gc.moveControl(this);
            for(int i = 0;i < gc.items1.length;i++){
                gc.items1[i].dropSpeed();
            }
            for(int i = 0;i < gc.items.length;i++){
                gc.pickSucceed(gc.items[i]);
            }
            if (gc.pickFailed(this))
            {
                gameOver();
            }
        };
        gc.animation = new Timeline(new KeyFrame(Duration.millis(40),eventHandler));

        gc.animation.setCycleCount(Timeline.INDEFINITE);
        gc.animation.play();
    }


    public void gameOver()
    {
        Stage overStage = new Stage();
        overStage.initModality(Modality.APPLICATION_MODAL);//设置模态,必须先处理此窗口

        Text score1 = new Text("Your score is:"+gc.getScore());
        score1.setX(25);
        score1.setY(80);
        score1.setFill(Color.BLUE);
        score1.setFont(Font.font("黑体",30));

        UI_beautify.ButtonBeautify(button,120,10);
        button.setLayoutX(35);
        button.setLayoutY(195);
        button.setOnMouseClicked(e->
        {
            overStage.close();
            getChildren().clear();
            initGame();
            gc.animation.play();
        });

        UI_beautify.ButtonBeautify(buttonBack,120,10);
        buttonBack.setLayoutX(190);
        buttonBack.setLayoutY(195);
        buttonBack.setOnMouseClicked(e->
        {
            overStage.close();
            getChildren().clear();
            initGame();
        });

        gc.imageSetting(330,200,10,5,game_over);
        Group g = new Group();
        g.getChildren().addAll(game_over,button,buttonBack);

        Scene scene = new Scene(g,350,250);
        scene.setFill(Paint.valueOf("#FFFACD"));
        overStage.setScene(scene);
        overStage.show();
    }
}
