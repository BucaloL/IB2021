package ib.T5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cryptoAESiRSA.AsymmetricEncription;
import cryptoAESiRSA.SymmetricAES;

@SpringBootApplication
//@EnableJpaRepositories
public class T5Application {

	public static void main(String[] args) {
		
		SymmetricAES test = new SymmetricAES();
		test.testIt();
		
		AsymmetricEncription test2 = new AsymmetricEncription();
		test2.testIt();
		
		SpringApplication.run(T5Application.class, args);
	}


}
