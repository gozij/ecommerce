package com.tts.ecommerce.controllers;

import com.tts.ecommerce.model.ChargeRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class CheckoutController {
	@Value("${STRIPE_PUBLIC_KEY}")
	public String stringPublicKey;
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("amount", 50 * 100); 
		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("currency", ChargeRequest.Currency.USD);
		return "checkout";
	}

}
