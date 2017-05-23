package net.blakelee.homework.models

import android.arch.persistence.room.*
import net.blakelee.homework.utils.WeeksConverters

@Entity(tableName = "class_details", indices = arrayOf(Index("name", unique = true)))
class ClassDetails {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var name: String = ""
    var location: String = ""
    var syllabus: String = ""
    var email: String = ""
    var phone: String = ""
    var hours: Int? = null
    var professor: String = ""
    var icon: String = ""
    var ringmode: Int? = null

    @TypeConverters(value = WeeksConverters::class)
    var weeks: Weeks = Weeks()
}