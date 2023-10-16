package com.ubsvirtual.UbsVirtual;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UbsVirtualApplication implements CommandLineRunner {

    public UbsVirtualApplication() {
    }

    public static void main(String[] args) {
		SpringApplication.run(UbsVirtualApplication.class, args);
	}

	@Override
	public void run(String... args) {
	}
}
