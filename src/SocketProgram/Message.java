package SocketProgram;

public class Message {
    private static final String LINE_SEPARATOR =System.lineSeparator() ;//换行符
    String from;//邮件发送者
    String to;//邮件接收者
    String subject;//标题
    String content;//正文
    String data;//日期

    public Message(String from,String to,String subject,String content) {
        this.content = content;
        this.subject = subject;
        this.from = from;
        this.to = to;
        data = "Subject:"+subject+LINE_SEPARATOR+content;
    }
}
