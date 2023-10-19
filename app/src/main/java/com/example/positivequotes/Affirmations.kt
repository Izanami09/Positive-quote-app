package com.example.positivequotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.positivequotes.data.DataSource
import com.example.positivequotes.model.Affirmation
import com.example.positivequotes.ui.theme.md_theme_dark_onSurfaceVariant


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AffirmationApp(){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.titleMedium)},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = md_theme_dark_onSurfaceVariant
                ))
        }
    ) {
        it -> AffirmationList(affirmationList = DataSource().loadAffirmations(), modifier = Modifier.padding(it))
    }

}


@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier){
        Column {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(id = affirmation.stringResourcedId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = affirmation.stringResourcedId),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier:Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList){
            singleCardAffirmation -> AffirmationCard(
                affirmation = singleCardAffirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
