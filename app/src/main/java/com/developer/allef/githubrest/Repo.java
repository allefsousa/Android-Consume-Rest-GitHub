package com.developer.allef.githubrest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by allef on 03/09/2017.
 */

class Repo {
    public Repo() {
    }

    @SerializedName("id")
    int mid;
    @SerializedName("name")
    String mName;
    @SerializedName("full_name")
    String mFullName;

    public Repo(int mid, String mName, String mFullName) {
        this.mid = mid;
        this.mName = mName;
        this.mFullName = mFullName;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }
}
