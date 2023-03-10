package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesApp()
        }
    }
}

@Composable
fun CoursesApp() {
    CoursesTheme {
        TopicList(topics = DataSource.topics)
    }
}

@Composable
fun TopicList(topics: List<Topic>) {
 LazyVerticalGrid(columns = GridCells.Fixed(2), verticalArrangement = Arrangement.spacedBy(8.dp), horizontalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(8.dp)) {
     items(topics) {
         topic -> TopicCard(topic = topic)
     }
 }
}

@Composable
fun TopicCard(topic: Topic) {
    Card(elevation = 4.dp) {
        Row() {
            Image(painter = painterResource(id = topic.imageResourceId), contentDescription = stringResource(
                id = topic.stringResourceId
            ),  modifier = Modifier
                .width(68.dp)
                .height(68.dp))
            Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
                Text(text = stringResource(id = topic.stringResourceId), modifier = Modifier.padding(bottom = 8.dp), style = MaterialTheme.typography.body2)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                    )
                    Text(text = topic.coursesQuantity.toString(), modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.caption)
                }

            }
        }
    }
}

@Preview
@Composable
fun TopicCardPreview() {
    CoursesTheme {
        TopicCard(topic = Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}