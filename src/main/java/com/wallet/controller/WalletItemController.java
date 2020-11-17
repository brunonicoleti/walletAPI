package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.WalletItemDTO;
import com.wallet.entity.WalletItem;
import com.wallet.response.Response;
import com.wallet.service.WalletItemService;

@RestController
@RequestMapping("wallet-item")
public class WalletItemController {

	@Autowired
	private WalletItemService service;
	
	@PostMapping
	public ResponseEntity<Response<WalletItemDTO>> create(@Valid @RequestBody WalletItemDTO dto, BindingResult result) {
		
		Response<WalletItemDTO> response = new Response<WalletItemDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		WalletItem wi = service.save(this.convertDtoToEntity(dto));
	}
}
