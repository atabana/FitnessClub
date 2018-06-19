package com.ishtarprogramming;
import java.util.LinkedList;
public class Main {

    public static void main(String[] args) {

        String mem;

        MembershipManagement membershipManagement = new MembershipManagement();
        FileHandler fileHandler = new FileHandler();
        LinkedList<Member> members = fileHandler.readFile();


        int choice = membershipManagement.getChoice();
        while (choice != -1)
        {
            switch (choice)
            {
                case 1:
                    mem = membershipManagement.addMembers(members);
                    fileHandler.appendFile(mem);
                    break;
                case 2:
                    membershipManagement.removeMember(members);
                    fileHandler.overwriteFile(members);
                    break;
                case 3:
                    membershipManagement.printMemberInfo(members);
                    break;
                default:
                    System.out.println("invalid option");
            }
            choice = membershipManagement.getChoice();
        }

        System.out.println("\nGoodbye!");

    }
}
