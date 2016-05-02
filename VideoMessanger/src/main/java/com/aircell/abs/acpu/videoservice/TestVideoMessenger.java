package com.aircell.abs.acpu.videoservice;

import com.aircell.abs.acpu.common.AcpuException;
import com.aircell.abs.acpu.framework.message.ObjectMessage;
import com.aircell.abs.acpu.framework.message.StringMessage;

import java.io.Serializable;

/**
 * Created by che36539 on 2/12/2016.
 */
public class TestVideoMessenger {

    public static void main(String[] args) throws AcpuException {
        VideoMessenger messenger = new VideoMessenger(VideoMessenger.VideoMessage.MEDIA_TITLES_INFO);
        messenger.sendSyncMessage(new StringMessage() {
            @Override
            public String message() {
                return "";
            }
        });
    }
}
