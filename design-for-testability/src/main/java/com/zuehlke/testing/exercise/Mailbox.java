package com.zuehlke.testing.exercise;

import java.util.ArrayList;
import java.util.List;

public class Mailbox {

    private List<Mail> mail = new ArrayList<>();

    public Mailbox(String userId) {
        User user = UserRepository.getUser(userId);
        List<Mail> mail = MailServer.getMail(user);
        for (int i = 0; i < mail.size(); i++) {
            if (!mail.get(i).getSubject().contains("Junk")
                    && !mail.get(i).getSubject().contains("Spam")
                    && !mail.get(i).getSubject().contains("Advertisment")
                    && !mail.get(i).getSubject().contains("Ads")
                    || UserRepository.isSafeSender(mail.get(i).getFrom())) {
                this.mail.add(mail.get(i));
            }
        }
    }

    public void sendMail(Mail mail) {
        mail.setDate(System.currentTimeMillis());
        MailServer.sendMail(mail);
    }

    static class MailServer {
        static List<Mail> getMail(User user) {
            return new ArrayList<>();
        }

        static void sendMail(Mail mail) {
        }
    }

    class User {
    }

    static class UserRepository {
        static User getUser(String userId) {
            return null;
        }

        public static boolean isSafeSender(String from) {
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
