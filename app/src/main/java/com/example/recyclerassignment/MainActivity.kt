package com.example.recyclerassignment


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerassignment.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profilelist: List<Profiles>
    private lateinit var myProfileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val profiles: List<Profiles> = listOf(
        Profiles("James", "Miller", R.drawable.winkboy),
        Profiles("Micheal", "Bella", R.drawable.cubsguy),
        Profiles("Oke", "Rufus", R.drawable.CigCardNey),
        Profiles("Miracle", "Jeffery", R.drawable.MR__RED),
        Profiles("Wobi", "Wole", R.drawable.Mini_S_ring),
        Profiles("Hillary", "Jasper", R.drawable.Skull6),
        Profiles("Isreal", "Jude", R.drawable.dog),
        Profiles("Mike", "Winfred", R.drawable.happykidlaughs),
        Profiles("Joseph", "Duro", R.drawable.kamila3),
        Profiles("Monday", "Austin", R.drawable.nino_side_arms_low),
        Profiles("Daniel", "Success", R.drawable.poule),
        Profiles("Oge", "Ruth", R.drawable.woman00),
        Profiles("Uche", "Uchbeat", R.drawable.Architetto),
        Profiles("Obed", "Niyi", R.drawable.Blue_Beetle),
        Profiles("Eziekel", "Luis", R.drawable.Revolutionary_Women),
        Profiles("Frank", "Lampard", R.drawable.dorit_pd),
        Profiles("Jareh", "Amaka", R.drawable.female_head_older),
        Profiles("Great", "Love", R.drawable.helmeticon),
        Profiles("Cruz", "Santa", R.drawable.santahead_colour),
        Profiles("Ken", "Ken", R.drawable.shokunin_tux)
    )


        myProfileAdapter= ProfileAdapter(profiles)
        binding.profileRecycler.adapter= myProfileAdapter
    }
    override fun OnItemClick( profiles: Profiles, position: Int){
        val intent=Intent( this, ProfileActivity::class.java)
        intent.putExtra("Profilefname", profiles.firstName)
        intent.putExtra("Profilelname", profiles.lastName)
        intent.putExtra("Profilelogo", profiles.logo.toString())
        startActivity(intent)
    }
}
