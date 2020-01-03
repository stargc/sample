package com.ehl.tsq.data.business.service.mock;

import javax.jms.*;

//消费者消费消息
public class AppConsumer {

    //    private static final String url="tcp://127.0.0.1:61616";
    private static final String url = "tcp://157.0.243.29:61616";
    private static final String queueName = "FirstTopic1";

    public static void main(String[] args) throws Exception {
        Xiaofei();
    }

    public static void Xiaofei() throws JMSException {
        //final String url="tcp://127.0.0.1:61616/";
        //final String queueName="queue-test";
        //1.创建ConnectionFactory
        ConnectionFactory acf = new org.apache.activemq.ActiveMQConnectionFactory("admin", "admin", url);

        //2.创建Connection
        Connection createConnection = acf.createConnection();

        //3,启动连接
        createConnection.start();

        //4.创建会话
        Session session = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5创建一个目标
//        Destination des = session.createQueue(queueName);
        Destination des = session.createTopic(queueName);

        //6.创建一个消费者
        MessageConsumer consumer = session.createConsumer(des);

        //7.创建一个监听器
        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费者接受消息" + textMessage.getText());
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

//              //9.关闭连接 这个链接因该是一直监听的,关闭当然接收不到信息
//              createConnection.close();
    }
}

