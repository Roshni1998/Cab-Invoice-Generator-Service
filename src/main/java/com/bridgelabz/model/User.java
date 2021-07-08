package com.bridgelabz.model;

import java.util.Objects;
/*
 * @author ROSHNI
 * Cab Invoice Generator Service
 * User Details
 *
 *  */

public class User {
    public int userId;

    public User(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
