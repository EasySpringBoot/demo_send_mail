package com.easy.springboot.demo_send_mail

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoSendMailApplicationTests {

    @Autowired lateinit var MailTool: MailTool

    @Test
    fun testSend() {
        MailTool.send()
    }

}
