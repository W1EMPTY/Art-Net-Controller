package com.MetaLive.ArtNetController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
@MapperScan("com.MetaLive.ArtNetController.Mapper")
public class ArtNetControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtNetControllerApplication.class, args);
	}

}
