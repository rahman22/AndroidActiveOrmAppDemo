## Overview

Using the ActiveAndroid ORM makes managing client-side models extremely easy in simple cases. For more advanced or custom cases, you can use SQLiteOpenHelper to manage the database communication directly. But for simple model mapping from JSON, ActiveAndroid keeps things simple.

ActiveAndroid works like any Object Relational Mapper by mapping java classes to database tables and mapping java class member variables to the table columns. Through this process, each table maps to a Java model and the columns in the table represent the respective data fields. Similarly, each row in the database represents a particular object. This allows us to create, modify, delete and query our SQLite database using model objects instead of raw SQL.

### Installation

In Android Studio, you can setup ActiveAndroid via Gradle in app/build.gradle:

repositories {

jcenter()

maven { 

url "https://oss.sonatype.org/content/repositories/snapshots/"

}

}

#### dependencies 

{

compile fileTree(dir: 'libs', include: ['*.jar'])

compile 'com.android.support:appcompat-v7:22.2.1'

compile 'com.michaelpardo:activeandroid:3.1.0-SNAPSHOT'

}

### Crud App Screenshot 

![device-2017-05-20-141843](https://cloud.githubusercontent.com/assets/28509637/26379272/be5dfd90-4031-11e7-91a8-10f3fb581bba.png)

![device-2017-05-22-135417](https://cloud.githubusercontent.com/assets/28509637/26379273/be642968-4031-11e7-8e9a-040db5396362.png)

![device-2017-05-20-141723](https://cloud.githubusercontent.com/assets/28509637/26379274/be646202-4031-11e7-9836-19eace503a1b.png)

![device-2017-05-20-141743](https://cloud.githubusercontent.com/assets/28509637/26379275/be65b8aa-4031-11e7-8150-00926ea2e717.png)
