package com.springboot.springboot2es;

import lombok.extern.java.Log;
import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.jms.Connection;
import javax.jms.JMSException;
import java.util.HashMap;


//@EnableAutoConfiguration(exclude = ArtemisEmbeddedServerConfiguration.class)
//@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class , JmsAutoConfiguration.class)
@Configuration
@SpringBootApplication(exclude = JmsAutoConfiguration.class)
@ComponentScan({ "com.springboot.springboot2es.service", "com.springboot.springboot2es.repository" })
@EnableJpaRepositories(basePackages = "com.springboot.springboot2es.repository")
@EnableAutoConfiguration(exclude = JmsAutoConfiguration.class)
@ImportResource({"classpath:applicationContext.xml"})
@Log
public class SpringBootApplicationJms  {

    private static final int JMS_CONNECTION_ATTEMPTS = 15;
    private static final int JMS_CONNECTION_TTL = 20000;
    private static final int JMS_CLIENT_FAILURE_CHECK_PERIOD = 2000;
    private static final int JMS_CALL_TIMEOUT = 10000;
    private static final int JMS_RETRY_INTERVAL = 2000;
    public static final Long JMS_MESSAGES_TIMEOUT = 60000L;
    private ActiveMQConnectionFactory connectionFactory;
    private Connection connection;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationJms.class);
        //SpringApplication.run(SpringBootApplicationJms.class, "--debug").close();
    }

 /*   @Override
    public void run(String... args) throws Exception {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
          //     "applicationContext.xml");
        /*jmsConnectorImpl("localhost", 61616, "user", "user");

        CusumeMessage cusumeMessage = (CusumeMessage) context
                .getBean("cusumeMessage");
        log.info("Consumer receives " + cusumeMessage.receiveMessage())

    }

   public void jmsConnectorImpl(String jmsHost, Integer jmsPort, String jmsLogin, String jmsPassword) throws JMSException {
        log.info("Trying to connect to jms server " + jmsHost + " : " + jmsPort);
        // JMS Connection
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", jmsHost);
        map.put("port", jmsPort);
        TransportConfiguration transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName(), map);
        connectionFactory = new ActiveMQConnectionFactory(true, transportConfiguration);
        // Apply some settings to JMS Connection
        connectionFactory.setInitialConnectAttempts(JMS_CONNECTION_ATTEMPTS);
        connectionFactory.setReconnectAttempts(JMS_CONNECTION_ATTEMPTS);
        connectionFactory.setConnectionTTL(JMS_CONNECTION_TTL);
        connectionFactory.setClientFailureCheckPeriod(JMS_CLIENT_FAILURE_CHECK_PERIOD);
        connectionFactory.setCallTimeout(JMS_CALL_TIMEOUT);
        connectionFactory.setRetryInterval(JMS_RETRY_INTERVAL);

        connection = connectionFactory.createConnection(jmsLogin, jmsPassword);
        connection.start();

    }*/


}
