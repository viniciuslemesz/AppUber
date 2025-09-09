package com.example.appuber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appuber.ui.theme.AppUberTheme

class PrimeiraTela : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUberTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home(){
    Scaffold(
        bottomBar = { BarraNav() }
    )
    {
        Modifier.padding(it)
    }
}

@Composable
fun BarraNav()
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp) ,
            verticalAlignment = Alignment.CenterVertically,


        )
        {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Icone home",
                modifier = Modifier.size(21.dp)
            )
            Text(text = "Home")


            Spacer(modifier = Modifier.width(24.dp))
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = "Icone op",
                modifier = Modifier.size(18.dp)
            )
            Text(text = "Opções")


            Spacer(modifier = Modifier.width(24.dp))
            Icon(
                imageVector = Icons.Outlined.Build,
                contentDescription = "Icone atividade",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "Ativdade")


            Spacer(modifier = Modifier.width(24.dp))
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Icone perfil",
                modifier = Modifier.size(21.dp)
            )
            Text(text = "Conta")
        }
    }

}


@Preview
@Composable
fun PreviewTelaDeTarefas() {
    AppUberTheme {
        Home()
    }
}
