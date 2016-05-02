package com.aircell.abs.acpu.videoservice;

import com.aircell.abs.acpu.common.AcpuMessage;
import com.aircell.abs.acpu.common.AcpuQueues;
import com.aircell.abs.service.ServiceMessenger;

/**
* Created by che36539 on 2/11/2016.
        */
public class VideoMessenger extends ServiceMessenger {

    @Override
    public boolean isSyncMessage() {
        return videoMessage.isSyncMessage();
    }

    public enum VideoMessage {

        VSM_OPER_STATUS_CHANGE          (AcpuMessage.VSM_OPER_STATUS_CHANGE),
        CLD_USB_PLUGGED_OUT             (AcpuMessage.CLD_USB_PLUGGED_OUT),
        HDD_DATA_MUA                    (AcpuMessage.HDD_DATA_MUA,  Boolean.TRUE),
        SYNCH_CANCEL_MUA                (AcpuMessage.SYNCH_CANCEL_MUA),
        MEDIA_TITLES_INFO               (AcpuMessage.MEDIA_TITLES_INFO, Boolean.TRUE),
        MEDIA_TX_STATS                  (AcpuMessage.MEDIA_TX_STATS, Boolean.TRUE),
        CLD_USB_PLUGGED_IN              (AcpuMessage.CLD_USB_PLUGGED_IN),
        SEND_PSS_TRAPS                  (AcpuMessage.SEND_PSS_TRAPS, Boolean.TRUE),
        EVENT_POSTED                    (AcpuMessage.EVENT_POSTED);


        private AcpuMessage acpuMessage;
        private Boolean isSyncMessage;
        private VideoMessage(AcpuMessage acpuMessage, Boolean isSyncMessage){
            this.acpuMessage = acpuMessage;
            this.isSyncMessage = isSyncMessage;
        }

        VideoMessage(AcpuMessage acpuMessage){
            this(acpuMessage,Boolean.FALSE);
        }

        public AcpuMessage getAcpuMessage() {
            return acpuMessage;
        }

        public Boolean isSyncMessage() {
            return isSyncMessage;
        }
    }

    private VideoMessage videoMessage;
    VideoMessenger(VideoMessage videoMessage){
        super(AcpuQueues.GGV_VIDEO_QUEUE);
        this.videoMessage = videoMessage;
    }

    public void setVideoMessage(VideoMessage videoMessage) {
        this.videoMessage = videoMessage;
    }

    @Override
    public AcpuMessage getMessageType() {
        return videoMessage.getAcpuMessage();
    }

}
