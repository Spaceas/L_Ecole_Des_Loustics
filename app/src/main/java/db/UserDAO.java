package db;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDAO {

    @Insert
    void insert(User user);
}
