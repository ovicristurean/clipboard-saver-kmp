package com.ovidiucristurean.clipboardsaver

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform