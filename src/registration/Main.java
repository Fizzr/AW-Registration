package registration;

import java.util.concurrent.LinkedBlockingQueue;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application 
{
	static LinkedBlockingQueue<User> UserFIFO = new LinkedBlockingQueue<User>();
	static Thread t;
	
	public static void main(String[] args) 
	{	
		//WebParser web = new WebParser(UserFIFO);
		//t = new Thread(web);
		//t.start();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{

		@SuppressWarnings("unused")
		UI ui = new UI(primaryStage, UserFIFO);
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) 
	          {
	        	  //t.interrupt();
	          }
		});
	}

}


/*TODO:
Functionality: 
-Login to created user
-Edit created user
-Messages to be added to UI for info 
-Error detection
	-Too high year value e.g.
	
- More job options (trainee, summerjob etc)

Bugs:
Pressing t1-4 (partTime, recruitment etc), not working 

*/