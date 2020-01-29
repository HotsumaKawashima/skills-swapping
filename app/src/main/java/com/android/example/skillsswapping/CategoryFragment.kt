package com.android.example.skillsswapping


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.skillsswapping.domain.Post

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    private lateinit var txtTitle: TextView
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // this is data for recycler view
        val posts = arrayOf(
            Post(" private lateinit var txtTitle: TextView\n" +
                    "    private lateinit var recyclerView: RecyclerView\n" +
                    "    private var bundle: Bundle? = null\n" +
                    "    override fun onCreateView(\n" +
                    "        inflater: LayoutInflater, container: ViewGroup?,\n" +
                    "        savedInstanceState: Bundle?\n" +
                    "    ): View? {\n" +
                    "        return inflater.inflate(R.layout.fragment_category, container, false)\n" +
                    "    }"),
            Post("post02post02post02post02post02post02post02"),
            Post("post03post03post03post03post03post03post03"),
            Post("post04post04post04post04post04post04post04"),
            Post("post05post05post05post05post05post05post05"),
            Post("post06post06post06post06post06post06post06")
        )

        txtTitle = view.findViewById(R.id.category_name_text)
        // 1. get a reference to recyclerView
         recyclerView = view.findViewById(R.id.categoryRecyclerView)

        // 2. set layoutManger
        recyclerView.layoutManager = LinearLayoutManager(getActivity())

        // 3. set adapter
        recyclerView.adapter = CategoryAdapter(posts)
        txtTitle.text = arguments?.getString("category")
    }
}
