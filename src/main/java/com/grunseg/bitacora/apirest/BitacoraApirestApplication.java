package com.grunseg.bitacora.apirest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BitacoraApirestApplication  {
	
	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/

	public static void main(String[] args) {
		SpringApplication.run(BitacoraApirestApplication.class, args);
	}
	
	/*@Override
	public void run(String... args) throws Exception {
		String password = "123456";
		
		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
		
	}*/

}
