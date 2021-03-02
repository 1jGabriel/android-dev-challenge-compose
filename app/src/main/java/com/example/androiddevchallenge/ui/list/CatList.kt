package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.Cat
import com.example.androiddevchallenge.ui.detail.DetailScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CatList(
    cats: List<Cat>,
    onSelected: (String) -> Unit
) {
    LazyColumn {
        items(cats) { cat ->
            CatItem(cat = cat, onSelected = onSelected)
            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
            )
        }
    }
}
