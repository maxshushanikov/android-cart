package com.example.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.*
import com.example.shop.core.theme.ShopAppTheme
import com.example.shop.feature.catalog.presentation.ProductListScreen
import com.example.shop.feature.cart.presentation.CartScreen
import com.example.shop.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Catalog.route,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(Screen.Catalog.route) {
                            ProductListScreen(
                                viewModel = hiltViewModel(),
                                onProductClick = { productId ->
                                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                                }
                            )
                        }
                        composable(Screen.Cart.route) {
                            CartScreen(
                                viewModel = hiltViewModel(),
                                onCheckoutClick = { /* Handle Checkout */ }
                            )
                        }
                        composable(Screen.Profile.route) {
                            // ProfileScreen()
                            Box(modifier = Modifier.padding(16.dp)) { Text("Profil Seite") }
                        }
                        // Product Detail composable would go here
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Shop") },
            selected = currentDestination?.route == Screen.Catalog.route,
            onClick = { navController.navigate(Screen.Catalog.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") },
            selected = currentDestination?.route == Screen.Cart.route,
            onClick = { navController.navigate(Screen.Cart.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = currentDestination?.route == Screen.Profile.route,
            onClick = { navController.navigate(Screen.Profile.route) }
        )
    }
}
