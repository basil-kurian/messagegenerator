package com.aircell.abs.acpu.healthservice;

import com.aircell.abs.acpu.common.AcpuMessage;
import com.aircell.abs.acpu.common.AcpuQueues;
import com.aircell.abs.service.ServiceMessenger;
/**
 * Created by che36539 on 2/10/2016.
 */
public class GGVHSSMessanger extends ServiceMessenger{

    @Override
    public boolean isSyncMessage() {
        return ggvhssmessage.getIssyncMessage();
    }

    public static enum GGVHSSMessage {
        GET_VIDEO_HDD_DATA                  (AcpuMessage.GET_VIDEO_HDD_DATA             , Boolean.TRUE),
        GET_ACPU_OPER_STATE                 (AcpuMessage.GET_ACPU_OPER_STATE            , Boolean.TRUE),
        GET_SNMP_TRAPS                      (AcpuMessage.GET_SNMP_TRAPS                 , Boolean.TRUE),
        SEND_TRAPS                          (AcpuMessage.SEND_TRAPS                     , Boolean.TRUE),
        CLD_USB_VALIDATION_FAILURE          (AcpuMessage.CLD_USB_VALIDATION_FAILURE)    ,
        SET_ACPU_VIDEO_BATCH_VERSION        (AcpuMessage.SET_ACPU_VIDEO_BATCH_VERSION)  ,
        GET_ACPU_BATCH_VERSION              (AcpuMessage.GET_ACPU_BATCH_VERSION         , Boolean.TRUE),
        UPDATE_HDD_DISK_OCCUPANCY           (AcpuMessage.UPDATE_HDD_DISK_OCCUPANCY)     ,
        VIDEO_CLIENT_COUNT                  (AcpuMessage.VIDEO_CLIENT_COUNT)            ,
        MEDIA_FILE_READ_ERROR               (AcpuMessage.MEDIA_FILE_READ_ERROR)         ,
        UPDATE_MO                           (AcpuMessage.UPDATE_MO)                     ,
        EVENT_POSTED                        (AcpuMessage.EVENT_POSTED)                  ,
        ASP_ERROR                           (AcpuMessage.ASP_ERROR)                     ;

        private final AcpuMessage acpuMessage;
        private final Boolean issyncMessage;

        private GGVHSSMessage(AcpuMessage acpuMessage, Boolean issyncMessage){
            this.acpuMessage = acpuMessage;
            this.issyncMessage = issyncMessage;
        }

        private GGVHSSMessage(AcpuMessage acpuMessage){
            this(acpuMessage, Boolean.FALSE);
        }

        public AcpuMessage getAcpuMessage(){
            return acpuMessage;
        }

        public Boolean getIssyncMessage() {
            return issyncMessage;
        }

        public String getMessage(){
            return acpuMessage.getMessage();
        }
    }

    private GGVHSSMessage ggvhssmessage;

    public GGVHSSMessanger(GGVHSSMessage ggvhssmessage) {
        super( AcpuQueues.GGV_HEALTH_STATUS_QUEUE );
        this.ggvhssmessage = ggvhssmessage;
    }

    public AcpuMessage getMessageType() {
        return ggvhssmessage.getAcpuMessage();
    }

    public void setMessage(GGVHSSMessage ggvhssmessage) {
        this.ggvhssmessage = ggvhssmessage;
    }

}
