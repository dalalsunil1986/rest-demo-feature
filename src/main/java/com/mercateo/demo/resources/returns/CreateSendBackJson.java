package com.mercateo.demo.resources.returns;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercateo.demo.feature.Feature;
import com.mercateo.demo.feature.KnownFeatureId;
import com.mercateo.demo.resources.CARRIER;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CreateSendBackJson {
	@NotNull
	private String message;

	@Feature(KnownFeatureId.TICKET_6)
	private CARRIER preferredCarrier;

	public CreateSendBackJson(@JsonProperty("message") String message) {
		super();
		this.message = message;
	}
}