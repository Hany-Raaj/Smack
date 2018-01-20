package com.example.hanyr.smack.Model

/**
 * Created by Hanyr on 21-Jan-18.
 */
class Channel(val name: String, val description: String, val id: String) {
    override fun toString(): String {
        return "#$name"
    }
}