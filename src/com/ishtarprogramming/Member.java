package com.ishtarprogramming;

public class Member {
    private char mMemberType;
    private int mMemberID;
    private String mMemberName;
    private double mMemberFees;

    public Member(char mMemberType, int mMemberID, String mMemberName, double mMemberFees)
    {
        this.mMemberType = mMemberType;
        this.mMemberID = mMemberID;
        this.mMemberName = mMemberName;
        this.mMemberFees = mMemberFees ;
    }
    public char getmMemberType() {
        return mMemberType;
    }

    public void setmMemberType(char mMemberType) {
        this.mMemberType = mMemberType;
    }

    public int getmMemberID() {
        return mMemberID;
    }

    public void setmMemberID(int mMemberID) {
        this.mMemberID = mMemberID;
    }

    public String getmMemberName() {
        return mMemberName;
    }

    public void setmMemberName(String mMemberName) {
        this.mMemberName = mMemberName;
    }

    public double getmMemberFees() {
        return mMemberFees;
    }

    public void setmMemberFees(double mMemberFees) {
        this.mMemberFees = mMemberFees;
    }

    @Override
    public String toString()
    {
        return mMemberType + ", " + getmMemberID() + ", " + mMemberName + ", " + mMemberFees;
    }
}
