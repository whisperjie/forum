package com.whisper.forum.android;

public class AFocus {
    public int id;
   public int userId;
   public int userFriendId;

    public AFocus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriendId(int userFriendId) {
        this.userFriendId = userFriendId;
    }

    @Override
    public String toString() {
        return "AFocus{" +
                "id=" + id +
                ", userId=" + userId +
                ", userFriendId=" + userFriendId +
                '}';
    }
}
