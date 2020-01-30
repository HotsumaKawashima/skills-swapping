package com.android.example.skillsswapping


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.database.Service

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment(), CategoryAdapter.OnItemClickListener {

    private lateinit var txtTitle: TextView
    private lateinit var recyclerView: RecyclerView

    // this is data for recycler view
        val posts = arrayOf(
            Service(
                0,"Art", "private lateinit var txtTitle: TextView\n" +
                        "    private lateinit var recyclerView: RecyclerView\n" +
                        "    private var bundle: Bundle? = null\n" +
                        "    override fun onCreateView(\n" +
                        "        inflater: LayoutInflater, container: ViewGroup?,\n" +
                        "        savedInstanceState: Bundle?\n" +
                        "    ): View? {\n" +
                        "        return inflater.inflate(R.layout.fragment_category, container, false)\n" +
                        "    }"
            , "Online", "$100 for an hour"),
            Service(
                1,"Art",
                "post02post02post02post02post02post02post02"
                , "Online", "$30 for an hour"),
            Service(
                3,"Programming",
                "post03post03post03post03post03post03post03"
                , "Online", "$50 for an hour"
            )
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtTitle = view.findViewById(R.id.category_name_text)
        // 1. get a reference to recyclerView
        recyclerView = view.findViewById(R.id.categoryRecyclerView)

        // 2. set layoutManger
        recyclerView.layoutManager = LinearLayoutManager(getActivity())

        // 3. set adapter
        recyclerView.adapter = CategoryAdapter(posts, this)
        txtTitle.text = arguments?.getString("category")
    }

    override fun onItemClick(item: View?, position: Int) {
        this.findNavController().navigate(
            R.id.action_categoryFragment_to_detailFragment,
            bundleOf("post" to posts[position].description)
        )
    }
}
