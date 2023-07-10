package Authentication;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Facker {
	@Test
	public void fackerdata() {
		Faker faker = new Faker();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String fullname = faker.name().fullName();
		String password = faker.internet().password();
		String emailaddress = faker.internet().emailAddress();
		String domainname = faker.internet().domainName();
		System.out.println("Firstname" + firstname);
		System.out.println("Lastname" + lastname);
		System.out.println("FullName" + fullname);
		System.out.println("Password" + password);
		System.out.println("EmailAddress" + emailaddress);
		System.out.println("DomainName" + domainname);

	}

}
