package com.aircell.abs.acpu.service;

import com.aircell.abs.acpu.common.AcpuException;
import com.aircell.abs.acpu.common.AcpuQueues;
import com.aircell.abs.acpu.framework.AcpuSendQueue;
import com.aircell.abs.acpu.framework.message.Message;


import java.io.Serializable;

/**
 * Created by che36539 on 2/10/2016.
 */
public abstract class GenericMessanger implements Messanger {

    private final AcpuQueues acpuQueue;

    protected GenericMessanger(AcpuQueues acpuQueue){
        this.acpuQueue = acpuQueue;
    }

    private Object checkConstraints(Message<?> message) throws AcpuException{
        if (message == null ) throw new AcpuException("Null Message");
        return message.message();
    }

    public AcpuSendQueue getSendQueue() throws AcpuException {
        return new AcpuSendQueue(acpuQueue);
    }

    public void sendMessage(Message<?> message, Boolean lastMsg) throws AcpuException {

        Object obj = checkConstraints(message);
        if( obj instanceof String ){
            getSendQueue().sendMessage(getMessageType(),(String)obj, lastMsg);
        }else if ( obj instanceof Serializable ) {
            getSendQueue().sendMessage(getMessageType(), (Serializable) obj, lastMsg);
        }else {
            throw new AcpuException("Unsupported Message type");
        }
    }

    public void sendMessage(Message<?> message) throws AcpuException {
        sendMessage(message, Boolean.TRUE);
    }

    public Serializable sendSyncMessage(Message<?> message , Boolean lastMsg) throws AcpuException{

        Object obj = checkConstraints(message);
        if ( obj instanceof Serializable ) {
            //noinspection unchecked
            return getSendQueue().sendSyncMessage(getMessageType(), ((Message<Serializable>) message).message(), lastMsg);
        }
        throw new AcpuException("Unsupported Message Type");
    }

    public Serializable sendSyncMessage(Message<?> message ) throws AcpuException {
        return sendSyncMessage(message, Boolean.TRUE);
    }

}
