package net.blakelee.homework.views

import android.content.Intent
import android.net.Uri
import android.support.v4.app.Fragment
import android.view.View
import android.widget.ImageView
import com.raizlabs.android.dbflow.data.Blob
import net.blakelee.homework.R
import net.blakelee.homework.models.ClassDetails
import net.blakelee.homework.models.Week
import net.blakelee.homework.utils.BlobToBitmap
import net.blakelee.homework.views.items.WeekItemUI
import org.jetbrains.anko.*
import java.io.File

class ClassDetailsMainFragmentUI(val classDetails : ClassDetails) : AnkoComponent<Fragment> {
    override fun createView(ui: AnkoContext<Fragment>): View = with(ui) {
        scrollView {
            lparams(width = matchParent)

            verticalLayout {

                val file = File(ctx.filesDir, classDetails.id.toString())
                if (file.exists()) {
                    imageView {
                        val blob = Blob(file.readBytes())
                        imageBitmap = BlobToBitmap(blob)
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        }.lparams(width = matchParent, height = dip(200))
                }

                verticalLayout {

                    padding = dip(14)

                    textView("Class Name")
                    textView (classDetails.name)

                    textView("Class Days")
                    for(week : Week in classDetails.weeks.week) {
                        this.addView(WeekItemUI(week).createView(AnkoContext.create(ctx, this)))
                    }

                    if (classDetails.professor != "") {
                        textView("Professor Name")
                        textView(classDetails.professor)
                    }

                    if (classDetails.location != "") {
                    textView("Location")
                    textView(classDetails.location)
                    }

                    if (classDetails.email != "") {
                        textView("Email Address")
                        textView(classDetails.email)
                    }

                    if (classDetails.phone != "") {
                        textView("Phone Number")
                        textView(classDetails.phone) {
                            setOnClickListener {
                                val intent = Intent(Intent.ACTION_DIAL)
                                intent.data = Uri.parse("tel:" + classDetails.phone)
                                ctx.startActivity(intent)
                            }
                        }
                    }

                    if (classDetails.hours != null) {
                        textView("Credit Hours")
                        textView(classDetails.hours?.toString()) {
                            id = R.id.credit_hours
                        }
                    }

                }
            }.lparams(height = matchParent, width = matchParent)
        }
    }
}