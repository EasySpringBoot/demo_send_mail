package com.easy.springboot.demo_send_mail

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DemoSendMailApplication

fun main(args: Array<String>) {
    runApplication<DemoSendMailApplication>(*args)
}
