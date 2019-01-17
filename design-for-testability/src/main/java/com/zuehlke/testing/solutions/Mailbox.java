package com.zuehlke.testing.solutions;

import java.util.ArrayList;
import java.util.List;

public class Mailbox {

    private UserRepository userRepository;
    private MailServer mailServer;
    private List<Mail> mail = new ArrayList<>();

    public Mailbox(UserRepository userRepository, MailServer mailServer) {
        this.userRepository = userRepository;
        this.mailServer = mailServer;
    }

    @Deprecated
    public Mailbox(String userId) {
        userRepository = UserRepository.getInstance();
        mailServer = MailServer.getInstance();
        retrieveMail(userId);
    }

    public void retrieveMail(String userId) {
        User user = userRepository.getUser(userId);
        List<Mail> mail = mailServer.getMail(user);
        for (Mail mailItem : mail) {
            if (isNotSpamOrASafeSender(mailItem)) {
                this.mail.add(mailItem);
            }
        }
    }

    private boolean isNotSpamOrASafeSender(Mail mailItem) {
        return mailServer.isNotSpam(mailItem) || userRepository.isSafeSender(mailItem.getFrom());
    }


    public void sendMail(Mail mail) {
        mail.setDate(getCurrentDate());
        mailServer.sendMail(mail);
    }

    long getCurrentDate() {
        return System.currentTimeMillis();
    }

    static class MailServer {
        static MailServer getInstance() {
            return new MailServer();
        }

        List<Mail> getMail(User user) {
            return new ArrayList<>();
        }

        void sendMail(Mail mail) {
        }

        boolean isNotSpam(Mail mailItem) {
            return !mailItem.getSubject().contains("Junk")
                    && !mailItem.getSubject().contains("Spam")
                    && !mailItem.getSubject().contains("Advertisment")
                    && !mailItem.getSubject().contains("Ads");
        }
    }

    class User {
    }

    static class UserRepository {
        static UserRepository getInstance() {
            return new UserRepository();
        }

        User getUser(String userId) {
            return null;
        }

        boolean isSafeSender(String from) {
            return true;
        }
    }


    class Mail {
        void setDate(long currentDate) {
        }

        String getFrom() {
            return "";
        }

        String getSubject() {
            return "";
        }
    }
}
