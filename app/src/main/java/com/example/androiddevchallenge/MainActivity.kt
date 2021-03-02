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

package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.navigation.Actions
import com.example.androiddevchallenge.navigation.Navigation
import com.example.androiddevchallenge.navigation.Navigation.CatsDetailArgs.CAT_ID
import com.example.androiddevchallenge.ui.detail.DetailScreen
import com.example.androiddevchallenge.ui.list.ListScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val actions = remember(navController) { Actions(navController) }
            MyTheme {
                myNavHost(navController = navController, actions = actions)
            }
        }
    }

    @Composable
    fun myNavHost(
        navController: NavHostController,
        actions: Actions
    ) {
        NavHost(
            navController = navController,
            startDestination = Navigation.CATS_SCREEN
        ) {
            composable(route = Navigation.CATS_SCREEN) {
                ListScreen(actions.openDetail)
            }

            composable(
                route = "${Navigation.CAT_DETAIL_SCREEN}/{$CAT_ID}",
                arguments = listOf(
                    navArgument(CAT_ID) {
                        type = NavType.StringType
                    }
                )
            ) {
                DetailScreen(
                    id = it.arguments?.getString(CAT_ID)?.toInt()
                )
            }
        }
    }
}
