package com.github.minsoozz.london

import com.github.minsoozz.MyAccount
import com.github.minsoozz.bank.Bank
import com.github.minsoozz.securities.Securities
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class LondonUnitTest {

    @MockK
    lateinit var mockBank: Bank

    @MockK
    lateinit var mockSecurities: Securities

    @InjectMockKs
    lateinit var myAccount: MyAccount

    @Test
    fun `내 계좌 목록을 조회한다`() {
        val fixtureBanks = listOf("1111-2222", "3333-4444")
        val fixtureBanksSecurities = listOf("4444-5555", "6666-7777")
        every { mockBank.findAll() } returns fixtureBanks
        every { mockSecurities.findAll() } returns fixtureBanksSecurities
        val accounts = myAccount.get()

        accounts.banks[0] shouldBe fixtureBanks[0]
        accounts.banks[1] shouldBe fixtureBanks[1]
        accounts.securities[0] shouldBe fixtureBanksSecurities[0]
        accounts.securities[1] shouldBe fixtureBanksSecurities[1]
        accounts.banks shouldBe fixtureBanks
        accounts.securities shouldBe fixtureBanksSecurities
    }
}