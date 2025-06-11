package com.MetaLive.ArtNetController.Mapper;

import com.MetaLive.ArtNetController.model.Light;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LightMapper{

    @Select("SELECT * FROM lights WHERE id = #{id}")
    Light findById(int id);

    @Select("SELECT * FROM lights")
    List<Light> findAll();

    @Insert("INSERT INTO lights (brightness, dmxAddress, status) VALUES (#{brightness}, #{dmxAddress}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Light light);

    @Update("UPDATE lights SET brightness = #{brightness}, dmxAddress = #{dmxAddress}, status = #{status} WHERE id = #{id}")
    void update(Light light);
    
    /**
     * 更新灯光的亮度。
     *
     * @param brightness 亮度值
     * @param dmxAddress DMX 地址
     */
    @Update("UPDATE lights SET brightness = #{brightness} where dmxAddress = #{dmxAddress}")
    void updateBrightness(@Param("brightness")int brightness,@Param("dmxAddress")int dmxAddress );

    @Delete("DELETE FROM lights WHERE id = #{id}")
    void delete(int id);
}



