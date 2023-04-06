package edu.temple.viewpagerinclasssctivity

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {


     private var numberOfPages = 0

    val newButton : Button by lazy{
        findViewById(R.id.ADD)

    }
    val viewPager: ViewPager2 by lazy{
        findViewById(R.id.viewPager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newButton.setOnClickListener{
         numberOfPages++
         viewPager.adapter?.notifyItemInserted(numberOfPages -1)
        }

        supportFragmentManager.findFragmentByTag("f")

        viewPager.adapter = object: FragmentStateAdapter(this) {
            override fun getItemCount() = numberOfPages

            override fun createFragment(position: Int) = TextFragment.newInstance((position + 1) .toString())

        }

    }

}

