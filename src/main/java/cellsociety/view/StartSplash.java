package cellsociety.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

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

    public StartSplash(double size){
        super(size);
        startPane = new Pane();
        myBackground = new ImageView();
    }

    public Pane createStart(Stage stage){
        english = makeButton("englishText");
        spanish = makeButton("spanishText");
        anotherlanguage = makeButton("thirdText");

        mainTitle = new Text("Team 10");
        mainTitle.getStyleClass().add("mainTitle");
        mainTitle.setLayoutX(170);
        mainTitle.setLayoutY(70);

        selectLanguage = new Text("Select Language");
        selectLanguage.getStyleClass().add("startSelectLanguage");
        selectLanguage.setLayoutX(240);
        selectLanguage.setLayoutY(460);

        myBackground.setImage(new Image(startinfo.getString("startgif")));
        myBackground.setFitWidth(mySize);
        myBackground.setFitHeight(mySize);

        //

        HBox buttons = new HBox(english, spanish, anotherlanguage);
        buttons.setLayoutY(490);
        buttons.setLayoutX(130);
        buttons.getStyleClass().add("allbuttons");

        startPane.getChildren().addAll(myBackground, buttons, mainTitle, selectLanguage);
        handleButtons(stage);

        return startPane;
    }

    public Button makeButton(String property) {
        Button result = new Button();
        String label = startinfo.getString(property);
        result.setText(label);
        result.setId(property);
        return result;
    }

    public void handleEvents(Stage stage){
        FileInput fi = new FileInput(mySize);
        english.setOnAction(event->{
            stage.setScene(createScene(stage, fi.createFileInput(stage, "LangLabels"), "fileinput.css"));
            //nextScreen(stage);
        });
        spanish.setOnAction(event ->{
            stage.setScene(createScene(stage, fi.createFileInput(stage, "SpanishLabels"), "fileinput.css"));
            nextScreen(stage);
        });
        anotherlanguage.setOnAction(event -> {
            stage.setScene(createScene(stage, fi.createFileInput(stage, "LangLabels"), "fileinput.css"));
//            nextScreen(stage);
        });
    }

}
