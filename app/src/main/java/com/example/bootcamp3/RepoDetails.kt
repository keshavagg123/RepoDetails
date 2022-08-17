package com.example.bootcamp3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class RepoDetails : AppCompatActivity() {

    fun openWebPage(url: String?) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.repo_details)

        val repoData = intent.getParcelableExtra<MyDataItem> (Constants.KEY_INTENT_DATA)
        findViewById<TextView>(R.id.fullName).text = repoData?.full_name.toString()
        findViewById<TextView>(R.id.msg1).text = "LANGUAGE: " + repoData?.language.toString()
        findViewById<TextView>(R.id.msg2).text = "FORKS_COUNT: " + repoData?.forks_count.toString()
        findViewById<TextView>(R.id.msg3).text = "VISIBLITY: " + repoData?.visibility.toString()
        findViewById<TextView>(R.id.msg4).text = "ARCHIVE URL"
        findViewById<TextView>(R.id.msg5).text = "DOWNLOADS_URL"
        findViewById<TextView>(R.id.msg6).text = "GIT_COMMITS_URL"
        findViewById<TextView>(R.id.msg7).text = "COMMENTS_URL"
        findViewById<TextView>(R.id.msg8).text = "COMMITS_URL"
        findViewById<TextView>(R.id.msg9).text = "SUBSCRIBERS_URL"
        findViewById<TextView>(R.id.msg10).text = "SUBSCRIPTION_URL"

        findViewById<TextView>(R.id.msg4).setOnClickListener { openWebPage(repoData?.archive_url.toString()) }
        findViewById<TextView>(R.id.msg5).setOnClickListener { openWebPage(repoData?.downloads_url.toString()) }
        findViewById<TextView>(R.id.msg6).setOnClickListener { openWebPage(repoData?.git_commits_url.toString()) }
        findViewById<TextView>(R.id.msg7).setOnClickListener { openWebPage(repoData?.comments_url.toString()) }
        findViewById<TextView>(R.id.msg8).setOnClickListener { openWebPage(repoData?.commits_url.toString()) }
        findViewById<TextView>(R.id.msg9).setOnClickListener { openWebPage(repoData?.subscribers_url.toString()) }
        findViewById<TextView>(R.id.msg10).setOnClickListener { openWebPage(repoData?.subscription_url.toString()) }
    }
}