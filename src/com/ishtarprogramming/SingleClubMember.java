package com.ishtarprogramming;

public class SingleClubMember extends Member{
    private int mClub;

    public int getmClub() {
        return mClub;
    }

    public void setmClub(int mClub) {
        this.mClub = mClub;
    }
    public SingleClubMember(char mMemberType, int mMemberID, String mMemberName, double mMemberFees, int mClub) {
        super(mMemberType, mMemberID, mMemberName, mMemberFees);
        this.mClub = mClub;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", " +  mClub;
    }
}
