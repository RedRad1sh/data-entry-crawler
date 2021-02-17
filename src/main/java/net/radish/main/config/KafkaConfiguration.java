package net.radish.main.config;

import net.radish.main.model.GoodUrl;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${kafka.server}")
    private String server;

    @Value("${kafka.username}")
    private String username = "";

    @Value(value = "${kafka.password}")
    private String password = "";

    @Value("${kafka.topic}")
    public String topic = "";

    @Bean
    public ProducerFactory<String, GoodUrl> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                server);
        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        props.put("ssl.endpoint.identification.algorithm", "https");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"MRTDBFFKIRFZ3T6V\" password=\"nSfVKChP6GXO8yndwLQuCWj4NBvR7V6o6NOhqxHtlgwyKKnd9Xxk4Lm4j4Kh0194\";");
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, GoodUrl> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
