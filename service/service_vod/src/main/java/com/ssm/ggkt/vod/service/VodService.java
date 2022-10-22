package com.ssm.ggkt.vod.service;


import org.springframework.stereotype.Service;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/21 11:53
 */

public interface VodService  {
    String uploadVideo();

    void removeVideoById(String fieldId);

}
