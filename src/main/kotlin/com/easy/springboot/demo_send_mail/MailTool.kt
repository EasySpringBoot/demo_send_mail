package com.easy.springboot.demo_send_mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailTool {

    @Autowired lateinit var mailSender: JavaMailSender

    fun send(): Boolean {
        try {
            val message = SimpleMailMessage()
            message.setFrom("15868187925@163.com")// 发送者
            message.setTo("15868187925@163.com")// 接收者
            message.setSubject("邮件主题")// 邮件主题
            message.setText("这是邮件内容")// 邮件内容
            mailSender.send(message)// 发送邮件
            println("发送成功")
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
}