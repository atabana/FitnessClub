package com.ishtarprogramming;

public class MultiClubMember extends Member {
    private int mMembershipPoints;

    public int getmMembershipPoints() {
        return mMembershipPoints;
    }

    public void setmMembershipPoints(int mMembershipPoints) {
        this.mMembershipPoints = mMembershipPoints;
    }

    public MultiClubMember(char mMemberType, int mMemberID, String mMemberName, double mMemberFees, int mMembershipPoints) {
        super(mMemberType, mMemberID, mMemberName, mMemberFees);
        this.mMembershipPoints = mMembershipPoints;
    }
    @Override
    public String toString()
    {
        return super.toString() + ", " +  mMembershipPoints;
    }
}
