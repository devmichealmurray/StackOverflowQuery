package com.devtides.stackoverflowquery.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.stackoverflowquery.R
import com.devtides.stackoverflowquery.model.Answer
import kotlinx.android.synthetic.main.answer_layout.view.*

class AnswersAdapter(private val answers: ArrayList<Answer>) :
    RecyclerView.Adapter<AnswersAdapter.AdapterViewHolder>() {

    fun addAnswers(newAnswers: List<Answer>) {
        val currentLength = answers.size
        answers.addAll(newAnswers)
        notifyItemInserted(currentLength)
    }

    class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.item_answer

        fun bind(answer: Answer) {
            title.text = answer.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder =
        AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.answer_layout, parent, false)
        )

    override fun getItemCount(): Int = answers.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(answers[position])
    }
}