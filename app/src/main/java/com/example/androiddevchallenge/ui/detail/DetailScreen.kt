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

package com.example.androiddevchallenge.ui.detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.Cat
import com.example.androiddevchallenge.ui.catList
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DetailScreen(id: Int?) {
    val cat = catList.find { cat -> cat.id == id }

    cat?.let {
        Scaffold(backgroundColor = MaterialTheme.colors.surface) {
            Column {
                DetailCatImage(cat)

                Column(modifier = Modifier.padding(16.dp)) {

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = cat.name,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = cat.description,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {
                    AdoptButton(cat)
                }
            }
        }
    }
}

@Composable
private fun DetailCatImage(cat: Cat) {
    Image(
        modifier = Modifier
            .height(260.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = cat.image),
        contentDescription = null
    )
}

@Composable
private fun AdoptButton(cat: Cat) {
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = {
            Toast.makeText(
                context,
                "Meow",
                Toast.LENGTH_SHORT
            ).show()
        },
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Adopt ${cat.name} Now!",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.surface
        )
    }
}

@Preview
@Composable
fun previewCatDetail() {
    MyTheme(darkTheme = true) {
        DetailScreen(id = 2)
    }
}

@Preview
@Composable
fun previewCatDeatil() {
    MyTheme {
        DetailScreen(id = 3)
    }
}
