import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private final String sender= "SP24-BSE-005";
    private String receiver;
    private String content;
    private LocalDateTime timestamp;
    private MessageStatus deliverystatus;
    private MessageStatus status;
    private String messageID;
    private static int counter=0;

    public enum MessageStatus {
        SENT, READ, UNREAD
    }

    public Message(String receiver, String content, LocalDateTime timestamp) {
        this.messageID=String.format("%03d",++counter);
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
        this.deliverystatus= MessageStatus.SENT;
        this.status = MessageStatus.UNREAD;
    }

    public String getSender() {
        return sender;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setDeliveryStatus(MessageStatus deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public MessageStatus getDeliverystatus() {
        return deliverystatus;
    }

    @Override
    public String toString() {
        return String.format(
                "Message ID: %s\nFrom: %s\nTo: %s\nContent: %s\nTime: %s\nStatus: %s\nDelivery Status: %s",
                messageID, sender, receiver, content, timestamp.toString(), status, deliverystatus);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(receiver, message.receiver);
    }
}
