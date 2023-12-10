package org.springframework.samples.petclinic.owner;
//package org.springframework.samples.petclinic.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.model.User;

//import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
class UserController {

	private final UserRepository users;

	UserController(UserRepository users) {
		this.users = users;
	}

	@GetMapping("/register")
	public String register(User user) {

		return "register";
	}


    @PostMapping("/login")
	public String login(String username,String password/*,BindingResult result*/,Model model) {

		User usersResults = users.findByUsername(username);
		/*if (ObjectUtils.isEmpty(usersResults)) {
			return "login";
		} else {

			if (usersResults.getPassword().equals(password)) {
				return "welcome";
			} else {
				return "login";
			}
		}*/
		if(ObjectUtils.isEmpty(usersResults)||!(usersResults.getPassword().equals(password))){
			model.addAttribute("msg1", 1);
			//result.rejectValue("lastName", "notFound", "not found");
			return "login";
		} else {
			return "welcome";
		}

	}

}

