package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.catList
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun ListScreen(openDetail: (String) -> Unit) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(R.drawable.ic_pets),
                        contentDescription = stringResource(R.string.app_name)
                    )
                },
            )
        }
    ) {
        CatList(
            cats = catList,
            onSelected = openDetail
        )
    }
}

@Preview
@Composable
fun previewDarkCatList() {
    MyTheme(darkTheme = true) {
        ListScreen { println("") }
    }
}

@Preview
@Composable
fun previewCatList() {
    MyTheme {
        ListScreen { println("") }
    }
}
