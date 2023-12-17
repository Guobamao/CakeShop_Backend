package com.scauzj.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UploadVO implements Serializable {
    private String name;
    private String url;
}
