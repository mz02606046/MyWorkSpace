package com.marck.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class Jpush {

	protected static final Logger LOG = LoggerFactory.getLogger(Jpush.class);

    // demo App defined in resources/jpush-api.conf 
	private static final String appKey ="5ee081a122c2862792b0e5c8";
	private static final String masterSecret = "0fdd15ac517ea03f2276ca1d";
	
	public static void SendPush(String id,String content) {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
        
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = sendIosByRegesterId(id,content);
        
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
	}
	
	public static PushPayload sendIosByRegesterId(String id,String content){
		return PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag("wenzhuan"+id))
				.setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(content).setSound("happy").build()).build())
				.setOptions(Options.newBuilder()
                         .setApnsProduction(true)
                         .build())
                .build();
	}
	
}
