package com.ishtarprogramming;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    private final Scanner reader = new Scanner(System.in);
    private int getIntInput()
    {
        int choice = 0;
        while(choice == 0)
        {
            try{
               choice = reader.nextInt();
               if(choice == 0)
               {
                   throw new InputMismatchException();
               }
               reader.nextLine();
            }
            catch (InputMismatchException e)
            {
                reader.nextLine();
                System.err.println("Invalid input. Please try again");
            }
        }
        return choice;
    }
    private void printClubOptions()
    {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Club");
    }
    public int getChoice()
    {
        System.out.println("\nWELCOME TO FITNESS CENTER");
        System.out.println("=========================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("");
        System.out.println("Please select an option (or Enter -1 to quit");

        int choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> memberLinkedList)
    {
        String name;
        int club;
        String memStr;
        double fees;
        int memberID;
        Member member;
        ICalculator<Integer> calculator;
        System.out.println("Please enter a name for the member:");
        name = reader.nextLine();
        System.out.println("Please select a club:");
        printClubOptions();
        club = getIntInput();
        while(club < 1 || club > 4)
        {
            System.out.println("Please enter a correct club number");
            club = getIntInput();
        }

        if(memberLinkedList.size() > 0)
        {
            memberID = memberLinkedList.getLast().getmMemberID() + 1;
        }
        else
        {
            memberID = 1;
        }

        if(club != 4 )
        {
           calculator = (n) -> {
               switch (n)
               {
                   case 1:
                       return 900;
                   case 2:
                       return 950;
                   case 3:
                       return 1000;
                   default:
                       return -1;
               }
           };
           fees = calculator.calclateFees(club);
           member = new SingleClubMember('S',memberID,name,fees,club);
           memberLinkedList.add(member);
           memStr = member.toString();
           System.out.println("\nadded single member success");
        }
        else
        {
            calculator = (n) -> {
                switch (n)
                {
                    case 4:
                        return 1200;
                    default:
                        return -1;
                }
            };
            fees = calculator.calclateFees(club);
            member = new MultiClubMember('M',memberID,name,fees,100);
            memberLinkedList.add(member);
            memStr = member.toString();
            System.out.println("\nadded multi member success");

        }
        return memStr;
    }

    public void removeMember(LinkedList<Member> memberLinkedList)
    {
        int memberID;
        System.out.println("enter id of member to be removed");
        memberID  = getIntInput();
        for(int i = 0; i < memberLinkedList.size(); i++)
        {
            if(memberLinkedList.get(i).getmMemberID() == memberID)
            {
                memberLinkedList.remove(i);
                System.out.println("member successfully removed");
                return;
            }
        }
        System.out.println("no matching ID found");

    }
    public void printMemberInfo(LinkedList<Member> memberLinkedList)
    {
        int memberID;
        System.out.println("enter id of member to display info");
        memberID  = getIntInput();
        for(int i = 0; i < memberLinkedList.size(); i++)
        {
            if(memberLinkedList.get(i).getmMemberID() == memberID)
            {
                String memStr = memberLinkedList.get(i).toString();
                String[] memInfo = memStr.split(", ");
                if(memInfo[0] == "S")
                {
                    System.out.println("Member Type = " + memInfo[0]);
                    System.out.println("Member ID = " + memInfo[1]);
                    System.out.println("Member Name = " + memInfo[2]);
                    System.out.println("Membership fees = " + memInfo[3]);
                    System.out.println("Club ID = " + memInfo[4]);

                }
                else
                {
                    System.out.println("Member Type = " + memInfo[0]);
                    System.out.println("Member ID = " + memInfo[1]);
                    System.out.println("Member Name = " + memInfo[2]);
                    System.out.println("Membership fees = " + memInfo[3]);
                    System.out.println("Membership points = " + memInfo[4]);

                }
                return;
            }
        }
        System.out.println("no matching ID found");
    }
}
