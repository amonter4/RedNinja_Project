package controller.tab;

public class Workers {
	
	private String EmployeeId;
	private String FirstName;
	private String LastName;
	private String BadgeNumber;
	private String BirthDate;
	private String StreetNumber;
	private String StreetName;
	private String City;
	private String State;
	private String Zipcode;
	private String PhoneNumber;
	private String Email;
	
	
	
	
	public Workers(String employeeId, String firstName, String lastName, String badgeNumber, String birthDate,
			String streetNumber, String streetName, String city, String state, String zipcode, String phoneNumber,
			String email) {
		super();
		EmployeeId = employeeId;
		FirstName = firstName;
		LastName = lastName;
		BadgeNumber = badgeNumber;
		BirthDate = birthDate;
		StreetNumber = streetNumber;
		StreetName = streetName;
		City = city;
		State = state;
		Zipcode = zipcode;
		PhoneNumber = phoneNumber;
		Email = email;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getBadgeNumber() {
		return BadgeNumber;
	}
	public void setBadgeNumber(String badgeNumber) {
		BadgeNumber = badgeNumber;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public String getStreetNumber() {
		return StreetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		StreetNumber = streetNumber;
	}
	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipcode() {
		return Zipcode;
	}
	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
