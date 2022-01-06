package aman.upd.oceanlife

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_list.view.*
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listanimal.layoutManager = LinearLayoutManager(this)
        val animals = animalall()
        listanimal.adapter = AnimalAdapter(animals)
    }
    private fun animalall():List<animals>{
        val animal = mutableListOf<animals>()
        val crab = animals()
        val seaotter = animals()
        val seaturtle = animals()
        val shark = animals()
        val killerwhale = animals()
        val octopus = animals()

        crab.name = "Crab"
        seaotter.name = "Sea otter"
        seaturtle.name = "Sea turtle"
        shark.name = "Shark"
        killerwhale.name = "Killer whale"
        octopus.name = "Octopus"

        crab.detail = "Crabs are decapod crustaceans which have a very short tail and are covered with a thick shell, or exoskeleton and are armed with a single pair of claws."
        seaotter.detail = "The sea otter (Enhydra lutris) is a marine mammal native to the coasts of the northern and eastern North Pacific Ocean."
        seaturtle.detail = "Sea turtles are large, air-breathing reptiles that inhabit tropical and subtropical seas throughout the world."
        shark.detail = "Sharks are a group of elasmobranch fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head."
        killerwhale.detail = "The orca (killer whale) is a toothed whale and is the largest member of the Dolphin family. These large marine mammals are easily distinguished by their black-and-white coloration, large dorsal fin and a sleek, streamlined body."
        octopus.detail= "Octopuses (or octopi, if you prefer) are cephalopods, invertebrates that also include squid and cuttlefish. They have bulbous heads, large eyes, and eight very useful arms."

        crab.image = R.drawable.crab
        seaotter.image = R.drawable.seaotter
        seaturtle.image = R.drawable.seaturtle
        shark.image = R.drawable.shark
        killerwhale.image = R.drawable.whale
        octopus.image = R.drawable.octopus

        animal+=crab
        animal+= seaotter
        animal+= seaturtle
        animal+= shark
        animal += killerwhale
        animal+= octopus

        return animal

    }
    private inner class AnimalHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val animalName = itemView.animalName
        val animalImage = itemView.animalImage

        lateinit var animal: animals

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(animal: animals){
            this.animal = animal
            animalName.text = animal.name.toString()

            animalImage.setImageResource(animal.image)
        }
        override fun onClick(v: View?) {
            val intent = Intent(v!!.context, DetailActivity::class.java)
            intent.putExtra("detail", animal.detail)
            intent.putExtra("name",animal.name)
            intent.putExtra("image",animal.image)

            startActivity(intent)
        }
    }
    private inner class AnimalAdapter(var animal:List<animals>): RecyclerView.Adapter<AnimalHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
            val view = layoutInflater.inflate(R.layout.animal_list,parent, false)
            return AnimalHolder(view)
        }

        override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
            val animals = animal[position]
            holder.bind(animals)
        }

        override fun getItemCount(): Int {
            return animal.size
        }
    }
}


