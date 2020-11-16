package com.wallet.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletItemDTO {

	private Long id;
	@NotNull(message = "Insira o id da carteira.")
	private Long wallet;
	@NotNull(message = "Informe uma data.")
	private Date date;
	@NotNull(message = "Informe um tipo.")
	private String type;
	@NotNull(message = "Informe uma descricao.")
	@Length(min = 5, message = "A descricao deve conter no minimo 5 caracteres.")
	private String description;
	@NotNull(message = "Infome um valor.")
	private BigDecimal value;
}
