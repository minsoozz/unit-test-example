package com.github.minsoozz.classical

import com.github.minsoozz.MyAccount
import com.github.minsoozz.bank.Bank
import com.github.minsoozz.securities.Securities
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ClassicalUnitTest {

    @Test
    fun `내 계좌 목록을 조회한다`() {
        val myAccount = MyAccount(MockBank(), MockSecurities())
        val accounts = myAccount.get()

        val expectedBanks = listOf("1111-2222", "3333-4444")
        val expectedSecurities = listOf("5555-6666", "7777-8888")

        accounts.banks shouldBe expectedBanks
        accounts.securities shouldBe expectedSecurities
    }
}

private class MockBank : Bank {
    override fun findAll(): List<String> {
        // 가짜 은행 데이터를 반환
        return listOf("1111-2222", "3333-4444")
    }
}

private class MockSecurities : Securities {
    override fun findAll(): List<String> {
        // 가짜 증권사 데이터를 반환
        return listOf("5555-6666", "7777-8888")
    }
}