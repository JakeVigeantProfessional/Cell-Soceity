package cellsociety.view;

import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ResourceBundle;

public class StartSplash extends SceneCreator {
    public double screenSize;
    public Pane startPane;
    private Text mainTitle;
    private Text selectLanguage;
    private Button english;
    private Button spanish;
    private Button anotherlanguage;

    private ImageView myBackground;

    ResourceBundle startinfo = ResourceBundle.getBundle("startinfo");

    public StartSplash(double size, Stage stage, String style){
        super(size);
        this.stage = stage;
        startPane = new Pane();
        myBackground = new ImageView();
        creatScene();
        myScene.getStylesheets().add(style);
    }

    public Scene creatScene(){
        english = new Button(startinfo.getString("englishText"));
        spanish = new Button(startinfo.getString("spanishText"));
        anotherlanguage = new Button(startinfo.getString("thirdText"));

        mainTitle = new Text("Team 10");
        mainTitle.getStyleClass().add("mainTitle");
        mainTitle.setLayoutX(160);
        mainTitle.setLayoutY(70);

        selectLanguage = new Text("Select Language");
        selectLanguage.getStyleClass().add("startSelectLanguage");
        selectLanguage.setLayoutX(250);
        selectLanguage.setLayoutY(430);

        myBackground.setImage(new Image(startinfo.getString("startgif")));
        myBackground.setFitWidth(mySize);
        myBackground.setFitHeight(mySize);

        //

        HBox buttons = new HBox(english, spanish, anotherlanguage);
        buttons.setLayoutY(490);
        buttons.setLayoutX(130);
        buttons.getStyleClass().add("allbuttons");

        startPane.getChildren().addAll(myBackground, buttons, mainTitle, selectLanguage);
        handleEvents(stage);

        myScene = new Scene(startPane);
        return myScene;
    }

    public void handleEvents(Stage stage){

        english.setOnAction(event->{
            try {
                FileInput fi = new FileInput(mySize, stage,"fileinput.css","LangLabels");
                stage.setScene(fi.getScene());
            } catch (CsvValidationException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        spanish.setOnAction(event ->{
            try {
                FileInput fi = new FileInput(mySize, stage,"fileinput.css","SpanishLabels");
                stage.setScene(fi.getScene());
            } catch (CsvValidationException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        anotherlanguage.setOnAction(event -> {
            try {
                FileInput fi = new FileInput(mySize, stage,"fileinput.css","LangLabels");
                stage.setScene(fi.getScene());
            } catch (CsvValidationException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
