package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.ListaDeAlunos
import com.example.myapplication.model.Aluno
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiarioClass()
                }
            }
        }
    }
}





@Composable
fun DiarioClass() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
       LazyColumn{
           items(ListaDeAlunos().carregarListaDeAlunos()){
               aluno -> Configuração(aluno = aluno)
           }
       }
    }

}

@Composable
fun Configuração(
    aluno: Aluno
) {

    var expadir by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(Color(225, 184, 215, 100)),
        modifier = Modifier
            .fillMaxWidth()
            .height(215.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxHeight()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = aluno.foto),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(
                        text = aluno.nome,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = aluno.curso,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 18.sp,

                    )
                }
                Spacer(modifier = Modifier.width(80.dp))
                Icon(
                    imageVector =
                    if (expadir)
                        Icons.Filled.KeyboardArrowDown
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { expadir = !expadir }
                )
            }
            if (expadir) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Faltas: ${aluno.faltas}",
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Nota: ${aluno.nota}",
                    fontSize = 15.sp
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewCard() {
    Configuração(
        aluno = Aluno(
            nome = "Laura",
            curso = "Kotlin"
        )
    )
}
       
       
        


        

        
