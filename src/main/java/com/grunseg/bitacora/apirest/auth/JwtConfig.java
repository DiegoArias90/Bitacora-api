package com.grunseg.bitacora.apirest.auth;

public class JwtConfig {
	
	public static final String KEY_SECRET = "GRUNSEG2021_BITACORA";
	
	public static final String RSA_PRI = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpQIBAAKCAQEAyYSF1/7DBIswiaBbTxP0JuCdxxYAB/WYEosl6wkZlnGIgK09\r\n"
			+ "F+hY8wrRO28M8CczsCN0tLl6sjeqT7Pyjs3h+9gr4ZS2bB3GBaKc+yXoLhWX9bWT\r\n"
			+ "g5UsxVL+uxoNjiT4rol28d9TSo0mCojDATfdeAQ/NWOgd1jxfwjSPqz0nz5TW/IA\r\n"
			+ "Brwj0t5jvcuGNVFk/jRDjSQt3qZ7Hm75C2aQftha48hS6CmzxyMU3ZETXbgU4sCg\r\n"
			+ "rp/kUCHsh8m+ZJKROdjUrMWRMHiBm2bPvHECe0aGeS3fnfIm3R9Pb0KHwr5zYXbT\r\n"
			+ "am4yyPXro0VhRioHpaM1hApqWzTe26FQqZfrcQIDAQABAoIBAQCZzg/pv4RRH3s4\r\n"
			+ "T6/hNzWNxroljWEQsh4TaSjTrupcrOKmc5LBgJEDTypK1oNleEY3FZippzdCdsIC\r\n"
			+ "ezGSVQk6Es/LKJnjAwZ0npx6A4CmS8zjuGaSc3TsVmAdpdDawNUdQcYK7YzAxeJW\r\n"
			+ "//L2JxFd3L/xm8yJytTnRHBTbeZ28to2Jj+ERCGKoPmZtPENDt2sYqnOuGq06WQ9\r\n"
			+ "CuI5h1UzHaM8PrveIlmE8iPQMWmk5GqS6A+6HQsF6ZGm/BJvALowOmCsCEq/y6IS\r\n"
			+ "+WW3n8MUL201JXCMs4TXQuoOs9I6576BievIiJro9REG0guRJLIXmGhHmzfKXJku\r\n"
			+ "Z3WM1IURAoGBAPypLG1RQchhT39kZUO3zNKSPT4HDm9hDg3Yjnes6kn57BqdQZC+\r\n"
			+ "gTdPpWYHy9IXmgkiDAOl0yZtrqaKKpvH0B2wtJjkb3kCu1a5o2a+GqzMJMlJZdXm\r\n"
			+ "FPqueBkhzloaKXwpbKImyj2SAGhDXNfTX7MMFNt7WKmmf2B6YIZ8G63vAoGBAMwu\r\n"
			+ "URm1Jvdc/dkYsg1/v+0dnhntVVe8XIp5SUNrVXJrMhv9ZBleQmUh66dUlk2/+btN\r\n"
			+ "UBqTrTWWrlt2enaCtAh2l1eHrm/Bsm5DAdM8qpU1WkZoAQCY6QSTVbUDyWCUFFrE\r\n"
			+ "Sj3xtdUl2D+yBolPKwXSo59fNfZ6LZVqcRABa1yfAoGAcOeQSNF02fxSMBVHAznR\r\n"
			+ "N4/N+jfhBXiTdTB+iZAlqiUaktIPCIV47KSUvsFhHWManFYwlDi34IZG83jujWp+\r\n"
			+ "36WlLmV2QtcrrBeMo070UJ9xGNnJvgnw+gyY8nIe6jiirS89skAvQ9BIik7/4Bo+\r\n"
			+ "u538fA/kkPssFIrbM32mSNUCgYEAhwqnJvqSEA6X8gsMUDNK6/enxnwa8tEo34kC\r\n"
			+ "NK37sJZHaQ25M7IM9bhulJg0ZK3w7LlgnoNHjube4K1Gp7Ugf2x4AjNB4rZYXebB\r\n"
			+ "gUVhiRflYiWNbCi2DQmpKPSdLtwhbjre44NHAPdrxAzpl80dplc/Urv1A9Sg626f\r\n"
			+ "4rcdm/8CgYEAr8aYND5gIXEmoCoMot0twD5jGuRVhvwR8JKOkuNSn1zFcsQCjV8u\r\n"
			+ "+8mN1Lz+7WcDgmkrHI39lDPiieO6qdJOUl3A7VzyXWXKHQFpzFybSRhSgBNURKPu\r\n"
			+ "lQ/w3L6Or9/FSa0yiyGpXAZsuYVX7xRao6OzQqe7Ywp65w8jtgbtVHw=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUB = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyYSF1/7DBIswiaBbTxP0\r\n"
			+ "JuCdxxYAB/WYEosl6wkZlnGIgK09F+hY8wrRO28M8CczsCN0tLl6sjeqT7Pyjs3h\r\n"
			+ "+9gr4ZS2bB3GBaKc+yXoLhWX9bWTg5UsxVL+uxoNjiT4rol28d9TSo0mCojDATfd\r\n"
			+ "eAQ/NWOgd1jxfwjSPqz0nz5TW/IABrwj0t5jvcuGNVFk/jRDjSQt3qZ7Hm75C2aQ\r\n"
			+ "ftha48hS6CmzxyMU3ZETXbgU4sCgrp/kUCHsh8m+ZJKROdjUrMWRMHiBm2bPvHEC\r\n"
			+ "e0aGeS3fnfIm3R9Pb0KHwr5zYXbTam4yyPXro0VhRioHpaM1hApqWzTe26FQqZfr\r\n"
			+ "cQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
