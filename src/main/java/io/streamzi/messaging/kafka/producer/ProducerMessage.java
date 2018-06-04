package io.streamzi.messaging.kafka.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.eclipse.microprofile.reactive.messaging.Message;

/**
 * Simple wrapper for the KafkaConsumer record.
 *
 * @param <K> the key of the underlying kafka record.
 * @param <V> the value of the underlying kafka record.
 */
public class ProducerMessage<K, V> implements Message<V> {

    private final ProducerRecord<K, V> record;

    public ProducerMessage(final ProducerRecord record) {
        this.record = record;
    }

    public K getKey() {
        return this.record.key();
    }

    @Override
    public V getPayload() {
        return this.record.value();
    }
}
