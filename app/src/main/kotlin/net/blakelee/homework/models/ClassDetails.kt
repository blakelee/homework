package net.blakelee.homework.models

import android.arch.persistence.room.*
import net.blakelee.homework.R
import net.blakelee.homework.utils.WeekConverter

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
    var icon: Int = R.drawable.psychology_96
    var icon_color: Int = -16777216 //Black
    var ringmode: Int? = 3 //No change

    @TypeConverters(value = WeekConverter::class)
    var weeks: MutableList<Week> = mutableListOf(Week())
}