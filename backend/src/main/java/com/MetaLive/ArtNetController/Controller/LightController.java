package com.MetaLive.ArtNetController.Controller;

import ch.bildspur.artnet.ArtNetClient;
import com.MetaLive.ArtNetController.model.BrightnessUpdateRequest;
import com.MetaLive.ArtNetController.model.Light;
import com.MetaLive.ArtNetController.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ArtNet")
public class LightController {
    private byte[] dmxData;
    @Autowired
    private LightService lightService;
    private ArtNetClient artNetClient;
    @GetMapping("/lights")
    public ResponseEntity<List<Light>> getAllLights() {
        List<Light> lights= lightService.findAllLights();
        return ResponseEntity.ok(lights);
    }
    @PostMapping("/updateBrightness")
    public ResponseEntity<List<Light>> updateBrightness(@RequestBody BrightnessUpdateRequest lightsUpdatePara ) {
        //改为使用json传值
        int brightness = lightsUpdatePara.getBrightness();
        List<Integer> dmxAddrList = lightsUpdatePara.getDmxAddrList();
        //遍历 DMX 地址列表，更新每个灯光的亮度
        try {
            for (Integer dmxAddr : dmxAddrList) {
                System.out.println(dmxAddr);
                lightService.UpdateBrightness(brightness, dmxAddr);
            }
        }catch (Exception e) {
                // 处理异常情况（可选）
                e.printStackTrace();
        }
        List<Light> lights = lightService.findAllLights();
        return ResponseEntity.ok(lights);
    }
  
    

//    @PostMapping
//    public ResponseEntity<Light> createLight(@RequestBody Light light) {
//        Light createdLight = lightService.save(light);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdLight);
//    }

    // 其他API端点
}
