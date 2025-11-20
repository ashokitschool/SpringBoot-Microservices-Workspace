package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserInfo;
import in.ashokit.repo.UserInfoRepository;

@Service
public class UserService {

	@Autowired
	private UserInfoRepository userInfoRepo; // impl obj will come here

	public void test() {
		String impl = userInfoRepo.getClass().getName();
		System.out.println("Repo impl class name :: " + impl);
	}

	public void saveUser() {

		UserInfo u = new UserInfo();
		u.setName("Cathy");
		u.setGender("Fe-Male");
		u.setCountry("CANADA");
		u.setAge(45);

		userInfoRepo.save(u);

		System.out.println("User Saved...");
	}

	public void getUserById(Integer uid) {
		Optional<UserInfo> byId = userInfoRepo.findById(uid);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

	public void getAllUsers() {
		Iterable<UserInfo> all = userInfoRepo.findAll();
		all.forEach(System.out::println);
	}

	public void callFindByMethods() {

		// List<UserInfo> list = userInfoRepo.findByGender("Male");

		// List<UserInfo> list = userInfoRepo.findByCountryAndGender("CANADA",
		// "Fe-Male");

		List<UserInfo> list = userInfoRepo.findByAgeGreaterThanEqual(30);

		list.forEach(System.out::println);
	}

	public void executeNativeQueries() {

		List<UserInfo> list = userInfoRepo.m1();

		list.forEach(System.out::println);
	}

	public void executeHQL() {

		/*
		 * List<UserInfo> list = userInfoRepo.m2();
		 * 
		 * list.forEach(System.out::println);
		 */

		userInfoRepo.m3(101);
	}

}
