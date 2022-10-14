package com.ssm.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/14 10:47
 */
public interface FileService {
    String upload(MultipartFile file);
}
