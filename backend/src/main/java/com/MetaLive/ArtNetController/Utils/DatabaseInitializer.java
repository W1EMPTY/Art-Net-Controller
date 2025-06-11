package com.MetaLive.ArtNetController.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class DatabaseInitializer  {
   public  static  void initializeDatabase() throws  Exception{
       String targetDbPath = "db/database.db";
       File dbFile = new File(targetDbPath);
       
       if (!dbFile.exists()){
           InputStream dbStream = DatabaseInitializer.class.getResourceAsStream("/db/database.db");
           if (dbStream == null){
               throw new IllegalStateException("Cannot find database resource in JAR.");
           }
           Files.createDirectories(dbFile.getParentFile().toPath());
           try(FileOutputStream outputStream = new FileOutputStream(dbFile)){
               byte[] buffer = new byte[8192];
               int bytesRead;
               while ((bytesRead = dbStream.read(buffer)) != -1) {
                   outputStream.write(buffer, 0, bytesRead);
               }
           }catch ( IOException e){
               throw new RuntimeException("Failed to copy database file to local directory.", e);
           }finally {
               // 关闭输入流
               try {
                   dbStream.close();
               } catch (IOException e) {
                   System.err.println("Failed to close InputStream: " + e.getMessage());
               }
           }
       }
       
   }

    }
