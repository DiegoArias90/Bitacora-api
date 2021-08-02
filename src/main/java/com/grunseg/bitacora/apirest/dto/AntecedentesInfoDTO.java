package com.grunseg.bitacora.apirest.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AntecedentesInfoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("error")
	private String error;
	@JsonProperty("identity")
	private String identity;
	@JsonProperty("name")
	private String name;
	@JsonProperty("antecedent")
	private String antecedent;
	@JsonProperty("seclusion")
	private String seclusion;
	@JsonProperty("idr")
	private String idr;
	@JsonProperty("type")
	private String type;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAntecedent() {
		return antecedent;
	}

	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}

	public String getSeclusion() {
		return seclusion;
	}

	public void setSeclusion(String seclusion) {
		this.seclusion = seclusion;
	}

	public String getIdr() {
		return idr;
	}

	public void setIdr(String idr) {
		this.idr = idr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}