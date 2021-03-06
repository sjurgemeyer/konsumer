package smartthings.konsumer.example;

import smartthings.konsumer.MessageProcessor;
import kafka.message.MessageAndMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class LoggingMessageProcessor implements MessageProcessor {
	private final static Logger log = LoggerFactory.getLogger(LoggingMessageProcessor.class);

	@Override
	public void processMessage(MessageAndMetadata<byte[], byte[]> bytes) throws Exception {
		log.warn("Thread {} - Got message - {}",
				 Thread.currentThread().getName(),
				 new String(bytes.message(), StandardCharsets.UTF_8));
	}
}
