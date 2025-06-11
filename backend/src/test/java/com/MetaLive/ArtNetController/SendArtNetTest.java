package com.MetaLive.ArtNetController;

import ch.bildspur.artnet.ArtNetClient;
import com.MetaLive.ArtNetController.model.Light;
import com.MetaLive.ArtNetController.service.LightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
@SpringBootTest
public class SendArtNetTest {
        private byte[] dmxData = new byte[512];
        private ArtNetClient artNetClient = new ArtNetClient();
        private int SubNet;
        private int Universe;
        @Autowired
        private LightService lightService;
        @Test
        public void doSend(){
            dmxData[0]= (byte) 255;
            artNetClient.start();
            artNetClient.unicastDmx("192.168.3.95",0,0,dmxData);
            artNetClient.stop();
        }
        @Test
        public void CreateSQLite(){
            String url = "jdbc:sqlite:src/main/resources/db/database.db";
            String sql = "CREATE TABLE IF NOT EXISTS lights (\n"
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " Brightness INTEGER NOT NULL,\n"
                    + " dmx_address INTEGER NOT NULL,\n"
                    + " status TEXT NOT NULL\n"
                    + ");";
            try(Connection connection = DriverManager.getConnection(url);
                Statement statement =connection.createStatement()){
                statement.execute(sql);
                System.out.println("Table created successfully.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
     
        
}
