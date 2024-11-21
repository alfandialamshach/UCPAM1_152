package com.example.belajar

import android.graphics.Outline
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {


    var nama by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }


    var dataNama by remember { mutableStateOf("") }
    var dataNoHp by remember { mutableStateOf("") }


    var jenisK by remember { mutableStateOf("") }
    var dataJenisK by remember { mutableStateOf("") }
    val dataJk = listOf("Laki - laki","Perempuan")

Column (modifier = modifier.fillMaxSize()){
    tampilanHeader()
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Yuk Lengkapi data dirimu!",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier.fillMaxWidth().padding(2.dp),
            label = {
                Text("Nama")
            },
            placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Face,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Masukkan Nama Anda")
                }
            }
        )
        OutlinedTextField(
            value = noHp,
            onValueChange = { noHp = it },
            modifier = Modifier.fillMaxWidth().padding(2.dp),
            label = {
                Text("Nomer Handphone")
            },
            placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.Call,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Masukkan No Handphone Anda")
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        //
        Column (modifier = Modifier.fillMaxWidth().padding(2.dp)){
            Text("Jenis kelamin")
            Row (modifier = Modifier.fillMaxWidth()){
            dataJk.forEach { selectedJK ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)

                }

            }
            }
        }




        Button(onClick =

        {
            dataNama = nama
            dataJenisK = jenisK
            dataNoHp = noHp

        }, modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth()) {
            Color(0xFF0D92F4)
            Text("Simpan",)

        }
        Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {

                Column {
                    Card {
                        TampilData(
                            Judul = "No Handphone",
                            Isinya = dataJenisK
                        )


                    }
                    Card {TampilData(

                        Judul = "No Handphone",
                        Isinya = dataNoHp
                    ) }

                }




        }
    }
}

}
@Composable
fun TampilData(
    Judul: String,
    Isinya:String
){
    //
    Row(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(Judul, modifier = Modifier.weight(5f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(Isinya, modifier = Modifier.weight(2f))
    }



}

@Composable
fun tampilanHeader() {
    var dataNama by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(bottomEnd = 80f))
            .background(Color(0xFF0D92F4))
            .padding(20.dp)

    ) {
        Row (){
            Box(
                contentAlignment = Alignment.TopStart
            ) {
                Image(
                    painterResource(R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Icon(
                    Icons.Default.Menu, contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.White
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {

                TampilData(
                    Judul = "Nama",
                    Isinya = dataNama
                )

            }
        }
    }
}