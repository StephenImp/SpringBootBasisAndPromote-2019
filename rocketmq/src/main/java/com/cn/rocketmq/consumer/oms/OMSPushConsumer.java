package com.cn.rocketmq.consumer.oms;

import io.openmessaging.Message;
import io.openmessaging.MessagingAccessPoint;
import io.openmessaging.OMS;
import io.openmessaging.OMSBuiltinKeys;
import io.openmessaging.consumer.MessageListener;
import io.openmessaging.consumer.PushConsumer;

/**
 * OMSPushConsumer
 *
 * 以下示范如何将 OMS PushConsumer 添加到指定的队列，并通过 MessageListener 消费这些消息。
 * 啥玩意啊，不管了，不好用
 *
 * @author wupw
 * @date 2020/12/16
 */
public class OMSPushConsumer {

    public static void main(String[] args) {

        final MessagingAccessPoint messagingAccessPoint = OMS
                .getMessagingAccessPoint("oms:rocketmq://localhost:9876/default:default");
        final PushConsumer consumer = messagingAccessPoint.
                createPushConsumer(OMS.newKeyValue().put(OMSBuiltinKeys.CONSUMER_ID, "OMS_CONSUMER"));
        messagingAccessPoint.startup();
        System.out.printf("MessagingAccessPoint startup OK%n");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.shutdown();
                messagingAccessPoint.shutdown();
            }
        }));
        consumer.attachQueue("OMS_HELLO_TOPIC", new MessageListener() {
            @Override
            public void onReceived(Message message, Context context) {
                System.out.printf("Received one message: %s%n", message.sysHeaders().getString(Message.BuiltinKeys.MESSAGE_ID));
                context.ack();
            }
        });
        consumer.startup();
        System.out.printf("Consumer startup OK%n");
    }
}
