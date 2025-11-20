package in.ashokit.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;
import in.ashokit.repo.PassportRepo;
import in.ashokit.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private PassportRepo passportRepo;

	// insert person with passport

	public void savePersonWithPassport() {

		Passport passport = new Passport();
		passport.setPassportNum("ABC68686");
		passport.setIssuedDate(LocalDate.now());
		passport.setExpDate(LocalDate.now().plusYears(10));

		Person person = new Person();
		person.setPersonName("Ashok");
		person.setDob(LocalDate.now().minusYears(30));

		// association mapping
		person.setPassport(passport);
		passport.setPerson(person);

		// saving data
		personRepo.save(person);

	}

	public void getPerson(int personId) {
		personRepo.findById(personId);
	}

	public void getPassport(int passportId) {
		passportRepo.findById(passportId);
	}
	
	public void deletePassport(int passportId) {
		
		passportRepo.deleteAll();
	}

	public void deletePerson(int id) {
		personRepo.deleteById(id);
	}

}
