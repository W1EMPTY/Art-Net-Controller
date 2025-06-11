package com.MetaLive.ArtNetController;

import com.MetaLive.ArtNetController.Mapper.LightMapper;
import com.MetaLive.ArtNetController.model.Light;
import com.MetaLive.ArtNetController.service.LightService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@MapperScan()
class ArtNetControllerApplicationTests {
	@Autowired
	DataSource dataSource;
	@Autowired
	LightService lightService;
	@Test
	void contextLoads() {
		System.out.println(dataSource.getClass());
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(connection);

		//template模板，拿来即用
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
//		@Test
//	public  void  InsertSqlite(){
//		for (int i = 0; i <50; i++) {
//			Light light =new Light(i,0,i,"0");
//			lightService.createLight(light);
//		}
//	}
	
//	@Test
//	public void  UpdateLights(){
//		List<Light> lights = lightService.findAllLights();
//		int i=0;
//		for (Light l:lights
//			 ) {
//			l.setDmxAddress(i);
//			i+=1;
//			lightService.updateLight(l);
//		}
//	}
}
