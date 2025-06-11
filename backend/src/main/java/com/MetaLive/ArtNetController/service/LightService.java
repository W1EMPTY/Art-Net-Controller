package com.MetaLive.ArtNetController.service;

import com.MetaLive.ArtNetController.Mapper.LightMapper;
import com.MetaLive.ArtNetController.model.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LightService {

    @Autowired
    private LightMapper lightMapper;

    public Light findLightById(int id) {
        return lightMapper.findById(id);
    }

    public List<Light> findAllLights() {
        return lightMapper.findAll();
    }

    public void createLight(Light light) {
        lightMapper.insert(light);
    }

    public void updateLight(Light light) {
        lightMapper.update(light);
    }
    public void UpdateBrightness(int brightness ,int dmxAddress){
        lightMapper.updateBrightness(brightness,dmxAddress);
    }

    public void deleteLight(int id) {
        lightMapper.delete(id);
    }
}
