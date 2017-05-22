package com.example.thedeveloper.androidactiveormappdemo.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by The Developer on 5/17/2017.
 */
@Table(name = "subjects")
public class SubjectList extends Model {

    @Column(name = "name")
    private String nameSubject;
    @Column(name = "description")
    private String descriptionSubject;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getDescriptionSubject() {
        return descriptionSubject;
    }

    public void setDescriptionSubject(String descriptionSubject) {
        this.descriptionSubject = descriptionSubject;
    }
}
