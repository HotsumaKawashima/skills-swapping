package com.android.example.skillsswapping


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class TopFragment : Fragment(), View.OnClickListener {
    lateinit var linearArt: LinearLayout
    lateinit var linearMusic: LinearLayout
    lateinit var linearCooking: LinearLayout
    lateinit var linearCoding: LinearLayout
    lateinit var linearBeauty: LinearLayout
    lateinit var linearOthers: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearArt = view.findViewById(R.id.linearArt)
        linearMusic = view.findViewById(R.id.linearMusic)
        linearCooking = view.findViewById(R.id.linearCooking)
        linearCoding = view.findViewById(R.id.linearPrograming)
        linearBeauty = view.findViewById(R.id.linearBeauty)
        linearOthers = view.findViewById(R.id.linearOthers)
        linearArt.setOnClickListener(this)
        linearMusic.setOnClickListener(this)
        linearCooking.setOnClickListener(this)
        linearCoding.setOnClickListener(this)
        linearBeauty.setOnClickListener(this)
        linearOthers.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.linearArt -> Log.d("Tag", "123")
        }
    }

}
