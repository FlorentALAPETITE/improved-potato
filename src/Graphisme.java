import java.lang.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Graphisme extends Application {

	private MoteurDonnees d_;
	private int h_;
	private int w_;
	private int tailleCase_;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		h_ = 800;
		w_ = 800;
		d_ = new MoteurDonnees(10,10,3);
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root, h_, w_, Color.BLACK);
		tailleCase_ = h_/Math.max(d_.getLignes(), d_.getColonnes())-1;


		Case[][] matrice = d_.getCases();
		final Canvas canvas = new Canvas(h_, w_);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		System.out.println(d_.getColonnes()+" "+d_.getLignes());
		for(int i=0; i<d_.getColonnes(); ++i){
			for(int j=0; j<d_.getLignes(); ++j){
				gc.setFill(matrice[i][j].getCouleur());
				gc.fillRect(i*(tailleCase_+1), j*(tailleCase_+1), tailleCase_, tailleCase_);
			}
		}


		root.getChildren().add(canvas);
		primaryStage.setTitle("Improved-Potatoe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}