package com.ahasanidea.kotlin.roomdatabase

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.ahasanidea.kotlin.roomdatabase.adapter.UserListAdapter
import com.ahasanidea.kotlin.roomdatabase.model.User
import com.ahasanidea.kotlin.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), UserListAdapter.OnClickListener {
    override fun onItemClick(u: User) {
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra("userObject", u); // sending our object
        startActivity(intent)
    }

    override fun onItemDelete(u: User) {
        showAlertDelete(u)
    }
    private fun showAlertDelete(u: User) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Confirm Delete...")
        alertDialog.setMessage("Are you sure you want delete this?")
        alertDialog.setIcon(android.R.drawable.ic_delete)
        alertDialog.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
            userRecyclerViewModel!!.deleteItem(u)
        })
        alertDialog.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
        })
        alertDialog.show()
    }

    private var userRecyclerViewModel: UserViewModel? = null
    private var myAdapter: UserListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }
        myAdapter = UserListAdapter(ArrayList<User>())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
        myAdapter!!.setListener(this)

        userRecyclerViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userRecyclerViewModel!!.getAllUsers().observe(this, Observer<List<User>> { t ->
            myAdapter!!.addItems(t as ArrayList<User>)
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onResume() {
        super.onResume()
        myAdapter!!.notifyDataSetChanged()
    }

}
