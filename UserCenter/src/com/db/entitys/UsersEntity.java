package com.db.entitys;

public class UsersEntity {
    private String id;
    private String userName;
    private String userLogo;
    private String userSex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity entity = (UsersEntity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (userName != null ? !userName.equals(entity.userName) : entity.userName != null) return false;
        if (userLogo != null ? !userLogo.equals(entity.userLogo) : entity.userLogo != null) return false;
        if (userSex != null ? !userSex.equals(entity.userSex) : entity.userSex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userLogo != null ? userLogo.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        return result;
    }
}
