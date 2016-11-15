package controller.tab;



public class Client {
private String ClientId;
private String Name;
private String Email;
private String PhoneNumber;
private String StreetNumber;
private String StreetName;
private String State;
private String CompanyName;
private String CompanyType;
private String ContractLength;
private String ContactName;
private String ZipCode;
private String City;



public Client(String clientId, String name, String email, String phoneNumber, String streetNumber, String streetName,
		String state, String companyName, String companyType, String contractLength, String contactName, String zipCode,
		String city) {
	super();
	ClientId = clientId;
	Name = name;
	Email = email;
	PhoneNumber = phoneNumber;
	StreetNumber = streetNumber;
	StreetName = streetName;
	State = state;
	CompanyName = companyName;
	CompanyType = companyType;
	ContractLength = contractLength;
	ContactName = contactName;
	ZipCode = zipCode;
	City = city;
}

public String getClientId() {
	return ClientId;
}

public void setClientId(String clientId) {
	ClientId = clientId;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getPhoneNumber() {
	return PhoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	PhoneNumber = phoneNumber;
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

public String getState() {
	return State;
}

public void setState(String state) {
	State = state;
}

public String getCompanyName() {
	return CompanyName;
}

public void setCompanyName(String companyName) {
	CompanyName = companyName;
}

public String getCompanyType() {
	return CompanyType;
}

public void setCompanyType(String companyType) {
	CompanyType = companyType;
}

public String getContractLength() {
	return ContractLength;
}

public void setContractLength(String contractLength) {
	ContractLength = contractLength;
}

public String getContactName() {
	return ContactName;
}

public void setContactName(String contactName) {
	ContactName = contactName;
}

public String getZipCode() {
	return ZipCode;
}

public void setZipCode(String zipCode) {
	ZipCode = zipCode;
}

public String getCity() {
	return City;
}

public void setCity(String city) {
	City = city;
}







}