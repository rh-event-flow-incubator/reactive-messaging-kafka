package io.streamzi.messaging.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Message;

/**
 * Simple wrapper for the KafkaConsumer record.
 *
 * @param <K> the key of the underlying kafka record.
 * @param <V> the value of the underlying kafka record.
 */
public class ConsumerMessage<K, V> implements Message<V> {

    private final ConsumerRecord<K, V> record;

    public ConsumerMessage(final ConsumerRecord record) {
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
