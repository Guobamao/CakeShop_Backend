package com.scauzj.controller;

import com.scauzj.entity.Result;
import com.scauzj.util.AliOSSUtils;
import com.scauzj.vo.UploadVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin/upload")
@Slf4j
@Tag(name = "上传相关接口")
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping
    @Operation(summary = "上传图片")
    public Result upload(MultipartFile image) throws IOException {
        log.info("上传图片：image={}", image.getOriginalFilename());

        // 调用阿里云OSS工具类上传文件
        UploadVO uploadVO = aliOSSUtils.upload(image);
        log.info("文件上传成功，url={}", uploadVO);
        return Result.success(uploadVO);
    }
}
