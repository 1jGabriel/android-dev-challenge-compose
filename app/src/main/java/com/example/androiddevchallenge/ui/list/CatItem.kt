/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.Cat
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CatItem(cat: Cat, onSelected: (String) -> Unit) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    onSelected(cat.id.toString())
                }
            )
            .clip(RoundedCornerShape(4.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = CenterVertically
        ) {
            CatImage(image = cat.image)
            CatName(name = cat.name)
        }
    }
}

@Composable
fun CatImage(@DrawableRes image: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = Modifier
            .size(60.dp, 60.dp)
            .clip(RoundedCornerShape(percent = 50)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CatName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.subtitle1,
        overflow = TextOverflow.Ellipsis,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Center,
        maxLines = 1
    )
}

@Preview
@Composable
fun CatItemPreviewDarkThemed() {
    MyTheme(darkTheme = true) {
        CatItem(
            cat = Cat(
                image = R.drawable.black_cat,
                name = "Zezinho 12312 3212 123 132 123 123 123 1",
                description = "",
                id = 0
            ),
            onSelected = {
                /*TODO*/
            }
        )
    }
}

@Preview
@Composable
fun CatItemPreview() {
    MyTheme {
        CatItem(
            cat = Cat(
                id = 0,
                image = R.drawable.black_cat,
                name = "Zezinho",
                description = ""
            ),
            onSelected = {
                /*TODO*/
            }
        )
    }
}
