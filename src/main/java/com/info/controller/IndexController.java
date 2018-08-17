package com.info.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-02 上午 11:26
 **/

@Controller
public class IndexController {

    private static final ConcurrentHashMap<String, Object> userInfo = new ConcurrentHashMap<>();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("username", "张三");
        return "indexPage";
    }

    @ResponseBody
    @PostMapping("/login")
    public Map save(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> resltMap = new HashMap<>(16);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            resltMap.put("code", -1);
            resltMap.put("msg", "用户名或密码为空");
            return resltMap;
        }
        if (userInfo.get(username) == null) {
            resltMap.put("code", -1);
            resltMap.put("msg", "用户名不存在");
        } else if (!userInfo.get(username).equals(password)) {
            resltMap.put("code", -2);
            resltMap.put("msg", "密码错误");
        } else {
            resltMap.put("code", 00);
            resltMap.put("msg", "登录成功");
        }
        return resltMap;
    }

    @ResponseBody
    @PostMapping("/regist")
    public Map regist(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> resltMap = new HashMap<>(16);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            resltMap.put("code", -1);
            resltMap.put("msg", "用户名或密码为空");
            return resltMap;
        }
        if (userInfo.get(username) != null) {
            resltMap.put("code", -2);
            resltMap.put("msg", "该用户名已经存在");
            return resltMap;
        }
        resltMap.put("code", 00);
        resltMap.put("msg", "regist success.......");
        userInfo.put(username, password);
        return resltMap;
    }

    @ResponseBody
    @PostMapping("/uploadFace")
    public Map uploadFace(@RequestParam("file") MultipartFile files) throws Exception {
        // 文件保存的命名空间
        String fileSpace = "C:/imooc_videos_dev";
        // 保存到数据库中的相对路径
        String uploadPathDB = "/face";
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null) {
                String fileName = files.getOriginalFilename();
                if (!StringUtils.isEmpty(fileName)) {
                    // 文件上传的最终保存路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);
                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
       /* Users user = new Users();
        user.setId(userId);
        user.setFaceImage(uploadPathDB);
        userService.updateUserInfo(user);*/
        return null;
    }

}
