package com.example.bootcamp3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RepoDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repo_details)

        val repoData = intent.getParcelableExtra<MyDataItem> (Constants.KEY_INTENT_DATA)
        findViewById<TextView>(R.id.fullName).text = repoData?.full_name.toString()
        findViewById<TextView>(R.id.msg1).text = "LANGUAGE: " + repoData?.language.toString()
        findViewById<TextView>(R.id.msg2).text = "FORKS_COUNT: " + repoData?.forks_count.toString()
        findViewById<TextView>(R.id.msg3).text = "VISIBLITY: " + repoData?.visibility.toString()
        findViewById<TextView>(R.id.msg4).text = "ARCHIVE URL: " + repoData?.archive_url.toString()
        findViewById<TextView>(R.id.msg5).text = "DOWNLOADS_URL: " + repoData?.downloads_url.toString()
        findViewById<TextView>(R.id.msg6).text = "GIT_COMMITS_URL: " + repoData?.git_commits_url.toString()
        findViewById<TextView>(R.id.msg7).text = "COMMENTS_URL: " + repoData?.comments_url.toString()
    }
}