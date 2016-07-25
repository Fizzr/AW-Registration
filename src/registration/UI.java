package registration;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class UI implements Observer
{
	private static int FULLW = 4;
	private static int THREE_QUARTW = 3;
	private static int HALFW = 2;
	private static int QUARTW = 1;
	private static int FIELDS = 1;
	
	private static int FNAMEY = FIELDS;
	private static int LNAMEY = FNAMEY;
	private static int PHONEY = FIELDS + 2;
	private static int EMAILY = FIELDS + 4;
	private static int SCHOOLY = FIELDS + 6;
	private static int EDUY = FIELDS + 8;
	private static int SYEARY = FIELDS +10;
	private static int SMONTHY = SYEARY;
	private static int EYEARY = SYEARY;
	private static int EMONTHY = SYEARY;
	private static int LASTFIELDY = EMONTHY;
	
	private static int FNAMEX = 0;
	private static int LNAMEX = 2;
	private static int PHONEX = 0;
	private static int EMAILX = 0;
	private static int SCHOOLX = 0;
	private static int EDUX = 0;
	private static int SYEARX = 0;
	private static int SMONTHX = 1;
	private static int EYEARX = 2;
	private static int EMONTHX = 3;
	
	private static int FNAMEW = HALFW;
	private static int LNAMEW = HALFW;
	private static int PHONEW = FULLW;
	private static int EMAILW = FULLW;
	private static int SCHOOLW = FULLW;
	private static int EDUW = FULLW;
	private static int SYEARW = QUARTW;
	private static int SMONTHW = QUARTW; 
	private static int EYEARW = QUARTW;
	private static int EMONTHW = QUARTW;
	
	private static int LOCATION = LASTFIELDY +1;
	
	private static int ROW1 = 0;
	private static int ROW2 = 1;
	private static int ROW3 = 2;
	private static int JOBS = 40;
	
	
	LinkedBlockingQueue<User> userFIFO;
	final Text actiontarget;
    VBox userUIList = new VBox();
    int internalUserID = 0;
    UI ui = this;


	
	public UI(Stage primaryStage, LinkedBlockingQueue<User> userFIFO) throws Exception 
	{
		this.userFIFO = userFIFO;
		
        primaryStage.setTitle("Academic Work Användarregistrering");

		HBox root = new HBox();

        GridPane grid = new GridPane();
        root.getChildren().add(grid);
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setMaxWidth(550);

        Scene scene = new Scene(root, 740, 710);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        
        Text scenetitle = new Text("AW - Registrering av Användare");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 4, 1);

        
        System.out.println(LNAMEW);
        Label firstName = new Label("Förnamn:");
        TextField firstNameTextField = new TextField();
        grid.add(firstName, 			FNAMEX, 	FNAMEY, 	FNAMEW, 1);
        grid.add(firstNameTextField, 	FNAMEX, 	FNAMEY+1,	FNAMEW, 1);
        
        Label lastName = new Label("Efternamn:");
        TextField lastNameTextField = new TextField();
        grid.add(lastName, 				LNAMEX, 	LNAMEY, 	LNAMEW, 1);
        grid.add(lastNameTextField, 	LNAMEX, 	LNAMEY+1, 	LNAMEW, 1);
        
        Label phoneNumber = new Label("Telefonnummer:");
        TextField phoneNumberTextField = new TextField();
        grid.add(phoneNumber, 			PHONEX, 	PHONEY, 	PHONEW, 1);
        grid.add(phoneNumberTextField, 	PHONEX, 	PHONEY+1, 	PHONEW, 1);
        
        Label email = new Label("E-mail:");
        TextField emailTextField = new TextField();
        grid.add(email, 				EMAILX, 	EMAILY, 	EMAILW, 1);
        grid.add(emailTextField, 		EMAILX, 	EMAILY+1, 	EMAILW, 1);
        
        Label school = new Label("Skola:"); 
        TextField schoolTextField = new TextField();
        grid.add(school, 				SCHOOLX, 	SCHOOLY, 	SCHOOLW, 1);
        grid.add(schoolTextField, 		SCHOOLX, 	SCHOOLY+1, 	SCHOOLW, 1);
        
        Label education = new Label("Utbildning:");       
        TextField educationTextField = new TextField();
        grid.add(education, 			EDUX, 		EDUY, 		EDUW, 1);
        grid.add(educationTextField, 	EDUX, 		EDUY+1, 	EDUW, 1);
        
        Label startYear = new Label ("Start år:");
        Label startMonth = new Label ("Start månad:");
        Label endYear = new Label ("Sista år:");
        Label endMonth = new Label ("Sista månad:");
        grid.add(startYear, 	SYEARX, 	SYEARY);
        grid.add(startMonth, 	SMONTHX,	SMONTHY);
        grid.add(endYear, 		EYEARX, 	EYEARY);
        grid.add(endMonth, 		EMONTHX, 	EMONTHY);
        
        TextField startYearTextField = new TextField();
        TextField startMonthTextField = new TextField();
        TextField endYearTextField = new TextField();
        TextField endMonthTextField = new TextField();
        grid.add(startYearTextField, 	SYEARX, 	SYEARY+1);
        grid.add(startMonthTextField, 	SMONTHX, 	SMONTHY+1);
        grid.add(endYearTextField, 		EYEARX, 	EYEARY+1);
        grid.add(endMonthTextField, 	EMONTHX, 	EMONTHY+1);
        
        Label location = new Label("Område");
        location.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(location,0, LOCATION, 2, 1);
        
        CheckBox Blekinge = new CheckBox("Blekinge län");        		// Blekinge län = 0
        CheckBox Dalarna = new CheckBox("Dalarnas län");        		// Dalarnas län = 9
        CheckBox Gotland = new CheckBox("Gotlands län");      			// Gotlands län = 18
        CheckBox Gävleborg = new CheckBox("Gävleborgs län");        	// Gävleborgs län = 21
        CheckBox Halland = new CheckBox("Hallands län");        		// Hallands län = 27
        CheckBox Jämtland = new CheckBox("Jämtlands län");        		// Jämtlands län = 33
        CheckBox Jönköping = new CheckBox("Jönköpings län");        	// Jönköpings län = 35
        CheckBox Kalmar = new CheckBox("Kalmars län");        			// Kalmar län = 45
        CheckBox Kronoberg = new CheckBox("Kronobergs län");       		// Kronobergs län = 53
        CheckBox Norrbotten = new CheckBox("Norrbottens län");      	// Norrbottens län = 57
        CheckBox Ospecificerad = new CheckBox("Ospecificerad");     	// Ospecificerad arbetsort = 70
        CheckBox Skåne = new CheckBox("Skåne län");      				// Skåne län = 71
        CheckBox Stockholm = new CheckBox("Stockholms län");        	// Stockholms län = 93
        CheckBox Södermanland = new CheckBox("Södermanlands län");  	// Södermanlands län = 107
        CheckBox Uppsala = new CheckBox("Uppsala län");   		    	// Uppsala län = 117
        CheckBox Utomland = new CheckBox("Utomlands");        			// Utomlands = 120
        CheckBox Värmland = new CheckBox("Värmlands län");      		// Värmlands län = 125
        CheckBox Västerbotten = new CheckBox("Västerbottens län");  	// Västerbottens län = 133
        CheckBox Västernorrland = new CheckBox("Västernorrlands län");  // Västernorrlands län = 144
        CheckBox Västmanland = new CheckBox("Västmanlands län");        // Västmanlands län = 150
        CheckBox Västra_Götaland = new CheckBox("Västra Götalands län");// Västra Gätalands län = 157
        CheckBox Örebro = new CheckBox("Örebro län");      				// Örebro län = 183
        CheckBox Östergötland = new CheckBox("Östergötlands län");      // Östergötlands län = 193

        grid.add(Blekinge,			0, 14, 1, 1);
        grid.add(Dalarna,			0, 15, 1, 1);
        grid.add(Gotland, 			0, 16, 1, 1);
        grid.add(Gävleborg,			0, 17, 1, 1);
        grid.add(Halland, 			0, 18, 1, 1);
        grid.add(Jämtland,			0, 19, 1, 1);
        grid.add(Jönköping,			1, 14, 1, 1);
        grid.add(Kalmar,			1, 15, 1, 1);
        grid.add(Kronoberg,			1, 16, 1, 1);
        grid.add(Norrbotten,		1, 17, 1, 1);
        grid.add(Ospecificerad, 	1, 18, 1, 1);
        grid.add(Skåne, 			1, 19, 1, 1);
        grid.add(Stockholm, 		2, 14, 1, 1);
        grid.add(Södermanland,		2, 15, 1, 1);
        grid.add(Uppsala, 			2, 16, 1, 1);
        grid.add(Utomland, 			2, 17, 1, 1);
        grid.add(Värmland, 			2, 18, 1, 1);
        grid.add(Västerbotten, 		2, 19, 1, 1);
        grid.add(Västernorrland,	3, 14, 1, 1);
        grid.add(Västmanland, 		3, 15, 1, 1);
        grid.add(Västra_Götaland,	3, 16, 1, 1);
        grid.add(Örebro, 			3, 17, 1, 1);
        grid.add(Östergötland, 		3, 18, 1, 1);
        
        Label work = new Label("Jobbkategorier");
        work.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(work,0, 20, 2, 1);

        
        Label Ekonomi 		= new Label ("Ekonomi/juridik");
        Label Försäljning	= new Label ("Försäljning");
        Label Hotell		= new Label ("Hotell/resturang/turism");
        Label Industri		= new Label ("Industri/tillverkning");
        Label IT			= new Label ("IT");
        Label Kontor		= new Label ("Konor/administration/HR");
        Label Lager			= new Label ("Lager/logistik");
        Label Markandsföring= new Label ("Marknadsföring/information");
        Label Pedagogik		= new Label ("Pedagogik");
        Label Teknik		= new Label ("Teknik");
        Label Telefoni		= new Label ("Telefoni/kundtjänst");

        CheckBox ekonomiCheckBox = new CheckBox();
        CheckBox försäljningCheckBox = new CheckBox();
        CheckBox hotellCheckBox = new CheckBox();
        CheckBox industriCheckBox = new CheckBox();
        CheckBox ITCheckBox = new CheckBox();
        CheckBox kontorCheckBox = new CheckBox();
        CheckBox lagerCheckBox = new CheckBox();
        CheckBox marknadsföringCheckBox = new CheckBox();
        CheckBox pedagogikCheckBox = new CheckBox();
        CheckBox teknikCheckBox = new CheckBox();
        CheckBox telefoniCheckBox = new CheckBox();
        
        
        HBox ekonomiCheckBoxHB = new HBox(10);
        ekonomiCheckBoxHB.getChildren().add(ekonomiCheckBox);
        ekonomiCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);    
        HBox försäljningCheckBoxHB = new HBox(10);
        försäljningCheckBoxHB.getChildren().add(försäljningCheckBox);
        försäljningCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox hotellCheckBoxHB = new HBox(10);
        hotellCheckBoxHB.getChildren().add(hotellCheckBox);
        hotellCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox industriCheckBoxHB = new HBox(10);
        industriCheckBoxHB.getChildren().add(industriCheckBox);
        industriCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox ITCheckBoxHB = new HBox(10);
        ITCheckBoxHB.getChildren().add(ITCheckBox);
        ITCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox kontorCheckBoxHB = new HBox(10);
        kontorCheckBoxHB.getChildren().add(kontorCheckBox);
        kontorCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox lagerCheckBoxHB = new HBox(10);
        lagerCheckBoxHB.getChildren().add(lagerCheckBox);
        lagerCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox marknadsföringCheckBoxHB = new HBox(10);
        marknadsföringCheckBoxHB.getChildren().add(marknadsföringCheckBox);
        marknadsföringCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox pedagogikCheckBoxHB = new HBox(10);
        pedagogikCheckBoxHB.getChildren().add(pedagogikCheckBox);
        pedagogikCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox teknikCheckBoxHB = new HBox(10);
        teknikCheckBoxHB.getChildren().add(teknikCheckBox);
        teknikCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);
        HBox telefoniCheckBoxHB = new HBox(10);
        telefoniCheckBoxHB.getChildren().add(telefoniCheckBox);
        telefoniCheckBoxHB.setAlignment(Pos.BASELINE_RIGHT);

        
        grid.add(Ekonomi, 			0, 21, 2, 1);
        grid.add(Försäljning, 		0, 22, 2, 1);
        grid.add(Hotell, 			0, 23, 2, 1);
        grid.add(Industri, 			0, 24, 2, 1);
        grid.add(IT, 				0, 25, 2, 1);
        grid.add(Kontor, 			0, 26, 2, 1);
        grid.add(Lager, 			2, 21, 2, 1);
        grid.add(Markandsföring,	2, 22, 2, 1);
        grid.add(Pedagogik, 		2, 23, 2, 1);
        grid.add(Teknik, 			2, 24, 2, 1);
        grid.add(Telefoni, 			2, 25, 2, 1);
        
        grid.add(ekonomiCheckBoxHB, 			1, 21, 1, 1);
        grid.add(försäljningCheckBoxHB, 		1, 22, 1, 1);
        grid.add(hotellCheckBoxHB, 				1, 23, 1, 1);
        grid.add(industriCheckBoxHB, 			1, 24, 1, 1);
        grid.add(ITCheckBoxHB, 					1, 25, 1, 1);
        grid.add(kontorCheckBoxHB, 				1, 26, 1, 1);
        grid.add(lagerCheckBoxHB, 				3, 21, 1, 1);
        grid.add(marknadsföringCheckBoxHB,		3, 22, 1, 1);
        grid.add(pedagogikCheckBoxHB, 			3, 23, 1, 1);
        grid.add(teknikCheckBoxHB, 				3, 24, 1, 1);
        grid.add(telefoniCheckBoxHB,			3, 25, 1, 1);
        
        CheckBox partTime = new CheckBox("Deltid");
        CheckBox fullTime = new CheckBox("Heltid");
        CheckBox consultant = new CheckBox("Konsultuppdrag");
        CheckBox recruitment = new CheckBox("Rekrytering");
        
        grid.add(partTime, 0, 27);
        grid.add(fullTime, 1, 27);
        grid.add(consultant, 2, 27);
        grid.add(recruitment, 3, 27);
        
        
        Button register = new Button("Lägg till");
        register.setMinHeight(50);
        register.setMinWidth(100);
        HBox registerHB = new HBox(10);
        registerHB.setAlignment(Pos.BASELINE_CENTER);
        registerHB.getChildren().add(register);    

        

        userUIList.setStyle("-fx-background-color: #7BAFD4");
        userUIList.setPadding(new Insets(5,5,5,5));
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(userUIList);
        sp.setMinWidth(165);
        sp.setMaxWidth(165);
        sp.setMaxHeight(440);
        sp.setMinHeight(440);
        
        VBox container = new VBox();
        container.setPadding(new Insets(90,0,0,0));
        container.getChildren().add(sp);
        root.getChildren().add(container);

        
        userUIList.setMinWidth(150);
        userUIList.setMaxWidth(150);
        userUIList.setMinHeight(440);
        
        actiontarget = new Text();
        grid.add(actiontarget, 2, 28);
        container.getChildren().add(registerHB);
        
        register.setOnAction(new EventHandler<ActionEvent>() 
        {	 
            @Override
            public void handle(ActionEvent e) 
            {
            	boolean[] locationsList = {Blekinge.isSelected(), Dalarna.isSelected(), Gotland.isSelected(),Gävleborg.isSelected(), Halland.isSelected(), Jämtland.isSelected(), Jönköping.isSelected(), Kalmar.isSelected(), Kronoberg.isSelected(), Norrbotten.isSelected(), Ospecificerad.isSelected(), Skåne.isSelected(), Stockholm.isSelected(), Södermanland.isSelected(), Uppsala.isSelected(), Utomland.isSelected(), Värmland.isSelected(), Västerbotten.isSelected(), Västernorrland.isSelected(), Västmanland.isSelected(), Västra_Götaland.isSelected(), Örebro.isSelected(), Östergötland.isSelected()}; 
            	boolean[] jobsList = {ekonomiCheckBox.isSelected(), försäljningCheckBox.isSelected(), hotellCheckBox.isSelected(), industriCheckBox.isSelected(), ITCheckBox.isSelected(), kontorCheckBox.isSelected(), lagerCheckBox.isSelected(), marknadsföringCheckBox.isSelected(), pedagogikCheckBox.isSelected(), teknikCheckBox.isSelected(), telefoniCheckBox.isSelected()};
            	boolean[] jobOptionList = {partTime.isSelected(), fullTime.isSelected(), consultant.isSelected(), recruitment.isSelected()};
            	try 
            	{
            		User user = new User(internalUserID, firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), phoneNumberTextField.getText(), schoolTextField.getText(), educationTextField.getText(), startYearTextField.getText(), startMonthTextField.getText(), endYearTextField.getText(), endMonthTextField.getText(), jobsList, locationsList, jobOptionList);
            		userFIFO.add(user);
                	firstNameTextField.setText("");
                	lastNameTextField.setText("");
                	emailTextField.setText("");
                	phoneNumberTextField.setText("");
                	
            	    /*ImageView infoView = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Infobox_info_icon.svg/1024px-Infobox_info_icon.svg.png");
            	    infoView.setFitWidth(30);
                    infoView.setPreserveRatio(true);
                    infoView.setSmooth(true);
                    infoView.setCache(true);
                    */
                	Label newUser = new Label(user.internalID+". "+user.firstName + " " +user.lastName);
                	//Tooltip message = new Tooltip();
                	//message.setText(user.message);
                	//Tooltip.install(infoView, message);
                	HBox newUserContainer = new HBox();
                	newUserContainer.setStyle("-fx-background-color: #A8A8A8");
                	newUserContainer.setMaxWidth(140);
                	newUserContainer.setPadding(new Insets(5,5,5,5));
                	newUserContainer.getChildren().add(newUser);
                	//newUserContainer.getChildren().add(infoView);
        			userUIList.getChildren().add(newUserContainer);
            		actiontarget.setFill(Color.CORAL);
                    actiontarget.setText("Användare läggs till");
                    internalUserID ++;
                    user.addObserver(ui);
                    newUserContainer.setOnMouseClicked(new EventHandler<MouseEvent>()
                    {
						@Override
						public void handle(MouseEvent event) 
						{
							firstNameTextField.setText(user.firstName);
							lastNameTextField.setText(user.lastName);
							phoneNumberTextField.setText(user.phoneNumber);
							emailTextField.setText(user.email);
							schoolTextField.setText(user.school);
							educationTextField.setText(user.education);
							startYearTextField.setText(user.startYear);
							startMonthTextField.setText(user.startMonth);
							endYearTextField.setText(user.endYear);
							endMonthTextField.setText(user.endMonth);
							Blekinge.setSelected(		user.locations[0]);
						    Dalarna.setSelected(		user.locations[1]);
						    Gotland.setSelected(		user.locations[2]);
						    Gävleborg.setSelected(		user.locations[3]);
						    Halland.setSelected(		user.locations[4]);
						    Jämtland.setSelected(		user.locations[5]);
						    Jönköping.setSelected(		user.locations[6]);
						    Kalmar.setSelected(			user.locations[7]);
						    Kronoberg.setSelected(		user.locations[8]);
						    Norrbotten.setSelected(		user.locations[9]);
						    Ospecificerad.setSelected(	user.locations[10]);
						    Skåne.setSelected(			user.locations[11]);
						    Stockholm.setSelected(		user.locations[12]);
						    Södermanland.setSelected(	user.locations[13]); 
						    Uppsala.setSelected(		user.locations[14]);
						    Utomland.setSelected(		user.locations[15]);
						    Värmland.setSelected(		user.locations[16]);
						    Västerbotten.setSelected(	user.locations[17]);
						    Västernorrland.setSelected(	user.locations[18]);
						    Västmanland.setSelected(	user.locations[19]);
						    Västra_Götaland.setSelected(user.locations[20]); 
						    Örebro.setSelected(			user.locations[21]);
						    Östergötland.setSelected(	user.locations[22]);
							    
						    ekonomiCheckBox.setSelected(		user.jobs[0]);
						    försäljningCheckBox.setSelected(	user.jobs[1]);
						    hotellCheckBox.setSelected(			user.jobs[2]);
						    industriCheckBox.setSelected(		user.jobs[3]);
						    ITCheckBox.setSelected(				user.jobs[4]);
						    kontorCheckBox.setSelected(			user.jobs[5]);
						    lagerCheckBox.setSelected(			user.jobs[6]);
						    marknadsföringCheckBox.setSelected(	user.jobs[7]);
						    pedagogikCheckBox.setSelected(		user.jobs[8]);
						    teknikCheckBox.setSelected(			user.jobs[9]);
						    telefoniCheckBox.setSelected(		user.jobs[10]);
						        
						   partTime.setSelected(	user.jobOptions[0]);
						   fullTime.setSelected(	user.jobOptions[1]);
						   consultant.setSelected(	user.jobOptions[2]);
						   recruitment.setSelected(	user.jobOptions[3]);
						}
                   });
            	}
            	catch(IndexOutOfBoundsException exception)
            	{
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("Namn behöver minst 3 karaktärer var!");
            	}
            }
        });
        primaryStage.show();
	}

	@Override
	public void update(Observable arg0, Object arg1) 
	{
		User user = (User) arg0;
		HBox userBox= (HBox) userUIList.getChildren().get(user.internalID);
		//ImageView info = ((ImageView)userBox.getChildren().get(1));

		if (!user.isAlive)
		{
			userBox.setStyle("-fx-background-color: #FF0000");
		}
		else if (user.isDone)
		{
			userBox.setStyle("-fx-background-color: #00b300");
		}
		else if (user.isCreated)
		{
			userBox.setStyle("-fx-background-color: #ffd11a");
		}
		//Tooltip.install(info, new Tooltip(user.message));
	}

}																																																																																																// Östergötlands län = 193