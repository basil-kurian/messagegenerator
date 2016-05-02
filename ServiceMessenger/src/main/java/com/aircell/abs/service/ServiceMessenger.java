package com.aircell.abs.service;

import com.aircell.abs.acpu.common.AcpuException;
import com.aircell.abs.acpu.common.AcpuMessage;
import com.aircell.abs.acpu.common.AcpuQueues;
import com.aircell.abs.acpu.framework.message.Message;
import com.aircell.abs.acpu.service.GenericMessanger;

import java.io.Serializable;

/**
 * Created by che36539 on 2/11/2016.
 */
public abstract class ServiceMessenger extends GenericMessanger{

    protected ServiceMessenger(AcpuQueues acpuQueue) {
        super(acpuQueue);
    }

    public abstract boolean isSyncMessage();

    @Override
    public void sendMessage(Message<?> message, Boolean lastMsg) throws AcpuException {
        if (isSyncMessage()) throw new AcpuException("Invalid Operation! "+ getMessageType() +" is sync message");
        super.sendMessage(message, lastMsg);
    }

    @Override
    public Serializable sendSyncMessage(Message<?> message, Boolean lastMsg) throws AcpuException {
        if (!isSyncMessage()) throw new AcpuException("Invalid Operation! "+ getMessageType() +" is not sync message");
        return super.sendSyncMessage(message, lastMsg);
    }

}
