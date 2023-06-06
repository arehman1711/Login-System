package com.example.LearningKart.controller;



import com.example.LearningKart.entities.ContactUs;
import com.example.LearningKart.entities.User;
import com.example.LearningKart.repository.ContactUsRepository;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Data
@Controller
@Slf4j
public class Contactus {

	@Autowired
	private ContactUsRepository contactUsRepository;
	@GetMapping(value = "/contactus")
	public String contactus(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if(Objects.nonNull(user)){
			model.addAttribute("contactUs", new ContactUs(0,user.getName(), user.getEmail(),""));
		} else {
			model.addAttribute("contactUs", new ContactUs());
		}
		model.addAttribute("title", "Contact US");
		log.info("loading Contact us..!");
		return "contactus";
	}

	@RequestMapping(value = "/submit-contactus", method = RequestMethod.POST)
	public String submitContactus(@ModelAttribute("contactUs") ContactUs contactUs, Model model) {
		contactUsRepository.save(contactUs);
		model.addAttribute("contactus", "Message sent successfully.");
		log.info("Message sent successfully.");
		return "contactus";
	}

}
