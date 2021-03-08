package com.tts.ecommerce.controllers;
import com.stripe.model.Charge;

import com.tts.ecommerce.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChargeController {
	
	@Autowired
	private StripeService paymentsService;
	
	@PostMapping("/charge")
	public String charge(ChargeRequest chargeRequest, Model model)throws StripeException {
		chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
		
		Charge charge = paymentService.charge(chargeRequest);
		
		model.addAttribute("id", charge.getId());
		model.addAllAttribute("status", charge.getStatus());
		model.addAllAttribute("chargesId", charge.getId());
		model.addAllAttribute("balance_transaction", charge.getBalanceTransaction());
		return "result";
	}
@ExceptionHandler(StripeException.class)
public String handleError(Model model, StripeException ex) {
	model.addAllAttribute("error", ex.getMassage());
	return "result";
}
}
