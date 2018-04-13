package com.easy.springboot.demo_send_mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service


@Service
class MailTool {

    @Autowired lateinit var mailSender: JavaMailSender

    fun send(): Boolean {
        return try {
            val message = SimpleMailMessage()
            message.setFrom("15868187925@163.com")// 发送者
            message.setTo("15868187925@163.com")// 接收者
            message.setSubject("邮件主题")// 邮件主题
            message.setText("这是邮件内容")// 邮件内容
            mailSender.send(message)// 发送邮件
            println("发送成功")
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


    fun sendHtml(): Boolean {
        //使用JavaMail的MimeMessage，支持更加复杂的邮件格式和内容
        val mimeMessage = mailSender.createMimeMessage()
        //创建MimeMessageHelper对象，处理MimeMessage的辅助类
        val helper = MimeMessageHelper(mimeMessage, true)
        return try {
            //使用辅助类MimeMessage设定参数
            helper.setFrom("15868187925@163.com")// 发送者
            helper.setTo("15868187925@163.com")// 接收者
            helper.setSubject("富文本邮件主题")// 邮件主题
            helper.setText("<h1>这是富文本邮件内容</h1><div style='color:red'>你好，Spring Boot！我是 Kotlin。</div>", true)// 邮件内容
            mailSender.send(mimeMessage)// 发送邮件
            println("发送成功")
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun sendHtmlWithAttach(): Boolean {
        val mimeMessage = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(mimeMessage, true)
        return try {
            helper.setFrom("15868187925@163.com")// 发送者
            helper.setTo("15868187925@163.com")// 接收者
            helper.setSubject("富文本带附件的邮件主题")// 邮件主题
            helper.setText("<h1>这是富文本带附件的邮件内容</h1><div style='color:red'>你好，Spring Boot！我是 Kotlin。</div>", true)// 邮件内容
            //加载文件资源，作为附件
            val file = ClassPathResource("kotlin.png")
            //加入附件
            helper.addAttachment("attachment.jpg", file)
            mailSender.send(mimeMessage)// 发送邮件
            println("发送成功")
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}