package aman.upd.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var turn = 1

        var grid = Array(3) {Array(3) {0} }

        val database = FirebaseDatabase.getInstance()
        val button1DB = database.getReference("Button1")
        val button2DB = database.getReference("Button2")
        val button3DB = database.getReference("Button3")
        val button4DB = database.getReference("Button4")
        val button5DB = database.getReference("Button5")
        val button6DB = database.getReference("Button6")
        val button7DB = database.getReference("Button7")
        val button8DB = database.getReference("Button8")
        val button9DB = database.getReference("Button9")

        // Read from the database
        button1DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button.setOnClickListener{
                    grid[0][0] = turn
                    if (turn == 1) {
                        val value = "X"
                        button.setText(value)
                        button.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button.setText(value)
                        button.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button1DB.setValue(button.text)
                    button.setEnabled(false)
                }

            }

            override fun onCancelled(error: DatabaseError) { }

        })
       button2DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button2.setOnClickListener{
                    grid[0][1] = turn
                    if (turn == 1) {
                        val value = "X"
                        button2.setText(value)
                        button2.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button2.setText(value)
                        button2.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button2DB.setValue(button2.text)
                    button2.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })

        button3DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button3.setOnClickListener{
                    grid[0][2] = turn
                    if (turn == 1) {
                        val value = "X"
                        button3.setText(value)
                        button3.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button3.setText(value)
                        button3.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button3DB.setValue(button3.text)
                    button3.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        button4DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button4.setOnClickListener{
                    grid[1][0] = turn
                    if (turn == 1) {
                        val value = "X"
                        button4.setText(value)
                        button4.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button4.setText(value)
                        button4.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button4DB.setValue(button4.text)
                    button4.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        button5DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button5.setOnClickListener{
                    grid[1][1] = turn
                    if (turn == 1) {
                        val value = "X"
                        button5.setText(value)
                        button5.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button5.setText(value)
                        button5.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button5DB.setValue(button5.text)
                    button5.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        button6DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button6.setOnClickListener{
                    grid[1][2] = turn
                    if (turn == 1) {
                        val value = "X"
                        button6.setText(value)
                        button6.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button6.setText(value)
                        button6.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button6DB.setValue(button6.text)
                    button6.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        button7DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button7.setOnClickListener{
                    grid[2][0] = turn
                    if (turn == 1) {
                        val value = "X"
                        button7.setText(value)
                        button7.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button7.setText(value)
                        button7.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button7DB.setValue(button7.text)
                    button7.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        button8DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button8.setOnClickListener{
                    grid[2][1] = turn
                    if (turn == 1) {
                        val value = "X"
                        button8.setText(value)
                        button8.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button8.setText(value)
                        button8.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button8DB.setValue(button8.text)
                    button8.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        button9DB.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                button9.setOnClickListener{
                    grid[2][2] = turn
                    if (turn == 1) {
                        val value = "X"
                        button9.setText(value)
                        button9.setTextColor(Color.parseColor("#FF0000"))
                        turn = 2
                    }
                    else{
                        val value = "O"
                        button9.setText(value)
                        button9.setTextColor(Color.parseColor("#808080"))
                        turn = 1
                    }
                    val win = checkwin(grid)
                    if (win) {
                        var wintext = ""
                        if (turn == 1){
                            wintext = "O is the winner!"
                        }
                        else{
                            wintext = "X is the winner!"
                        }
                        winnerText.setText(wintext)
                    }
                    button9DB.setValue(button9.text)
                    button9.setEnabled(false)
                }
            }

            override fun onCancelled(error: DatabaseError) { }

        })
        refreshButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    private fun checkwin(grid: Array<Array<Int>>): Boolean {
        if ((grid[0][0] == grid[0][1]) && (grid[0][0] == grid[0][2])&& grid[0][0] != 0 ){
            return true
        }
        else if((grid[1][0] == grid[1][1]) && (grid[1][0] == grid[1][2])&& grid[1][0] != 0 ){
            return true
        }
        else if((grid[2][0] == grid[2][1]) && (grid[2][0] == grid[2][2])&& grid[2][0] != 0 ){
            return true
        }
        else if((grid[0][0] == grid[1][0]) && (grid[0][0] == grid[2][0])&& grid[0][0] != 0 ){
            return true
        }
        else if((grid[0][1] == grid[1][1]) && (grid[0][1] == grid[2][1])&& grid[0][1] != 0 ){
            return true
        }
        else if((grid[0][2] == grid[1][2]) && (grid[0][2] == grid[2][2])&& grid[0][2] != 0 ){
            return true
        }
        else if((grid[0][0] == grid[1][1]) && (grid[0][0] == grid[2][2])&& grid[0][0] != 0 ){
            return true
        }
        else if((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0])&& grid[0][2] != 0 ){
            return true
        }
        else{
            return false
        }
    }

}