package com.example.demoattendance

import android.graphics.Color
import android.graphics.ColorSpace
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.core.graphics.component1
import androidx.core.graphics.toColor
import androidx.core.view.get
import com.example.demoattendance.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.naishadhparmar.zcustomcalendar.CustomCalendar
import org.naishadhparmar.zcustomcalendar.Property
import java.time.LocalDate
import java.util.Calendar
import java.util.Objects

class MainActivity: AppCompatActivity() {

    lateinit var customCalendar: CustomCalendar
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customCalendar=findViewById(R.id.calendar_view)


        var hashMap : HashMap<Any, Property> = HashMap<Any, Property> ()

        val presentprop=Property()
        presentprop.layoutResource=R.layout.present
        presentprop.dateTextViewResource=R.id.text1
        hashMap.put("present",presentprop )

        val absentprop=Property()
        absentprop.layoutResource=R.layout.absend
        absentprop.dateTextViewResource=R.id.text2
        hashMap.put("absent",absentprop )



        val currentprop=Property()
        currentprop.layoutResource=R.layout.current
        currentprop.dateTextViewResource=R.id.text3
        hashMap.put("current",currentprop )

        val defaultprop=Property()
        defaultprop.layoutResource=R.layout.default_view
        defaultprop.dateTextViewResource=R.id.text4
        hashMap.put("default",defaultprop )



       customCalendar.setMapDescToProp(hashMap)
        var dateMap : HashMap<Int, Any> = HashMap<Int, Any> ()
        val calendar=Calendar.getInstance()
        dateMap.put(calendar.get(Calendar.DAY_OF_MONTH),"current")

        dateMap.put(calendar.firstDayOfWeek+1,"present")
        dateMap.put(2,"absent")
        dateMap.put(3,"present")
        dateMap.put(4,"present")
        dateMap.put(5,"present")
        dateMap.put(10,"present")
        dateMap.put(18,"absent")
        dateMap.put(15,"present")
        dateMap.put(10,"absent")


        customCalendar.setDate(calendar,dateMap)






    }
}
