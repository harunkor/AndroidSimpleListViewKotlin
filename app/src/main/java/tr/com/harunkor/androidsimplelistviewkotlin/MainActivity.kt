package tr.com.harunkor.androidsimplelistviewkotlin

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.mylist)

        val res:Resources = resources
        val listItems = res.getStringArray(R.array.currencyunit)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listItems)

        listView.adapter=adapter


        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val itemValue= listView.getItemAtPosition(position) as String

                Toast.makeText(applicationContext, "Position :$position\n Value : $itemValue",Toast.LENGTH_LONG).show()

            }

        }


    }
}
