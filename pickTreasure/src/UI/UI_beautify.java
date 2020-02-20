package UI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class UI_beautify {
    public static void ButtonBeautify(Button bt,int width,int height)
    {
            bt.setFont(Font.font("Arial Rounded MT 粗体",20));
            bt.setStyle(//"-fx-font: 18 arial; " +
                    "-fx-text-fill: #912CEE;" +
                            "-fx-base: #00F5FF;"+
                            "-fx-border-color: #FFFFFF; "+
                            "-fx-border-insets: -1; "+
                            "-fx-border-style: solid;"+
                            "-fx-border-width: 4;"+
                            "-fx-border-radius: 5;"+
                            "-fx-border-radius: 20;" +
                            "-fx-background-radius: 20;" +
                            "-fx-padding: 8;");
            bt.setCursor(Cursor.HAND);
            bt.setPrefHeight(height);
            bt.setPrefWidth(width);
            final Timeline timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setAutoReverse(true);
            final KeyValue kv = new KeyValue(bt.opacityProperty(), 0.5);
            final KeyFrame kf = new KeyFrame(Duration.millis(800), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();

    }

    public static void textField_beautify(Node fd, int width, int height)
    {
        fd.setStyle("-fx-border-color: #82a9ff; "
                + "-fx-font-size: 16;"
                + "-fx-border-insets: -2; "
                + "-fx-border-radius: 5;"
                + "-fx-border-style: solid;"
                + "-fx-border-width: 3;");
    }

}
