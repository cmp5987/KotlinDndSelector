package edu.rit.cmp5987.dndselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.top_fragment) === null){
            //no fragment found
            supportFragmentManager.beginTransaction().add(R.id.top_fragment, FragmentOnEntry()).commit()
        }

    }
    //for menus
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_about -> AboutDialog().show(supportFragmentManager, "about")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun passDataCom(selectedDndClass: String) {
        val bundle = Bundle()
        bundle.putString("selectedClass", selectedDndClass)

        val transaction = this.supportFragmentManager.beginTransaction()
        val selectedClassFragment = SelectedClassFragment()
        selectedClassFragment.arguments = bundle
        val entryFragment = supportFragmentManager.findFragmentById(R.id.fragment_on_entry)

        if(entryFragment != null && entryFragment.isAdded){
            Log.i("LocPassDataCom", "Found entry fragment")
            transaction.remove(FragmentOnEntry())
        }


        transaction.replace(R.id.top_fragment, selectedClassFragment)
        transaction.commit()
    }

}