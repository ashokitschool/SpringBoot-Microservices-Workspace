package in.ashokit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entity.UserInfo;
import in.ashokit.repo.UserInfoRepository;

@Service
public class UserService {

	@Autowired
	public UserInfoRepository userRepo;

	@Transactional(rollbackFor = IOException.class)
	public void saveUsers() throws Exception {

		UserInfo u1 = new UserInfo();
		u1.setName("John");
		u1.setGender("Male");
		u1.setCountry("India");
		u1.setAge(20);

		userRepo.save(u1);

		int i = 10;

		if (i > 1) {
			throw new IOException("File Issue");
		}

		UserInfo u2 = new UserInfo();
		u2.setName("John");
		u2.setGender("Male");
		u2.setCountry("India");
		u2.setAge(20);

		userRepo.save(u2);

	}

	public void getUserswithSort() {

		Sort sort = Sort.by("age", "gender").descending();

		List<UserInfo> users = userRepo.findAll(sort);

		users.forEach(System.out::println);

	}

	public void getUserswithPagination() {

		Integer pageNum = 2; // we will get from UI
		Integer pageSize = 3; // it is fixed

		PageRequest pageReq = PageRequest.of(pageNum - 1, pageSize);

		Page<UserInfo> page = userRepo.findAll(pageReq);

		List<UserInfo> users = page.getContent();

		users.forEach(System.out::println);

	}

	public void qbe() {

		UserInfo user = new UserInfo();
		user.setGender("Male");
		user.setCountry("India");

		Example<UserInfo> of = Example.of(user);
		List<UserInfo> usersList = userRepo.findAll(of);

		usersList.forEach(System.out::println);
	}
}
