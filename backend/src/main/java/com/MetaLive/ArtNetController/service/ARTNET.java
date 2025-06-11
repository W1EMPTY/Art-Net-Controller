package com.MetaLive.ArtNetController.service;

import ch.bildspur.artnet.ArtNetClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

@Service
public class ARTNET {
    private byte[] dmxData = new byte[512];
    private ArtNetClient artNetClient = new ArtNetClient();

    @Value("${artnet.subNet}")
    private int subNet;

    @Value("${artnet.universe}")
    private int universe;

    @Value("${artnet.ip}")
    private String ip;

    // 数据库URL
    @Value("${database.url}")
    private String url;

    public ARTNET() {
        artNetClient.start();
    }

    // 每200毫秒查询一次数据库并发送数据（每秒5次）
    @Scheduled(fixedRate = 200)
    public void queryDatabaseAndSendData() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT dmxAddress, Brightness FROM lights WHERE status = '0'")) {
            
            // 遍历查询结果，并更新dmxData
            while (rs.next()) {
                int dmxAddr = rs.getInt("dmxAddress");
                int brightness = rs.getInt("Brightness");
//                System.out.println(dmxAddr+"\tBrightness"+brightness );
                dmxData[dmxAddr] = (byte) brightness;
                
            }
    
            // 将所有的 dmxData 一次性更新并发送
            artNetClient.unicastDmx(ip, 0, 0, dmxData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 销毁 Bean 时停止 ArtNetClient
    public void destroy() {
        artNetClient.stop();
    }
}
