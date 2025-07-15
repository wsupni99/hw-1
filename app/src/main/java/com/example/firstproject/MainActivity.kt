package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
// Йоу
    val picturesList = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Example.jpg/320px-Example.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/HST-SM4.jpeg/320px-HST-SM4.jpeg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/320px-Golde33443.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/320px-Image_created_with_a_mobile_phone.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Rotating_earth_%28large%29.gif/320px-Rotating_earth_%28large%29.gif",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Wikipedia-logo-v2.svg/320px-Wikipedia-logo-v2.svg.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/PNG_transparency_demonstration_1.png/320px-PNG_transparency_demonstration_1.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/LARGE_elevation.jpg/320px-LARGE_elevation.jpg",
        "https://images.unsplash.com/photo-1551963831-b3b1ca40c98e",
        "https://images.unsplash.com/photo-1551782450-a2132b4ba21d",
        "https://picsum.photos/400/200?image=10"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonLoad = findViewById<Button>(R.id.buttonLoadImage)
        val buttonNext = findViewById<Button>(R.id.buttonNextScreen)

        buttonLoad.setOnClickListener {
            val index = Random.nextInt(picturesList.size)
            Glide.with(this)
                .load(picturesList[index])
                .placeholder(android.R.color.darker_gray)
                .error(android.R.color.holo_red_dark)
                .dontAnimate()
                .into(imageView)


        }



        buttonNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
