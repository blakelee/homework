package net.blakelee.homework.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import net.blakelee.homework.R
import net.blakelee.homework.adapters.MainActivityAdapter
import net.blakelee.homework.models.Classes
import net.blakelee.homework.views.MainUI
import org.jetbrains.anko.*
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.find


class MainActivity : AppCompatActivity(){

    private val classAdapter: MainActivityAdapter = MainActivityAdapter(emptyList<Classes>())

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)

        MainUI(classAdapter).setContentView(this)
        setSupportActionBar(find<Toolbar>(R.id.toolbar_main) as Toolbar?)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.defaultmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_about -> startActivity<AboutActivity>()
            R.id.action_calandar -> startActivity<CalendarActivity>()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() = super.onDestroy()

}