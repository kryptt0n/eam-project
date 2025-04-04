package com.eam.account_transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountTransactionApplication.class, args);
	}

}
