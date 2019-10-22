package com.fenix.jmstst.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {
    // template
    @Autowired
    JmsTemplate jmsTemplate;
    // 队列目的地
//    @Resource(name = "queueDestination")

    //主题目的地
    @Resource(name = "topicDestination")
    Destination destination;

    public void sendMessage(final String msg) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                //会话创建 message
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
        System.out.println("发送消息：" + msg);
    }
}
