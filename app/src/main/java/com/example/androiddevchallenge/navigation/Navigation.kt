package com.example.androiddevchallenge.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.navigation.Navigation.CAT_DETAIL_SCREEN

object Navigation {
    const val CATS_SCREEN = "cats"
    const val CAT_DETAIL_SCREEN = "catDetail"

    object CatsDetailArgs {
        const val CAT_ID = "id"
    }
}

class Actions(navController: NavHostController) {
    val openDetail: (String) -> Unit =
        { id ->
            navController.navigate("$CAT_DETAIL_SCREEN/$id")
            println("$CAT_DETAIL_SCREEN/{$id}")
        }

    val navigateBack: () -> Unit = { navController.popBackStack() }
}