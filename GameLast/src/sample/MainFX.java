//package sample;
//
//import game_utils.Bag;
//import game_utils.Board;
//import game_utils.Game;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import players.Player;
//import players.PlayerRandom;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MainFX extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        List<Player> currentlyPlaying = new ArrayList<>();
//        primaryStage.setTitle("GAME GUI");
//        //
//        Game game = new Game();
//        game.setBag(new Bag());
//        game.setBoard(new Board(game));
//        //
//
//        Button addPlayer = new Button();
//        addPlayer.setText("Add player");
//        addPlayer.setLayoutX(300);
//        addPlayer.setLayoutY(550);
//        //
//        Pane root = new Pane();
//        root.getChildren().add(addPlayer);
//
//        Button startGame = new Button();
//        startGame.setText("Play");
//        startGame.setLayoutX(450);
//        startGame.setLayoutY(550);
//        root.getChildren().add(startGame);
//        //
//
//        //
//        Label bagTitle = new Label("Bag contains: ");
//        bagTitle.setLayoutX(100);
//        bagTitle.setLayoutY(60);
//        root.getChildren().add(bagTitle);
//
//        Label bag = new Label();
//        bag.setStyle("-fx-border-color: black;");
//        bag.setPrefSize(200, 450);
//        bag.setLayoutX(40);
//        bag.setLayoutY(90);
//        root.getChildren().add(bag);
//
//        Label playersTitle = new Label("Players");
//        playersTitle.setLayoutX(350);
//        playersTitle.setLayoutY(60);
//        root.getChildren().add(playersTitle);
//
//        Label players = new Label();
//        players.setStyle("-fx-border-color: black;");
//        players.setPrefSize(400, 250);
//        players.setLayoutX(350);
//        players.setLayoutY(90);
//
//        //
//
//
//        root.getChildren().add(players);
//
//        Label logs = new Label();
//        logs.setStyle("-fx-border-color: black;");
//        logs.setPrefSize(400, 150);
//        logs.setLayoutX(350);
//        logs.setLayoutY(390);
//
//        root.getChildren().add(logs);
//
//
//
//        addPlayer.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                currentlyPlaying.add(new PlayerRandom("user" + (currentlyPlaying.size()+1)));
//                game.addPlayer(currentlyPlaying.get(currentlyPlaying.size() - 1));
//                String show = "";
//                for (int i=0;i < currentlyPlaying.size(); i++){
//                    show += "       Player " + (i + 1) + ": " + currentlyPlaying.get(i).getName();
//                    show += "\n";
//                }
//                players.setText(show);
//                System.out.println("New Player Added!");
//            }
//        });
//
//        startGame.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                game.start(bag, logs);
//            }
//        });
//
//        primaryStage.setScene(new Scene(root, 800, 600));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
