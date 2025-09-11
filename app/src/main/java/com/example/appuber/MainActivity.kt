package com.example.appuber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.vector.ImageVector

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
    Text(text="Uber")
    Scaffold(
        topBar = {BarraPesquisa()},
        bottomBar = {BarraNav()},
    )
    { paddingValues -> // lambda
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            TelaPrincipal()
        }
    }
}

@Composable
fun BarraNav()
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Gray)
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

@Composable
fun BarraPesquisa() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 34.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Uber",
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }

    Spacer(modifier = Modifier.height(25.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 75.dp, start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(16.dp))

    ) {
        Spacer(modifier = Modifier.width(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .clip(RoundedCornerShape(16.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Icone Pesquisa",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Pesquisar Destino...")
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
        Spacer(modifier = Modifier.height(30.dp))



}

@Composable
fun TelaPrincipal() {


    Column()
    {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .width(300.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Icon(
                imageVector = Icons.Outlined.Refresh,
                contentDescription = "Icone visitados",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Praça Osório...")

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .width(300.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
        )
        {


            Icon(
                imageVector = Icons.Outlined.Refresh,
                contentDescription = "Icone visitados",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Praça Rui Barbosa...")
        }
    }
    Spacer(modifier = Modifier.height(25.dp))

    Text(
        text = "Sugestões",
        modifier = Modifier.padding(start = 12.dp, top = 16.dp),
    )
    Spacer(modifier = Modifier.height(15.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        CardDeSugestao("Viagem", Icons.Outlined.LocationOn)

        CardDeSugestao("Envios", Icons.Outlined.ShoppingCart)

        CardDeSugestao("Moto", Icons.Outlined.ArrowForward)
    }

    Spacer(modifier = Modifier.height(15.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .width(300.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Magenta),
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Text(text="TESTANDO")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .width(300.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Magenta),
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        Text(text="TESTANDO")
    }

}

@Composable
fun CardDeSugestao(texto: String, icone: ImageVector) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icone,
            contentDescription = texto,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = texto)
    }
}


@Preview
@Composable
fun PreviewPrimeiraTela() {
    AppUberTheme {
        Home()
    }
}
