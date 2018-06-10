package lab10;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.text.DecimalFormat;
import java.util.Random;


public class SlotMachine extends Application{
	
	// Create ImageView objects
	private ImageView _view1, _view2, _view3;
	
	// Create Image objects
	private Image _img1, _img2, _img3;
	
	// Create our Random object
	private Random _random;
	
	// Create our Label objects
	private Label _lblTotal, _lblAmount, _lblAmountInserted, _displayAmountWon, _displayTotal;
	
	// Create our TextField objects
	private TextField _amountTxt;
	
	public static void main(String[] args) 
	{
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) 
	{
		// Instantiate our Image objects
		_img1 = new Image("file:cherry.jpeg");
		_img2 = new Image("file:banana.jpg");
		_img3 = new Image("file:apple.jpg");
		
		// Instantiate our ImageView objects
		_view1 = new ImageView(_img1);
		_view2 = new ImageView(_img2);
		_view3 = new ImageView(_img3);
		
		// Instantiate our Label objects
		_lblTotal = new Label("Total Amount Won: ");
		_lblAmount = new Label("Amount Won: ");
		_lblAmountInserted = new Label("Amount Inserted: $");
		_displayAmountWon = new Label();
		_displayTotal = new Label();
		
		// Instantiate our TextField object
		_amountTxt = new TextField("0");
		
		// Create our Button object
		Button spinBtn = new Button("Spin");
		
		// Create an EventHandler
		spinBtn.setOnAction(event ->
		{
			spin();
		});
		
		// Create an HBox to hold our controls
		HBox hBox1 = new HBox(10, _view1, _view2, _view3);
		HBox hBox2 = new HBox(10, _lblAmountInserted, _amountTxt, _lblTotal, _displayTotal);
		
		// Create our VBox to contain our controls
		VBox vBox = new VBox(hBox1, hBox2, _lblAmount, _displayAmountWon, spinBtn);
		
		// Set Alignment to center for VBox
		vBox.setAlignment(Pos.CENTER);
		
		// Set padding padding to 10 for VBox
		vBox.setPadding(new Insets(10));
		
		// Create a Scene
		Scene scene = new Scene(vBox);
		
		// Add our Scene to our Stage
		primaryStage.setScene(scene);
		
		// Give our Stage a width and height
		primaryStage.setWidth(800);
		primaryStage.setHeight(500);
		
		// Show the window
		primaryStage.show();
	}
	
	public void spin() 
	{
		
		
		// Instantiate our Random object
		_random = new Random();
		// Integers to hold our Random numbers
		int rand1 = _random.nextInt(3);
		int rand2 = _random.nextInt(3);
		int rand3 = _random.nextInt(3);
		
		// Integer to hold total
		int total = 0;
		
		DecimalFormat formatter = new DecimalFormat("$#,###.00");
		
		if(rand1 == 0)
			_view1.setImage(_img1);
		else if(rand1 == 1)
			_view1.setImage(_img2);
		else if(rand1 == 2)
			_view1.setImage(_img3);
		
		if(rand2 == 0)
			_view1.setImage(_img1);
		else if(rand2 == 1)
			_view2.setImage(_img2);
		else if(rand2 == 2)
			_view2.setImage(_img3);
		
		if(rand3 == 0)
			_view3.setImage(_img1);
		else if(rand3 == 1)
			_view3.setImage(_img2);
		else if(rand3== 2)
			_view3.setImage(_img3);
		
		// get the users amount inserted through
		// our text field.
		double amountInserted;
		
		if(rand1 == 2 && rand2 == 2 && rand3 == 2) 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 3;
			total += amountInserted;
		}
		else if(rand1 == 2 && rand2 == 2 || rand3 == 2 && rand2 == 2 || rand3 == 2 && rand1 == 3) 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 2;
			total += amountInserted;
		}
		else 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 0;
		}
		
		
		if(rand1 == 1 && rand2 == 1 && rand3 == 1) 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 3;
			total += amountInserted;
		}
		else if(rand1 == 1 && rand2 == 1 || rand3 == 1 && rand2 == 1 || rand3 == 1 && rand1 == 1) 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 2;
			total += amountInserted;
		}
		else 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 0;
		}
		
		
		if(rand1 == 0 && rand2 == 0 && rand3 == 0) 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 3;
			total += amountInserted;
		}
		else if(rand1 == 0 && rand2 == 0 || rand3 == 0 && rand2 == 0 || rand3 == 0 && rand1 == 0) 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 2;
			total += amountInserted;
		}
		else 
		{
			amountInserted = Double.parseDouble(_amountTxt.getText());
			amountInserted *= 0;
		}
		
		_displayAmountWon.setText(formatter.format(amountInserted));
		_displayTotal.setText(formatter.format(total));
	}
	
}
