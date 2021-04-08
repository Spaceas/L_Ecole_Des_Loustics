package db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Nom")
    private String nom;




    /*
     * Getters and Setters
     * */
    public String getNom() {
        return nom;
    }

    public void setNom(String nomUser) {
        this.nom = nomUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int Newid) {
        this.id = Newid;
    }

}
