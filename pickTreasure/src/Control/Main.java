package Control;

import UI.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.System.exit;

public class Main extends Application
{
    Scene menu_scene,game_scene,login_scene,register_scene,rank_scene;
    GamePanel gamePanel = new GamePanel();
    MenuPanel menuPanel = new MenuPanel();
    LoginPanel loginPanel = new LoginPanel();
    RegisterPanel registerPanel = new RegisterPanel();
    RankingListPanel rankPanel = new RankingListPanel();

    GameControl gc = new GameControl();
    LoginControl lc = new LoginControl();
    String userName = "";

    public Main() throws FileNotFoundException {
    }


    @Override
    public void start(Stage stage)
    {

        login_scene = new Scene(loginPanel,400,350);
        register_scene = new Scene(registerPanel,400,350);
        menu_scene = new Scene(menuPanel,600,550);
        game_scene = new Scene(gamePanel,700,650);
        rank_scene = new Scene(rankPanel,400,640);



        loginPanel.login();
        registerPanel.register();
        //rankPanel.showList();

        loginPanel.b_login.setOnAction(e->
        {
            userName = loginPanel.t_account.getText();
            try {
                if(loginPanel.loginAction()){
                    stage.close();
                    stage.setScene(menu_scene);
                    stage.show();
                    menuPanel.menu();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        loginPanel.b_register.setOnAction(e->
        {
            stage.close();
            stage.setScene(register_scene);
            stage.show();

            registerPanel.registerAction();
        });

        registerPanel.b_login.setOnAction(e->
        {
            stage.close();
            stage.setScene(login_scene);
            stage.show();
        });


        menuPanel.b_startGame.setOnAction(e->
        {
            stage.close();
            stage.setScene(game_scene);
            stage.show();
            gamePanel.mainControl();
        });
        menuPanel.b_rankingList.setOnAction(e->
        {
            stage.close();
            try {
                rankPanel.showList();
            } catch (IOException e1) {

            }
            stage.setScene(rank_scene);
            stage.show();
//            try {
//                rankPanel.fun();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        });

        menuPanel.b_changeAccount.setOnAction(e->
        {
            stage.close();
            stage.setScene(login_scene);
            stage.show();
        });

        menuPanel.b_overGame.setOnAction(e -> exit(0));

        gamePanel.buttonBack.setOnAction(e->
        {
            gc.recordScore(userName,gc.getScore());
            stage.close();
            stage.setScene(menu_scene);
            stage.show();
        });
        gamePanel.button.setOnAction(e-> gc.recordScore(userName,gc.getScore()));

        rankPanel.back.setOnAction(e->
        {
            stage.close();
            stage.setScene(menu_scene);
            stage.show();
        });

        stage.setResizable(false);
        stage.setScene(login_scene);
        stage.getIcons().add(new Image("image/0.png"));
        stage.setTitle("接宝游戏");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
