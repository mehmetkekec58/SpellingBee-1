package spellingbee.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import spellingbee.controllers.MenuController;
import spellingbee.core.constants.UINames;
import spellingbee.models.MenuModel;

public class MenuView implements View {
    private final Color BACKGROUND_COLOR = Color.rgb(255, 209, 0);
    private final double PADDING = 50;
    private MenuModel model;
    private MenuController controller;
    private Parent parent;

    public MenuView(MenuModel model, MenuController controller) {
        this.model = model;
        this.controller = controller;

        init();
    }

    private void init() {

        VBox vBox = new VBox();
        parent = vBox;
        vBox.setPadding(new Insets(PADDING));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(Background.fill(BACKGROUND_COLOR));

        VBox titleBox = new VBox(10);
        titleBox.setPadding(new Insets(20));
        titleBox.setAlignment(Pos.CENTER);

        Text title = new Text(UINames.MENU_TITLE);
        title.getStyleClass().addAll("title");

        Text info = new Text(UINames.MENU_INFO);
        info.getStyleClass().addAll("info");

        TextField lettersTextField = new TextField();
        lettersTextField.setPromptText(UINames.MENU_FIELD_PROMPT);
        lettersTextField.getStyleClass().addAll("txtfield");
        lettersTextField.setFocusTraversable(false);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 0, 0, 0));

        Button startButton = new Button(UINames.START_BUTTON);
        Button exitButton = new Button(UINames.EXIT_BUTTON);
        startButton.getStyleClass().addAll("btn", "btn-black");
        exitButton.getStyleClass().addAll("btn", "btn-yellow");

        titleBox.getChildren().addAll(
                title,
                info
        );

        hBox.getChildren().addAll(
                startButton,
                exitButton
        );

        vBox.getChildren().addAll(
                titleBox,
                lettersTextField,
                hBox
        );

    }

    @Override
    public Parent getAsParent() {
        return parent;
    }
}
