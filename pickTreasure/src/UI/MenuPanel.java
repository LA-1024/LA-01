package UI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;


public class MenuPanel extends Pane {

    public Button b_startGame = new Button("开始游戏");
    public Button b_overGame = new Button("退出游戏");
    public Button b_rankingList = new Button("排行榜");
    public Button b_changeAccount = new Button("切换账号");

    public void menu() {

        VBox vb = new VBox();

        ImageView img_title = new ImageView("image/title.png");
        img_title.setFitWidth(540);
        img_title.setFitHeight(160);

        ImageView img_background = new ImageView("image/menuBackground.jpg");
        img_background.setFitWidth(610);
        img_background.setFitHeight(560);


        Button[] bt = {b_rankingList, b_overGame, b_startGame,b_changeAccount};
        for (int i = 0; i < bt.length; i++)
            UI_beautify.ButtonBeautify(bt[i], 250, 60);

        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(img_title,b_startGame, b_rankingList,b_changeAccount, b_overGame);
        vb.setSpacing(30);

        vb.setPadding(new Insets(0,100,0,30));
        getChildren().addAll(img_background,vb);
        //root.setPadding(new Insets(200,200,200,200));

    }
}
