package com.example.movieapp.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.ui.theme.MovieAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    movieList: List<String> =
        listOf(
            "Bahubali",
            "Interstellar",
            "KGF",
            "Game Of Thrones",
            "Vikings",
            "Peacemaker",
            "Knives Out",
            "No Time To Die",
            "Transformers"
        )
) {
    Scaffold(
        topBar =
        {
            TopAppBar(
                title = { Text(text = "Movies") }
            )
        }

    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp),

            contentPadding = PaddingValues(10.dp)
        ) {


            items(movieList) {
                ListItem(movie = it){
                    navController.navigate(MovieScreens.DetailsScreen.name+"/$it")
                }
            }
        }
    }
}

@Composable
fun ListItem(movie: String,onItemClick : () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onItemClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Movie Image",
                modifier = Modifier.size(100.dp)
            )
            Text(text = movie)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MovieAppTheme {
        HomeScreen(rememberNavController())
    }
}