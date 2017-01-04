/**
 * 
 */
package com.doj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	@RequestMapping("/accountList")
	public String accountList(Model model) {
		model.addAttribute("accounts", accountRepository.getAllAccounts());
		return "accountList";
	}
	
	@RequestMapping("/accountDetails")
	public String accountDetails(@RequestParam("number") String id, Model model) {
		model.addAttribute("account", accountRepository.getAccount(id));
		return "accountDetails";
	}
}
