Overview

Using the ActiveAndroid ORM makes managing client-side models extremely easy in simple cases. For more advanced or custom cases, you can use SQLiteOpenHelper to manage the database communication directly. But for simple model mapping from JSON, ActiveAndroid keeps things simple.

ActiveAndroid works like any Object Relational Mapper by mapping java classes to database tables and mapping java class member variables to the table columns. Through this process, each table maps to a Java model and the columns in the table represent the respective data fields. Similarly, each row in the database represents a particular object. This allows us to create, modify, delete and query our SQLite database using model objects instead of raw SQL.

Installation

In Android Studio, you can setup ActiveAndroid via Gradle in app/build.gradle:

repositories {

jcenter()

maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}

dependencies {

compile fileTree(dir: 'libs', include: ['*.jar'])
compile 'com.android.support:appcompat-v7:22.2.1'
compile 'com.michaelpardo:activeandroid:3.1.0-SNAPSHOT'
}
