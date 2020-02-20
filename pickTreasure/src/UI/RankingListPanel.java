package UI;

import Control.RankingControl;
import Control.RankingData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.*;

public class RankingListPanel extends VBox {

   public HBox[] hBox = new HBox[11];
   public Button back = new Button("返回");

   public ImageView iv = new ImageView("image/ranking.png");
   public ImageView [] img = new ImageView[10];
   public Text num = new Text("名次");
   public Text player = new Text("玩家");
   public Text money = new Text("分数");
   public Text [] rank = new Text[10];
   public Text [] rank1 = new Text[10];

   RankingControl rc = new RankingControl();

   public RankingListPanel(){
       init();
   }

    public void init()
    {
        for(int i = 0;i < rc.rd.length;i++)
        {
            rc.rd[i] = new RankingData();
            rc.rg[i] = new RankingData();
        }
        iv.setFitWidth(400);
        iv.setFitHeight(100);
        getChildren().add(iv);

        num.setFont(Font.font("宋体", FontWeight.BOLD,20));
        player.setFont(Font.font("宋体", FontWeight.BOLD,20));
        money.setFont(Font.font("宋体", FontWeight.BOLD,20));
        hBox[0] = new HBox();
        hBox[0].getChildren().addAll(num,player,money);
        hBox[0].setSpacing(80);
        HBox.setMargin(money,new Insets(0,0,0,80));
        getChildren().add(hBox[0]);

        for(int i = 0;i < img.length;i++)
        {
            rank[i] = new Text();
            rank1[i] = new Text();
            hBox[i+1] = new HBox();
            img[i] = new ImageView("image/p"+(i+1)+".png");
            img[i].setFitHeight(40);
            img[i].setFitWidth(40);
            rank[i].setFont(Font.font("宋体", FontWeight.BOLD,20));
            rank1[i].setFont(Font.font("宋体", FontWeight.BOLD,20));
            rank1[i].setFill(Color.BLUE);
            hBox[i+1].getChildren().addAll(img[i],rank[i],rank1[i]);
            hBox[i+1].setSpacing(80);
            getChildren().add(hBox[i+1]);
        }

        UI_beautify.ButtonBeautify(back,200,50);
        getChildren().add(back);
        setSpacing(5);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background:#FFFFE0");
    }


    public void showList() throws IOException
    {
        rc.handlingText();
        for(int i = rc.rg.length-1,j = 0;i >= rc.rg.length-10;i--,j++)
        {
            rank[j].setText(rc.rg[i].getName());
            rank1[j].setText(rc.rg[i].getScore()+"");
            HBox.setMargin(rank1[j],new Insets(0,0,0,120-rc.rg[i].getName().length()*12));
        }
        rc.reSetList();
    }
}
