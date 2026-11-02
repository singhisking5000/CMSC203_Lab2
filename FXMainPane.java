


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button hello;
	Button howdy;
	Button chinese;
	Button clear;
	Button exit;
	Label feedback;
	TextField textfield;
	
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	
	
	//student Task #4:
	//  declare an instance of DataManager
	
	DataManager data;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		
		hello = new Button("Hello!");
		hello.setOnAction(new ButtonHandler());
		howdy = new Button("Howdy!");
		howdy.setOnAction(new ButtonHandler());
		chinese = new Button("Chinese");
		chinese.setOnAction(new ButtonHandler());
		clear = new Button("Clear");
		clear.setOnAction(new ButtonHandler());
		exit = new Button("Exit");
		exit.setOnAction(new ButtonHandler());
		feedback = new Label("Feedback: ");
		textfield = new TextField();
		
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hbox1.getChildren().addAll(feedback, textfield);
		hbox2.getChildren().addAll(hello, howdy, chinese, clear, exit);
		this.getChildren().addAll(hbox1, hbox2);
		
		//student Task #4:
				//  instantiate the DataManager instance
				//  set margins and set alignment of the components
		data = new DataManager();
	    Insets inset = new Insets(10);
	    HBox.setMargin(hello, inset);
	    HBox.setMargin(howdy, inset);
	    HBox.setMargin(chinese, inset);
	    HBox.setMargin(clear, inset);
	    HBox.setMargin(exit, inset);
	    HBox.setMargin(feedback, inset);
	    HBox.setMargin(textfield, inset);
	    hbox1.setAlignment(Pos.CENTER);
	    hbox2.setAlignment(Pos.CENTER);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			Object source = event.getSource();
			
			if(source == hello) {
				feedback.setText(data.getHello());
			} else if (source == howdy) {
				feedback.setText(data.getHowdy());
			} else if (source == chinese) {
				feedback.setText(data.getChinese());
			} else if (source == clear) {
				feedback.setText("");
			} else if (source == exit) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
