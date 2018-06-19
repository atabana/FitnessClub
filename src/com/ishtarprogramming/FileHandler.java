package com.ishtarprogramming;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    public LinkedList<Member> readFile()
    {
        LinkedList<Member> memberLinkedList = new LinkedList();
        String lineRead;
        String[] splitLine;
        Member member;
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();
            while(lineRead != null)
            {
                splitLine = lineRead.split(", ");
                if(splitLine[0].equals("S"))
                {
                    member = new SingleClubMember('S',
                            Integer.parseInt(splitLine[1]),
                            splitLine[2],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                }
                else
                {
                    member = new MultiClubMember('M',
                            Integer.parseInt(splitLine[1]),
                            splitLine[2],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                }
                memberLinkedList.add(member);
                lineRead = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("error" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());

            e.printStackTrace();
        }
        return memberLinkedList;
    }
    public void appendFile (String memberStr)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv",true))) {
            writer.newLine();
            writer.write(memberStr);
            //writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void overwriteFile(LinkedList<Member> memberLinkedList)
    {
        Member member = null;
        String memberStr = null;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp",false))) {
            for (int i = 0; i < memberLinkedList.size() ; i++)
            {
                member = memberLinkedList.get(i);
                memberStr = member.toString();
                writer.write(memberStr);
                writer.newLine();
            }

            File membersFile = new File("members.csv");
            File tempFile = new File("members.temp");
            membersFile.delete();
            tempFile.renameTo(membersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
