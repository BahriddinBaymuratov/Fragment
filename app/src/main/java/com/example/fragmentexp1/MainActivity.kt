package com.example.fragmentexp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // build Gradle ga 'kotlin-android-extensions' degan funksiya qoshib oldik bu UI dan id larni topish uchun yordam beradi
    // first fragment ozgaruvchiga yangi obyekt yaratib beradi
    var firstFragment = FirstFragment.newInstance()
    var secondFragment = SecondFragment.newInstance()
    var activeFragment:  Fragment = firstFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, firstFragment, firstFragment.tag).hide(firstFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container, secondFragment, secondFragment.tag).hide(secondFragment).commit()

        // supportFragManager activity ichida fragmentlarni boshqarishda yordamchi
        // beginTransaction ozgartirishni boshlash
        // xamma narsa qigandan keyin oxiriga commit() yozmasa ishlamidi

//        supportFragmentManager.beginTransaction().add(R.id.firstFrag, firstFragment, firstFragment.tag).commit()
//        supportFragmentManager.beginTransaction().add(R.id.secondFrag, secondFragment,secondFragment.tag).commit()
        // main activity ichida 2 ta oyna yaratdik

        first.setOnClickListener {
            supportFragmentManager.beginTransaction().hide(activeFragment).show(firstFragment).commit()
        }
        second.setOnClickListener {
            supportFragmentManager.beginTransaction().hide(activeFragment).show(secondFragment).commit()
            activeFragment = secondFragment
        }


    }
}