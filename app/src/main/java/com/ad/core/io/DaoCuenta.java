package com.ad.core.io;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.core.entity.Ecuenta;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoCuenta {
    @Insert
    void insertAll(Ecuenta... cuentas);
    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insertCuentas(List<Ecuenta> cuentas);

    @Insert
    public void insertBothCuentas(Ecuenta cuenta, Ecuenta cuenta1);

    @Insert
    public void insertCuentaAndCuentas(Ecuenta cuenta, List<Ecuenta> cuentas);

    @Update
    public void updateCuentas(Ecuenta... cuentas);
    @Delete
    void delete(Ecuenta cuenta);

    @Query("SELECT * FROM tbcuenta")
    List<Ecuenta> getAll();
/*
    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search " +
            "OR last_name LIKE :search")
    public List<User> findUserWithName(String search);

    @Query("SELECT * FROM book " +
       "INNER JOIN loan ON loan.book_id = book.id " +
       "INNER JOIN user ON user.id = loan.user_id " +
       "WHERE user.name LIKE :userName")
        public List<Book> findBooksBorrowedByNameSync(String userName);


    @Query(
    "SELECT * FROM user" +
    "JOIN book ON user.id = book.user_id"
    )
    public Map<User, List<Book>> loadUserAndBookNames();


        @Dao
public interface UserBookDao {
   @Query("SELECT user.name AS userName, book.name AS bookName " +
          "FROM user, book " +
          "WHERE user.id = book.user_id")
   public LiveData<List<UserBook>> loadUserAndBookNames();

   // You can also define this class in a separate file, as long as you add the
   // "public" access modifier.
   static class UserBook {
       public String userName;
       public String bookName;
   }
}


    */



}
