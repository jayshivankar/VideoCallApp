package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class VideoCallActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var videoCallBtn: ZegoSendCallInvitationButton
    private lateinit var audioCallBtn : ZegoSendCallInvitationButton
    private lateinit var buttonlayout : LinearLayout
    private lateinit var recevierUserId : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)

        recevierUserId = findViewById(R.id.receiver_user_id_text_field)
        videoCallBtn = findViewById(R.id.video_call_btn)
        audioCallBtn = findViewById(R.id.audio_call_btn)
        buttonlayout = findViewById(R.id.buttons_layout)
        textView = findViewById(R.id.user_id_text_view)

        val userId = intent.getStringExtra("userId")
        textView.text = "Your User ID : $userId !"

        recevierUserId.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val _receiverId = recevierUserId.text.toString()
                if(_receiverId.isNotEmpty()){
                    buttonlayout.visibility = View.VISIBLE
                    startVideoCall(_receiverId)
                    startAudioCall(_receiverId)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })



    }
    private fun startVideoCall(recieverId : String){
        videoCallBtn.setIsVideoCall(true)
        videoCallBtn.resourceID = "zego_uikit_icon_video_call"
        videoCallBtn.setInvitees(listOf(ZegoUIKitUser(recieverId)))
    }
    private fun startAudioCall(recieverId : String){
        audioCallBtn.setIsVideoCall(false)
        audioCallBtn.resourceID = "zego_uikit_icon_audio_call"
        audioCallBtn.setInvitees(listOf(ZegoUIKitUser(recieverId)))
    }



}