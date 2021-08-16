package org.techtown.kotiinstudy07

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.kotiinstudy07.MusicAdapter.MyViewHolder
import org.techtown.kotiinstudy07.databinding.MusicBinding

class MusicAdapter : RecyclerView.Adapter<MusicAdapter.MyViewHolder>()  {

    var items = ArrayList<Music>()

    inner class MyViewHolder(binding: MusicBinding) : RecyclerView.ViewHolder(binding.root){
        //새로운 변수 선언 , 위젯을 할당
        val title = binding.title
        val singer = binding.singer
        val root = binding.root         //클릭등 기능 구현 위해 선언
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //뷰 홀더 생성
        val binding = MusicBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.singer.text = item.singer

        holder.root.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                items.removeAt(position)
                notifyItemRemoved(position)                     //특정 포지션 항목만 갱신
                notifyItemRangeChanged(position , items.size)   //여러개가 변경된 경우
                return true
            }
        })

    }

    override fun getItemCount() = items.size
}