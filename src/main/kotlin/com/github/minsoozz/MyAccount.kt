package com.github.minsoozz

import com.github.minsoozz.bank.Bank
import com.github.minsoozz.securities.Securities

class MyAccount(
    private val bank: Bank,
    private val securities: Securities
) {
    fun get(): Accounts {
        return Accounts(bank.findAll(), securities.findAll())
    }
}

data class Accounts(
    val banks: List<String>,
    val securities: List<String>
)