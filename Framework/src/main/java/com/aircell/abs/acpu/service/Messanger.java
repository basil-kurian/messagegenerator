package com.aircell.abs.acpu.service;

import com.aircell.abs.acpu.common.AcpuException;
import com.aircell.abs.acpu.common.AcpuMessage;
import com.aircell.abs.acpu.framework.AcpuSendQueue;
import com.aircell.abs.acpu.framework.message.Message;

import java.io.Serializable;

/**
 * Created by che36539 on 2/10/2016.
 */
public interface Messanger {

    void sendMessage(Message<?> message) throws AcpuException;

    void sendMessage(Message<?> message, Boolean lastMsg) throws AcpuException;

    Serializable sendSyncMessage(Message<?> message) throws AcpuException;

    Serializable sendSyncMessage(Message<?> message, Boolean lastMsg) throws AcpuException;

    AcpuMessage getMessageType();

    AcpuSendQueue getSendQueue() throws AcpuException;

}
