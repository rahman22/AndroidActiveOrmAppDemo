## Overview

Using the ActiveAndroid ORM makes managing client-side models extremely easy in simple cases. For more advanced or custom cases, you can use SQLiteOpenHelper to manage the database communication directly. But for simple model mapping from JSON, ActiveAndroid keeps things simple.

ActiveAndroid works like any Object Relational Mapper by mapping java classes to database tables and mapping java class member variables to the table columns. Through this process, each table maps to a Java model and the columns in the table represent the respective data fields. Similarly, each row in the database represents a particular object. This allows us to create, modify, delete and query our SQLite database using model objects instead of raw SQL.

### Installation

In Android Studio, you can setup ActiveAndroid via Gradle in app/build.gradle:

```java
repositories {

jcenter()

maven { 

url "https://oss.sonatype.org/content/repositories/snapshots/"

}

}
```
```java

#### dependencies 

{

compile fileTree(dir: 'libs', include: ['*.jar'])

compile 'com.android.support:appcompat-v7:22.2.1'

compile 'com.michaelpardo:activeandroid:3.1.0-SNAPSHOT'

}
```

## Database Config

```java

        <meta-data
            android:name="AA_DB_NAME"
            android:value="subjectdb.db" />
        <meta-data
            android:name="AA_DB_VERSION"
            android:value="1" />

```

## Table Structure

```java

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

```
### Activeandroid ORM Config 

```java

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by The Developer on 5/17/2017.
 */

public class Configs extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}

```


### Crud App Screenshot 

<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/28509637/26379274/be646202-4031-11e7-9836-19eace503a1b.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/28509637/26379272/be5dfd90-4031-11e7-91a8-10f3fb581bba.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/28509637/26379273/be642968-4031-11e7-8e9a-040db5396362.png" width="200"/>
  <img src="https://cloud.githubusercontent.com/assets/28509637/26379275/be65b8aa-4031-11e7-8150-00926ea2e717.png" width="200"/>
</p>
