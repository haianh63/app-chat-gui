import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class AppChatGUI {
    private static VBox chatBox;
    public static VBox CreateAppChatGUI() {
        VBox appChatGUI = new VBox(CreateHeader(), CreateChatBox(), CreateChatBar());
        return appChatGUI;
    }
    public static HBox CreateHeader() {
        Circle clip = new Circle(30, 50, 30);
        ImageView avatar = CreateIcon("img/wonyoung.jpg", 90);
        avatar.setClip(clip);
        avatar.getStyleClass().add("avatar");
        Label name = new Label("Wonyoung");
        HBox chatPerson = new HBox(10, avatar, name);
        chatPerson.setAlignment(Pos.CENTER);
        Button normalCallButton = new Button("", CreateIcon("img/telephone.png", 25));
        normalCallButton.getStyleClass().add("callButton");
        Button videoCallButton = new Button("", CreateIcon("img/video.png", 25));
        videoCallButton.getStyleClass().add("callButton");
        HBox callButton = new HBox(normalCallButton, videoCallButton);
        callButton.setAlignment(Pos.CENTER);
        HBox header = new HBox(40, chatPerson, callButton);
        header.getStyleClass().add("header");
        header.setAlignment(Pos.CENTER);
        return header;
    }

    public static VBox CreateChatBox() {
        chatBox = new VBox(20);
        chatBox.getStyleClass().add("chatBox");
        return chatBox;
    }

    public static HBox CreateChatBar() {
        TextField typeArea = new TextField();
        typeArea.setPromptText("Type here...");
        typeArea.getStyleClass().add("typeArea");
        Button sendButton = new Button("", CreateIcon("img/send.png", 30));
        sendButton.getStyleClass().add("sendButton");
        sendButton.setOnAction((e) -> {
            String message = typeArea.getText();
            if (!message.equals("")) {
                Label messageBox = new Label(message);
                messageBox.getStyleClass().add("messageBox");
                chatBox.getChildren().add(messageBox);
                typeArea.clear();
            }
        });

        HBox chatBar = new HBox(20,typeArea, sendButton);
        chatBar.getStyleClass().add("chatBar");
        chatBar.setAlignment(Pos.CENTER);
        return chatBar;
    }
    public static ImageView CreateIcon (String url, int size) {
        Image img = new Image(url);
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(size);
        imgView.setPreserveRatio(true);
        return imgView;
    }
}
