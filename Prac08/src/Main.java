import acsse.csc2a.fmb.gui.FireworkDisplayPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*
 * @author: Mothoagae KS 220022690
 * @version: P08
 */
public class Main extends Application{

	public static void main(String[] args) {
		// launches the java fx
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// create an instance of FireworkDisplayPane
		FireworkDisplayPane root = new FireworkDisplayPane();
		//create a scene 
		Scene scene = new Scene(root,1000,800);
		stage.setTitle("JavaFX Application");
		stage.setScene(scene);
		stage.show();
	}

}
