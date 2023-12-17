package com.scauzj.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.scauzj.vo.UploadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOSSUtils {
    @Autowired
    private AliOSSProperties aliOSSProperties;
    /**
     * 实现上传图片到到OSS
     */
    public UploadVO upload(MultipartFile file) throws IOException {
        String endpoint = aliOSSProperties.getEndpoint();
        EnvironmentVariableCredentialsProvider credentialsProvider = aliOSSProperties.getCredentialsProvider();
        String bucketName = aliOSSProperties.getBucketName();
        // 获取上传的文件输入流
        InputStream inputStream = file.getInputStream();

        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream);
        ossClient.putObject(putObjectRequest);

        // 文件访问路径
        // https://web-tlias-009.oss-cn-beijing.aliyuncs.com/1.jpg
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

        UploadVO uploadVO = UploadVO.builder()
                .name(fileName)
                        .url(url)
                                .build();
        // 关闭OssClient
        ossClient.shutdown();

        return uploadVO; // 返回文件访问路径
    }

}
