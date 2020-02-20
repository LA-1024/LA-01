package UI;


import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import Control.LoginControl;

public class RegisterPanel extends GridPane{

    LoginControl lc = new LoginControl();
    LoginPanel lp = new LoginPanel();
    Label l_account = new Label("账号:");
    Label l_password = new Label("密码:");
    Label l_password1 = new Label("确认密码:");
    Label tip1 = new Label("3-18位数字、字母、下划线组合");
    Label tip2 = new Label("6-18位数字、字符组合");
    TextField t_account = new TextField();
    PasswordField p_password = new PasswordField();
    PasswordField p_password1 = new PasswordField();
    Button b_register = new Button("立即注册");
    public Button b_login = new Button("返回登录");

    public RegisterPanel() throws FileNotFoundException {
    }


    public void register()
    {
        l_account.setFont(Font.font("宋体", 16));
        l_password.setFont(Font.font("宋体", 16));
        l_password1.setFont(Font.font("宋体", 16));

        tip1.setFont(Font.font("宋体", 10));
        tip2.setFont(Font.font("宋体", 10));

        UI_beautify.textField_beautify(t_account, 100, 20);
        UI_beautify.textField_beautify(p_password, 100, 20);
        UI_beautify.textField_beautify(p_password1, 100, 20);

        UI_beautify.ButtonBeautify(b_register, 220, 20);
        UI_beautify.ButtonBeautify(b_login, 220, 20);

        add(l_account, 0, 0);
        add(t_account, 1, 0);
        add(tip1, 1, 1);
        add(l_password, 0, 2);
        add(p_password, 1, 2);
        add(tip2, 1, 3);
        add(l_password1, 0, 4);
        add(p_password1, 1, 4);
        add(b_register, 1, 7);
        add(b_login, 1, 8);

        setAlignment(Pos.CENTER);//设置GridPane节点在场景中间
        setHgap(10);
        setVgap(10);
        setStyle("-fx-background:#FFFFE0");
    }

    public void registerAction()
    {
        //b_login.setOnAction(e->primaryStage.setScene(l_scene));

        b_register.setOnAction(e->{

            int flag = -1;
            //注册时的输入判断
            if(t_account.getText().matches("\\w{3,18}")&&
                    p_password.getText().matches("\\w{6,18}")&&
                    p_password.getText().equals(p_password1.getText())&&
                    ! lp.hm.containsKey(t_account.getText()))
                flag = 1;
            else if (lp.hm.containsKey(t_account.getText()))
                flag = 0;
            else flag = -1;

            if(flag == 1)
            {
                try
                {   //字节流
                    //输出流,true表示文件内容可追加(续写),不会覆盖
                    FileOutputStream fop = new FileOutputStream("src/file/account.txt",true);
                    BufferedOutputStream bos = new BufferedOutputStream(fop);
                    //PrintWriter pw = new PrintWriter(fop);
                    //pw.println(t_account.getText()+" "+p_password.getText());
                    bos.write(t_account.getText().getBytes());//字符转字节
                    bos.write(" ".getBytes());
                    bos.write(p_password.getText().getBytes());
                    bos.write("\r\n".getBytes());//换行
                    bos.close();//释放资源
                    fop.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("tips");
            if(flag==1)
                alert.setHeaderText("恭喜你,注册成功!");
            else if(flag == 0)
                alert.setHeaderText("该账号已存在!");
            else
                alert.setHeaderText("账号或密码格式错误!");
            alert.showAndWait();

            t_account.setText("");
            p_password.setText("");
            p_password1.setText("");
        });
    }
}
