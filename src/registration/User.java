package registration;

import java.util.Observable;

public class User extends Observable
{
	public int internalID;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNumber;
	public String password;
	public String school;
	public String education;
	public String startYear;
	public String endYear;
	public String startMonth;
	public String endMonth;
	public String message = "Arbetar...";
	public boolean[] jobs;
	public boolean[] locations;
	public boolean[] jobOptions;
	public boolean isCreated = false;
	public boolean isDone = false;
	public boolean isAlive = true;
	
	public User(int ID, String firstName, String lastName, String email, String phoneNumber, String school, String education, String startYear, String startMonth, String endYear, String endMonth, boolean[] jobs, boolean[] locations, boolean[] jobOptions)
	{
		this.internalID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = (firstName.substring(0,3) + lastName.substring(0,3)).toLowerCase();
		this.school = school;
		this.education = education;
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.jobs = jobs;
		this.locations = locations;
		this.jobOptions = jobOptions;
	}
	public void significantChange()
	{
		setChanged();
		notifyObservers();
	}
}