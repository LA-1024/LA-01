package UI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Control.LoginControl;

import java.io.*;
import java.util.HashMap;


public class LoginPanel extends Pane {
    LoginControl lc = new LoginControl();

    ImageView iv = new ImageView("image/user.png");
    ImageView bg = new ImageView("image/bg1.jpg");
    Text l_account = new Text("账号:");
    Text l_password = new Text("密码:");
    public Button b_login = new Button("立即登录");
    public Button b_register = new Button("注册账号");
    public FileInputStream fis;
    public BufferedReader br;
    public HashMap<String,String> hm =new HashMap<>();
    public TextField t_account = new TextField();
    public PasswordField p_password = new PasswordField();
    public Label message = new Label("");

    public LoginPanel() throws FileNotFoundException {
    }


    public void login(){
	    GridPane gridPane = new GridPane();

        iv.setFitHeight(70);
        iv.setFitWidth(70);

        bg.setFitHeight(360);
        bg.setFitWidth(410);

        l_account.setFont(Font.font("宋体", FontWeight.BOLD,16));

        l_password.setFont(Font.font("宋体",FontWeight.BOLD,16));

        UI_beautify.textField_beautify(t_account,100,20);

        UI_beautify.textField_beautify(p_password,100,20);



        Button[] bt = {b_login,b_register};
        for(int i=0;i<bt.length;i++)
            UI_beautify.ButtonBeautify(bt[i],220,20);

        gridPane.add(iv,1,0);
        gridPane.add(l_account,0,1);
        gridPane.add(l_password,0,2);
        gridPane.add(t_account,1,1);
        gridPane.add(p_password,1,2);
        gridPane.add(message,1,3);
        gridPane.add(b_login,1,4);
        gridPane.add(b_register,1,5);

        //设置图片的位置
        gridPane.setMargin(iv,new Insets(0,0,5,70));//上下左右间距
        gridPane.setMargin(l_account,new Insets(0,0,0,70));//上下左右间距
        gridPane.setMargin(l_password,new Insets(0,0,0,70));//上下左右间距

        //gridPane.setAlignment(Pos.CENTER);//设置GridPane节点在场景中间
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        //setStyle("-fx-background-color:#FFFFE0");
        getChildren().addAll(bg,gridPane);

	}

    public boolean loginAction() throws IOException {
        fis = new FileInputStream("src/file/account.txt");
        br = new BufferedReader(new InputStreamReader(fis));
        try {
            readFromText(fis,br,hm);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (hm.containsKey(t_account.getText()) &&
                hm.get(t_account.getText()).equals(p_password.getText()))
        {
            message.setText("");
            return true;
        }
        else
        {
            message.setText("Your password or account is incorrect!");
            message.setTextFill(Color.rgb(210, 39, 30));
            return false;
        }
    }


    public static void readFromText(FileInputStream fis, BufferedReader br, HashMap<String,String> hm) throws IOException {
        hm.clear();
        fis = new FileInputStream("src/file/account.txt");
        br = new BufferedReader(new InputStreamReader(fis));
        String s;
        while((s=br.readLine()) != null) {
            int index = s.indexOf(" ");
            hm.put(s.substring(0, index), s.substring(index + 1));
        }
        fis.close();
        br.close();
    }

}
