package Lektion2.sendEmail;

public class Main {
    public static void main(String[] args) {
        EmailSend newEmail = new EmailSend("linus.holmer@stud.sti.se","");
        newEmail.sendEmail("johan.hammerin@stud.sti.se", "du är bajs", "ja");
    }
}
