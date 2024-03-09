package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService

class MainActivity : AppCompatActivity() {
    private lateinit var userIdTextField : EditText
    private lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userIdTextField = findViewById(R.id.user_id_text_field)
        button = findViewById(R.id.button_next)

        button.setOnClickListener {
            val userId = userIdTextField.text.toString()
            if(user)
        }
    }

    private fun videocallServices(userID: String) {
        val appID : Long = 931425084
        val appSign = "589912f4b54cd6086466e4454f1f888d2d2e340f98ba9f8e45961c4a85c6f71f"
        val application = application
        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
        callInvitationConfig.notificationConfig = ZegoNotificationConfig()
        val notificationConfig = ZegoNotificationConfig()
        notificationConfig.sound = "zego_uikit_sound_call"
        notificationConfig.channelID = "CallInvitation"
        notificationConfig.channelName = "CallInvitation"
        ZegoUIKitPrebuiltCallInvitationService.init(application, appID, appSign, userID, userID, callInvitationConfig,)
    }
}