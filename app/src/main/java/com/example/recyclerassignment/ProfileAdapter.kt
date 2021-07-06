package com.example.recyclerassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerassignment.databinding.LayoutItemViewBinding

class ProfileAdapter (val profiles: List<Profiles>, var clickListener: OnProfilelistener) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>(){
    inner class ProfileViewHolder (private val binding: LayoutItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(profiles: Profiles) {
            binding.profilelogo.setImageResource(profiles.logo)
            binding.profilefname.text = profiles.firstName
            binding.profilelname.text = profiles.lastName
        }
        fun initialize (profiles: Profiles, action:OnProfilelistener){
            binding.profilefname.text=profiles.firstName
            binding.profilelname.text=profiles.lastName
            binding.profilelogo.setImageResource(profiles.logo)
            binding.root.setOnClickListener {
                action.onItemClick(profiles, adapterPosition)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding: LayoutItemViewBinding=
            LayoutItemViewBinding.inflate(LayoutInflater.from(parent.context))
        return ProfileViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.bind(profile)
        holder.initialize(profiles[position], clickListener)
    }

    override fun getItemCount(): Int {
        return profiles.size
    }


}
interface OnProfilelistener{
    fun onItemClick(profiles: Profiles,position: Int)
}